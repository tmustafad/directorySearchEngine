package com.turkmen.cache;


import com.turkmen.cache.impl.CacheImpl;

/**
 * <h1>The main interface for the in memory cache</h1>
 *
 * @author  Turkmen
 * @see CacheImpl
 * @version 1.0
 * @since   2019-08-04
 *
 *
 */

public interface Cache<T> {

    T get();
}
