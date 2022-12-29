package com.apress.catalog.configuration;

import com.apress.catalog.model.Country;
import com.apress.catalog.serializer.CountrySerializer;
import com.apress.catalog.serializer.LongSerializer;
import io.lettuce.core.ReadFrom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStaticMasterReplicaConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {

    final RedisSettings settings;
    final LongSerializer longSerializer;

    final CountrySerializer countrySerializer;

    public RedisConfiguration(RedisSettings settings, LongSerializer longSerializer,
                              CountrySerializer countrySerializer) {
        this.settings = settings;
        this.longSerializer = longSerializer;
        this.countrySerializer = countrySerializer;
    }

    @Bean
    public RedisTemplate<Long, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Long, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        //template.setKeySerializer(longSerializer);
        return template;
    }

    @Bean
    public RedisTemplate<Long, Country> countryRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Long, Country> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(longSerializer);
        template.setValueSerializer(countrySerializer);
        return template;
    }


    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .readFrom(ReadFrom.REPLICA_PREFERRED)
                .build();
        RedisStaticMasterReplicaConfiguration staticMasterReplicaConfiguration = new RedisStaticMasterReplicaConfiguration(settings.getMaster().getHost(),
                settings.getMaster().getPort());
        settings.getSlaves().forEach(slave -> staticMasterReplicaConfiguration.addNode(slave.getHost(), slave.getPort()));
        return new LettuceConnectionFactory(staticMasterReplicaConfiguration, clientConfig);
    }
}
