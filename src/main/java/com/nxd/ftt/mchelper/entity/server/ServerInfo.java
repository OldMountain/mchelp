package com.nxd.ftt.mchelper.entity.server;

import com.google.gson.Gson;

/**
 * ServerInfo
 *
 * @author luhangqi
 * @date 2018/6/7
 */
public class ServerInfo {


    private Description description;
    private Players players;
    private Version version;
    private String favicon;

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
