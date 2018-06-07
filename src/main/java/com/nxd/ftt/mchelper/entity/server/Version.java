package com.nxd.ftt.mchelper.entity.server;

/**
 * Version
 *
 * @author luhangqi
 * @date 2018/6/7
 */
public class Version {
    /**
     * name : §a在线人数: §b0§d/§2100
     * protocol : -1
     */

    private String name;
    private int protocol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProtocol() {
        return protocol;
    }

    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }
}
