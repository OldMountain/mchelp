package com.nxd.ftt.mchelper.entity;

/**
 * Cache
 *
 * @author luhangqi
 * @date 2018/6/21
 */
public class Cache {

    private Object data;
    private long timeOut;
    private long lastRefreshTime;

    public Cache() {
    }

    public Cache(Object data, long timeOut) {
        this.data = data;
        this.timeOut = timeOut;
    }

    public Cache(Object data, long timeOut, long lastRefreshTime) {
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
