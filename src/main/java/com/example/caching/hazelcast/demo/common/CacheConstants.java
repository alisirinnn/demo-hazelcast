package com.example.caching.hazelcast.demo.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CacheConstants {

    public static final String MAP_THIRTY_SECONDS_CACHE = "MAP_THIRTY_SECONDS_CACHE";
    public static final String MAP_TWO_MINUTES_CACHE = "MAP_TWO_MINUTES_CACHE";
    public static final String MAP_THIRTY_MINUTES_CACHE = "MAP_THIRTY_MINUTES_CACHE";
    public static final String MAP_SIXTY_MINUTES_CACHE = "MAP_SIXTY_MINUTES_CACHE";

}
