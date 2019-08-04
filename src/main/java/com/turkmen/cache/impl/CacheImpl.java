package com.turkmen.cache.impl;

import com.turkmen.cache.Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CacheImpl implements Cache<Map> {

    private static CacheImpl searchCacheImpl;

    private static Map<String, Set<String>> directoryMap;

    {
        directoryMap = new HashMap();
    }

    private CacheImpl() {
        System.out.println("Cache initialized.....");
    }


    public static CacheImpl getInstance() {
        if (searchCacheImpl == null) {
            searchCacheImpl = new CacheImpl();
        }
        return searchCacheImpl;
    }

    @Override
    public Map get() {
        return directoryMap;
    }
}
