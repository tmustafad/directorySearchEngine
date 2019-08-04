package com.turkmen.util;

import com.turkmen.service.CacheService;
import com.turkmen.service.impl.CacheServiceImpl;
import com.turkmen.service.impl.SearchServiceImpl;

public class AppUtil {

    private AppUtil() {
        throw new UnsupportedOperationException();
    }

    public static SearchServiceImpl createSearchService(){
        return new SearchServiceImpl();
    }

    public static CacheService createCacheService(){
        return new CacheServiceImpl();
    }
}
