package com.qf.vmovie.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class ViewPagerBean {


    /**
     * status : 0
     * msg : OK
     * data : [{"bannerid":"1063","title":"","image":"http://cs.vmoiver.com/Uploads/Banner/2016/07/25/579587edb0e4c.jpg","description":"","addtime":"1469417456","extra":"{\"app_banner_type\":\"2\",\"app_banner_param\":\"49635\"}","end_time":"0","extra_data":{"app_banner_type":"2","app_banner_param":"49635","is_album":"1"}},{"bannerid":"1064","title":"","image":"http://cs.vmoiver.com/Uploads/Banner/2016/07/26/5796d4a756b86.jpg","description":"","addtime":"1469502632","extra":"{\"app_banner_type\":\"2\",\"app_banner_param\":\"49643\"}","end_time":"0","extra_data":{"app_banner_type":"2","app_banner_param":"49643","is_album":"0"}},{"bannerid":"1062","title":"","image":"http://cs.vmoiver.com/Uploads/Banner/2016/07/22/5791ba0f9bb49.jpg","description":"","addtime":"1469168145","extra":"{\"app_banner_type\":\"2\",\"app_banner_param\":\"49599\"}","end_time":"0","extra_data":{"app_banner_type":"2","app_banner_param":"49599","is_album":"1"}},{"bannerid":"1065","title":"","image":"http://cs.vmoiver.com/Uploads/Banner/2016/07/26/5796d4c2212d1.jpg","description":"","addtime":"1469502659","extra":"{\"app_banner_type\":\"2\",\"app_banner_param\":\"49607\"}","end_time":"0","extra_data":{"app_banner_type":"2","app_banner_param":"49607","is_album":"0"}},{"bannerid":"1057","title":"","image":"http://cs.vmoiver.com/Uploads/Banner/2016/07/20/578f3ed6be682.jpg","description":"","addtime":"1469005527","extra":"{\"app_banner_type\":\"2\",\"app_banner_param\":\"49613\"}","end_time":"0","extra_data":{"app_banner_type":"2","app_banner_param":"49613","is_album":"0"}}]
     */

    private String status;
    private String msg;
    /**
     * bannerid : 1063
     * title :
     * image : http://cs.vmoiver.com/Uploads/Banner/2016/07/25/579587edb0e4c.jpg
     * description :
     * addtime : 1469417456
     * extra : {"app_banner_type":"2","app_banner_param":"49635"}
     * end_time : 0
     * extra_data : {"app_banner_type":"2","app_banner_param":"49635","is_album":"1"}
     */

    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String bannerid;
        private String title;
        private String image;
        private String description;
        private String addtime;
        private String extra;
        private String end_time;
        /**
         * app_banner_type : 2
         * app_banner_param : 49635
         * is_album : 1
         */

        private ExtraDataBean extra_data;

        public String getBannerid() {
            return bannerid;
        }

        public void setBannerid(String bannerid) {
            this.bannerid = bannerid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getExtra() {
            return extra;
        }

        public void setExtra(String extra) {
            this.extra = extra;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public ExtraDataBean getExtra_data() {
            return extra_data;
        }

        public void setExtra_data(ExtraDataBean extra_data) {
            this.extra_data = extra_data;
        }

        public static class ExtraDataBean {
            private String app_banner_type;
            private String app_banner_param;
            private String is_album;

            public String getApp_banner_type() {
                return app_banner_type;
            }

            public void setApp_banner_type(String app_banner_type) {
                this.app_banner_type = app_banner_type;
            }

            public String getApp_banner_param() {
                return app_banner_param;
            }

            public void setApp_banner_param(String app_banner_param) {
                this.app_banner_param = app_banner_param;
            }

            public String getIs_album() {
                return is_album;
            }

            public void setIs_album(String is_album) {
                this.is_album = is_album;
            }
        }
    }
}
