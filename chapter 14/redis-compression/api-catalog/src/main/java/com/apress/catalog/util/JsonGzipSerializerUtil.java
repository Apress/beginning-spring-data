package com.apress.catalog.util;

import com.apress.catalog.exception.SerializeException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonGzipSerializerUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonGzipSerializerUtil.class);
    private static final ObjectMapper OBJECT_MAPPER;

    private JsonGzipSerializerUtil() {
        // just to avoid create instances
    }

    //General definition about how transform the information into a String or an Object
    static {
        OBJECT_MAPPER = new ObjectMapper()
                .configure(MapperFeature.USE_GETTERS_AS_SETTERS, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .registerModule(new JavaTimeModule());
    }

    //Transform an object into an array de bytes which is compressed
    public static byte[] serialize(Object object) {
        byte[] compressedJson;
        try {
            String json = OBJECT_MAPPER.writeValueAsString(object);
            compressedJson = CompressionUtil.compress(json);
        } catch (IOException e) {
            LOGGER.error("Error serializing object: {}", e.getMessage());
            throw new SerializeException("Can't serialize object", e);
        }
        return compressedJson;
    }

    //Transform an array de bytes which is compressed into a specific object define it on the <T>
    public static <T> T deserialize(byte[] raw, Class<T> reference) {
        if (raw == null)
            return null;

        T object;
        try {
            String json = CompressionUtil.decompress(raw);
            object = OBJECT_MAPPER.readValue(json, reference);
        } catch (IOException e) {
            LOGGER.error("Can't deserialize object: {}", e.getMessage());
            throw new SerializeException("Can't deserialize object.", e);
        }
        return object;
    }
}