package com.nxd.ftt.mchelper.entity.server;

import java.util.List;

/**
 * Players
 *
 * @author luhangqi
 * @date 2018/6/7
 */
public class Players {
    /**
     * max : 100
     * online : 0
     * sample : [{"id":"104f0e78-06ec-3b5b-8421-425b6949d446","name":"§b这只是玩家列表"}]
     */

    private int max;
    private int online;
    private List<Sample> sample;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public List<Sample> getSample() {
        return sample;
    }

    public void setSample(List<Sample> sample) {
        this.sample = sample;
    }
}
