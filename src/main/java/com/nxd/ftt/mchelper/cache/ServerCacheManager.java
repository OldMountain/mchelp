package com.nxd.ftt.mchelper.cache;

import com.nxd.ftt.mchelper.entity.server.ServerCache;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * ServerCacheManager
 *
 * @author OldMountain
 * @date 2018/6/9
 */
public class ServerCacheManager {
    private static Map<String, ServerCache> cacheMap = new ConcurrentSkipListMap<>();

    public void putCache(String key, ServerCache serverCache) {
        cacheMap.put(key, serverCache);
    }

    public void putCache(String key, Object data, long timeOut) {
        putCache(key, new ServerCache(data, timeOut, System.currentTimeMillis()));
    }

    public ServerCache getCache(String key) {
        ServerCache cache = isTimOut(key);
        if (cache != null) {
            return cache;
        }
        return null;
    }

    public Object getCacheData(String key) {
        ServerCache cache = isTimOut(key);
        if (cache != null) {
            return cache.getData();
        }
        return null;
    }

    /**
     * 是否超时
     *
     * @param key
     * @return
     */
    public ServerCache isTimOut(String key) {
        if (cacheMap.containsKey(key)) {
            ServerCache cache = cacheMap.get(key);
            if ((System.currentTimeMillis() - cache.getLastRefreshTime()) < cache.getTimeOut()) {
                return cache;
            }else{
                cacheMap.remove(key);
            }
        }
        return null;
    }

}
