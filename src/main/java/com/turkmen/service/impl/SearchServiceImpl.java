package com.turkmen.service.impl;

import com.turkmen.cache.impl.CacheImpl;
import com.turkmen.service.SearchService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class SearchServiceImpl implements SearchService {

    private Map<String, Integer> resultMap;
    private static int wordFactor = 0;

    private CacheImpl cache;

    {
        cache = CacheImpl.getInstance();
        resultMap = new HashMap();
    }

    @Override
    public Map<String, Integer> search(String keyword) {


        Stream.of(keyword.split(" "))
                .filter(i -> cache.get().get(i) != null)
                .forEach(this::setResultMap);
        return this.resultMap;
    }


    public void setWordFactor(String keywords) {

        wordFactor = 100 / (keywords.split(" ").length == 1 ? 1 : keywords.split(" ").length);

    }

    private void setResultMap(String key) {

        ((Set) cache.get().get(key)).stream().forEach(i -> resultMap.put((String) i, resultMap.get(i) != null ? resultMap.get(i) + wordFactor : wordFactor));
    }


    public Map<String, Integer> getResultMap() {
        return resultMap;
    }


}

