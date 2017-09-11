package com.data.entity;

/**
 * Created by Administrator on 2017/8/14.
 */
public class StreamInfo {

    /**
     * mime_type : application/octet-stream
     * updatedAt : 2017-08-14T02:08:13.230Z
     * key : fa1714956ab8203b446b.lrc
     * name : bb.lrc
     * objectId : 5991060d1b69e60058ea0cd9
     * createdAt : 2017-08-14T02:08:13.230Z
     * __type : File
     * url : http://ac-5jX830BX.clouddn.com/fa1714956ab8203b446b.lrc
     * provider : qiniu
     * metaData : {"size":1329,"owner":"unknown"}
     * bucket : 5jX830BX
     */

    private PictureBean picture;
    /**
     * picture : {"mime_type":"application/octet-stream","updatedAt":"2017-08-14T02:08:13.230Z","key":"fa1714956ab8203b446b.lrc","name":"bb.lrc","objectId":"5991060d1b69e60058ea0cd9","createdAt":"2017-08-14T02:08:13.230Z","__type":"File","url":"http://ac-5jX830BX.clouddn.com/fa1714956ab8203b446b.lrc","provider":"qiniu","metaData":{"size":1329,"owner":"unknown"},"bucket":"5jX830BX"}
     * createdAt : 2017-08-14T02:08:13.403Z
     * updatedAt : 2017-08-14T02:08:13.403Z
     * objectId : 5991060d570c3500615a4583
     */

    private String createdAt;
    private String updatedAt;
    private String objectId;

    public PictureBean getPicture() {
        return picture;
    }

    public void setPicture(PictureBean picture) {
        this.picture = picture;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public static class PictureBean {
        private String mime_type;
        private String updatedAt;
        private String key;
        private String name;
        private String objectId;
        private String createdAt;
        private String __type;
        private String url;
        private String provider;
        /**
         * size : 1329
         * owner : unknown
         */

        private MetaDataBean metaData;
        private String bucket;

        public String getMime_type() {
            return mime_type;
        }

        public void setMime_type(String mime_type) {
            this.mime_type = mime_type;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String get__type() {
            return __type;
        }

        public void set__type(String __type) {
            this.__type = __type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }

        public MetaDataBean getMetaData() {
            return metaData;
        }

        public void setMetaData(MetaDataBean metaData) {
            this.metaData = metaData;
        }

        public String getBucket() {
            return bucket;
        }

        public void setBucket(String bucket) {
            this.bucket = bucket;
        }

        public static class MetaDataBean {
            private int size;
            private String owner;

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getOwner() {
                return owner;
            }

            public void setOwner(String owner) {
                this.owner = owner;
            }
        }
    }
}
