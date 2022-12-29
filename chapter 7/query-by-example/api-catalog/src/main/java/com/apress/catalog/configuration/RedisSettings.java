package com.apress.catalog.configuration;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@ConfigurationProperties(prefix = "redis")
@Configuration
public class RedisSettings {
    private RedisProperties master;
    private List<RedisProperties> slaves;

    public RedisProperties getMaster() {
        return master;
    }

    public void setMaster(RedisProperties master) {
        this.master = master;
    }

    public List<RedisProperties> getSlaves() {
        return slaves;
    }

    public void setSlaves(List<RedisProperties> slaves) {
        this.slaves = slaves;
    }
}
