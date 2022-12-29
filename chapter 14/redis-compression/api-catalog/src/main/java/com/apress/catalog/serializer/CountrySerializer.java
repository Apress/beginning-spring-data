package com.apress.catalog.serializer;

import com.apress.catalog.model.Country;
import com.apress.catalog.util.JsonGzipSerializerUtil;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class CountrySerializer implements RedisSerializer<Country> {

    public byte[] serialize(Country country) {
        return JsonGzipSerializerUtil.serialize(country);
    }

    public Country deserialize(byte[] raw) {
        return JsonGzipSerializerUtil.deserialize(raw, Country.class);
    }
}
