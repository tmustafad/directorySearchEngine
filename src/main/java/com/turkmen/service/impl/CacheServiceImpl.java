package com.turkmen.service.impl;

import com.turkmen.cache.impl.CacheImpl;
import com.turkmen.service.CacheService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class CacheServiceImpl implements CacheService {

    private CacheImpl cache;

    {
        cache = CacheImpl.getInstance();
    }

    @Override
    public void loadDirectories(Path path) {


        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String line;
            while ((line = reader.readLine()) != null) {
                Stream.of(line.split(" "))
                        .forEach(i -> {
                            if (cache.get().containsKey(i)) {
                                ((Set) cache.get().get(i)).add(path.getFileName().toString());
                            } else {
                                Set<String> tmpList = new HashSet<>();
                                tmpList.add(path.getFileName().toString());
                                cache.get().put(i, tmpList);
                            }
                        });
            }


        } catch (IOException exception) {
            System.out.println("IO Exception");
            exception.printStackTrace();
        }
    }
}
