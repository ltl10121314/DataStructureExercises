//package com.datastructureexercises.redis;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author liutianlong
// */
//public class LocalSetting extends AbstractSetting {
//    private Map<String, String> cache = new HashMap<>();
//
//    @Override
//    protected String lookupCache(String key) {
//        return cache.get(key);
//    }
//
//    @Override
//    protected void putIntoCache(String key, String value) {
//        cache.put(key, value);
//    }
//}
