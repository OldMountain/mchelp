package com.nxd.ftt.mchelper.entity.server;

import java.util.List;

/**
 * McServerInfo
 *
 * @author luhangqi
 * @date 2018/10/30
 */
public class McServerInfo {
    /**
     */

    private String description;
    private PlayersBean players;
    private VersionBean version;
    private String favicon;
    private ModinfoBean modinfo;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PlayersBean getPlayers() {
        return players;
    }

    public void setPlayers(PlayersBean players) {
        this.players = players;
    }

    public VersionBean getVersion() {
        return version;
    }

    public void setVersion(VersionBean version) {
        this.version = version;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    public ModinfoBean getModinfo() {
        return modinfo;
    }

    public void setModinfo(ModinfoBean modinfo) {
        this.modinfo = modinfo;
    }

    public static class PlayersBean {
        /**
         * max : 100
         * online : 0
         * sample : [{"id":"104f0e78-06ec-3b5b-8421-425b6949d446","name":"§b这只是玩家列表"}]
         */

        private int max;
        private int online;
        private List<SampleBean> sample;

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

        public List<SampleBean> getSample() {
            return sample;
        }

        public void setSample(List<SampleBean> sample) {
            this.sample = sample;
        }

        public static class SampleBean {
            /**
             * id : 104f0e78-06ec-3b5b-8421-425b6949d446
             * name : §b这只是玩家列表
             */

            private String id;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class VersionBean {
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

    public static class ModinfoBean {
        /**
         * type : FML
         * modList : [{"modid":"mcp","version":"9.05"},{"modid":"FML","version":"7.10.99.99"},{"modid":"Forge","version":"10.13.4.1614"},{"modid":"kimagine ","version":"0.2"},{"modid":"DQRCore","version":"1.0.0"},{"modid":"PotionExtensionCore","version":"1.7.10-1.1.0"},{"modid":"DQMIIINext","version":"0.8.6.3"},{"modid":"levelup","version":"0.10"}]
         */

        private String type;
        private List<ModListBean> modList;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<ModListBean> getModList() {
            return modList;
        }

        public void setModList(List<ModListBean> modList) {
            this.modList = modList;
        }

        public static class ModListBean {
            /**
             * modid : mcp
             * version : 9.05
             */

            private String modid;
            private String version;

            public String getModid() {
                return modid;
            }

            public void setModid(String modid) {
                this.modid = modid;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }
        }
    }
}
