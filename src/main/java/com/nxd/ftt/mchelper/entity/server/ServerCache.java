package com.nxd.ftt.mchelper.entity.server;

/**
 * ServerCache
 *
 * @author OldMountain
 * @date 2018/6/9
 */
public class ServerCache {

    private Object data;
    private long timeOut;
    private long lastRefreshTime;

    public ServerCache(Object data, long timeOut, long lastRefreshTime) {
        this.data = data;
        this.timeOut = timeOut;
        this.lastRefreshTime = lastRefreshTime;
    }

    public Object getData() {
        return data;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public long getLastRefreshTime() {
        return lastRefreshTime;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public void setLastRefreshTime(long lastRefreshTime) {
        this.lastRefreshTime = lastRefreshTime;
    }
}
