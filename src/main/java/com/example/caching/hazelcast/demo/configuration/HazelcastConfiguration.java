package com.example.caching.hazelcast.demo.configuration;

import com.example.caching.hazelcast.demo.common.CacheConstants;
import com.hazelcast.config.CacheDeserializedValues;
import com.hazelcast.config.Config;
import com.hazelcast.config.InMemoryFormat;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class HazelcastConfiguration {

    @Bean
    public HazelcastInstance getInstance() {
        return Hazelcast.newHazelcastInstance(config());
    }

    public Config config() {
        Config config = new Config("hazelcast-instance" + UUID.randomUUID().toString());
        config.addMapConfig(getMapConfig(CacheConstants.MAP_THIRTY_SECONDS_CACHE, 1, 30));
        config.addMapConfig(getMapConfig(CacheConstants.MAP_TWO_MINUTES_CACHE, 1, 120));
        config.addMapConfig(getMapConfig(CacheConstants.MAP_THIRTY_MINUTES_CACHE, 1, 1800));
        config.addMapConfig(getMapConfig(CacheConstants.MAP_SIXTY_MINUTES_CACHE, 1, 3600));
        return config;
    }

    private MapConfig getMapConfig(String name, int backupCount, int ttl) {
        MapConfig map = new MapConfig();
        map.setName(name);
        map.setInMemoryFormat(InMemoryFormat.BINARY);
        map.setBackupCount(backupCount);
        map.setTimeToLiveSeconds(ttl);
        map.setMaxIdleSeconds(ttl);
        map.setCacheDeserializedValues(CacheDeserializedValues.INDEX_ONLY);
        return map;
    }

}
