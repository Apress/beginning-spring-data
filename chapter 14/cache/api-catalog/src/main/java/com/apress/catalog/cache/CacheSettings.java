package com.apress.catalog.cache;

import java.util.Objects;

public class CacheSettings {

    private Integer refreshAfterWriteTime;
    private Integer expireAfterWriteTime;
    private Integer maxSize;

    private static final Integer DEFAULT_REFRESH_AFTER = 10;
    private static final Integer DEFAULT_EXPIRE_AFTER = 15;
    private static final Integer DEFAULT_MAX_SIZE = 180;

    public static final CacheSettings DEFAULT_CACHE_SETTINGS = new CacheSettings(DEFAULT_REFRESH_AFTER,
            DEFAULT_EXPIRE_AFTER, DEFAULT_MAX_SIZE);

    public CacheSettings() {
    }

    public CacheSettings(Integer refreshAfterWriteTime, Integer expireAfterWriteTime, Integer maxSize) {
        this.refreshAfterWriteTime = refreshAfterWriteTime;
        this.expireAfterWriteTime = expireAfterWriteTime;
        this.maxSize = maxSize;
    }

    public Integer getRefreshAfterWriteTime() {
        return refreshAfterWriteTime;
    }

    public void setRefreshAfterWriteTime(Integer refreshAfterWriteTime) {
        this.refreshAfterWriteTime = refreshAfterWriteTime;
    }

    public Integer getExpireAfterWriteTime() {
        return expireAfterWriteTime;
    }

    public void setExpireAfterWriteTime(Integer expireAfterWriteTime) {
        this.expireAfterWriteTime = expireAfterWriteTime;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CacheSettings that = (CacheSettings) o;
        return Objects.equals(refreshAfterWriteTime, that.refreshAfterWriteTime)
                && Objects.equals(expireAfterWriteTime, that.expireAfterWriteTime)
                && Objects.equals(maxSize, that.maxSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refreshAfterWriteTime, expireAfterWriteTime, maxSize);
    }

    @Override
    public String toString() {
        return "CacheSettings{" + "refreshAfter=" + refreshAfterWriteTime + ", expireAfter=" + expireAfterWriteTime
                + ", maxSize=" + maxSize + '}';
    }
}