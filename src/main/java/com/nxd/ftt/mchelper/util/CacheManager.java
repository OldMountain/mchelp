package com.nxd.ftt.mchelper.util;

import com.nxd.ftt.mchelper.entity.Cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ServerCache
 *
 * @author luhangqi
 * @date 2018/6/21
 */
public class CacheManager {

    private final static Map<String, Cache> map = new ConcurrentHashMap<>();

    public void putCache(String key, Cache cache) {
        map.put(key, cache);
    }

    public void putCache(String key, Object data, long timeOut) {
        timeOut = timeOut > 0 ? timeOut : 0L;
        map.put(key, new Cache(data, timeOut, System.currentTimeMillis()));
    }

    public Cache getCache(String key) {
        return isExist(key);
    }

    public Object getData(String key) {
        Cache cache = isExist(key);
        return cache != null ? cache.getData() : null;
    }

    private Cache isExist(String key) {
        if (map.containsKey(key)) {
            Cache cache = map.get(key);
            if ((cache.getLastRefreshTime() + cache.getTimeOut()) > System.currentTimeMillis()) {
                return cache;
            } else {
                map.remove(key);
                return null;
            }
        } else {
            return null;
        }
    }


}
