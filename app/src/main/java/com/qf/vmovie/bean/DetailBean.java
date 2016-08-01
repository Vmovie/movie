package com.qf.vmovie.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
public class DetailBean {


    /**
     * status : 0
     * msg : OK
     * data : {"postid":"49659","title":"杀手自嗨丧命幽默短片《唱歌的杀手》","app_fu_title":"","intro":"无聊似乎是任何人都难以抵抗的洪水猛兽。人在无聊的时候，总会想方设法去消磨时间。本片中的杀手也不例外，因为被杀对象行程有变，致使他无缘无故多出了漫长的等待时间。\n怎样打发时间呢？杀手似乎很快找到了乐子，他打开收音机，跟着电台的音乐伴奏，在车厢内开始了一段自嗨的演唱会。时间仿佛流逝得很快，他也玩得不亦乐乎，可是却将最重要的使命抛之脑后，最终暴露了自己，被自己的猎杀对象反杀。\n影片到此戛然而止，笑果却达到了顶峰，导演Josh Soskin用一个反转\u200b，告诉了我们千万不要自己作死的道理。\nJosh Soskin出生于加利福利亚的一个小镇，最初以拍摄纪录片开启导演生涯，为Current TV拍摄过许多纪录片，其中《Modern Day Pirates》为他赢得了国内声誉，Vanguard称之为死之前必看的50部纪录片之一。2007年，导演离开了Current TV，开始世界各地旅游，在西班牙投资创立了Houseblend传媒公司，此后导演开始了商业短片、电视的创作，2012年加入Station Film for commercial directing（商业导演电影协会）。我们之前推荐过类似的短片《请勿挂断》，也是在夹缝时间内自嗨消遣，只不过没有人像本片的男主一样悲催，会因此丧命。\n影片中杀手伴唱的背景音乐来自红心乐团（Heart）的《what about love》，八十年代美国西雅图首屈一指的重量级女性摇滚乐团，流传着许多脍炙人口的经典歌曲。","count_comment":"33","is_album":"0","is_collect":"0","content":{"video":[{"image":"http://cs.vmoiver.com/Uploads/cover/2016-07-25/5795dfadb14e4_cut.jpeg","title":"杀手自嗨丧命幽默短片《唱歌的杀手》","duration":"207","filesize":"34654098","source_link":"http://v.youku.com/v_show/id_XMTY1Nzc2OTk0NA==.html","qiniu_url":"http://bsy.qiniu.vmovier.vmoiver.com/5795e048cfb26.mp4"}]},"image":"http://cs.vmoiver.com/Uploads/cover/2016-07-25/5795dfadb14e4_cut.jpeg","rating":"8.0","publish_time":"1469577660","count_like":"331","count_share":"519","cate":["搞笑"],"share_link":{"sweibo":"http://www.vmovier.com/49659?debug=1&_vfrom=VmovierApp_sweibo","weixin":"http://www.vmovier.com/49659?debug=1&_vfrom=VmovierApp_weixin","qzone":"http://www.vmovier.com/49659?debug=1&_vfrom=VmovierApp_qzone","qq":"http://www.vmovier.com/49659?debug=1&_vfrom=VmovierApp_qq"},"tags":"","share_sub_title":"请把你的歌带回你的家\u2026\u2026","weibo_share_image":"http://service.vmoiver.com/h5/Imagick/vmovier_weibo_share?id=49659"}
     */

    private String status;
    private String msg;

    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String postid;
        private String title;
        private String app_fu_title;
        private String intro;
        private String count_comment;
        private String is_album;
        private String is_collect;
        private ContentBean content;
        private String image;
        private String rating;
        private String publish_time;
        private String count_like;
        private String count_share;
        /**
         * sweibo : http://www.vmovier.com/49659?debug=1&_vfrom=VmovierApp_sweibo
         * weixin : http://www.vmovier.com/49659?debug=1&_vfrom=VmovierApp_weixin
         * qzone : http://www.vmovier.com/49659?debug=1&_vfrom=VmovierApp_qzone
         * qq : http://www.vmovier.com/49659?debug=1&_vfrom=VmovierApp_qq
         */

        private ShareLinkBean share_link;
        private String tags;
        private String share_sub_title;
        private String weibo_share_image;
        private List<String> cate;

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getApp_fu_title() {
            return app_fu_title;
        }

        public void setApp_fu_title(String app_fu_title) {
            this.app_fu_title = app_fu_title;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getCount_comment() {
            return count_comment;
        }

        public void setCount_comment(String count_comment) {
            this.count_comment = count_comment;
        }

        public String getIs_album() {
            return is_album;
        }

        public void setIs_album(String is_album) {
            this.is_album = is_album;
        }

        public String getIs_collect() {
            return is_collect;
        }

        public void setIs_collect(String is_collect) {
            this.is_collect = is_collect;
        }

        public ContentBean getContent() {
            return content;
        }

        public void setContent(ContentBean content) {
            this.content = content;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(String publish_time) {
            this.publish_time = publish_time;
        }

        public String getCount_like() {
            return count_like;
        }

        public void setCount_like(String count_like) {
            this.count_like = count_like;
        }

        public String getCount_share() {
            return count_share;
        }

        public void setCount_share(String count_share) {
            this.count_share = count_share;
        }

        public ShareLinkBean getShare_link() {
            return share_link;
        }

        public void setShare_link(ShareLinkBean share_link) {
            this.share_link = share_link;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getShare_sub_title() {
            return share_sub_title;
        }

        public void setShare_sub_title(String share_sub_title) {
            this.share_sub_title = share_sub_title;
        }

        public String getWeibo_share_image() {
            return weibo_share_image;
        }

        public void setWeibo_share_image(String weibo_share_image) {
            this.weibo_share_image = weibo_share_image;
        }

        public List<String> getCate() {
            return cate;
        }

        public void setCate(List<String> cate) {
            this.cate = cate;
        }

        public static class ContentBean {
            /**
             * image : http://cs.vmoiver.com/Uploads/cover/2016-07-25/5795dfadb14e4_cut.jpeg
             * title : 杀手自嗨丧命幽默短片《唱歌的杀手》
             * duration : 207
             * filesize : 34654098
             * source_link : http://v.youku.com/v_show/id_XMTY1Nzc2OTk0NA==.html
             * qiniu_url : http://bsy.qiniu.vmovier.vmoiver.com/5795e048cfb26.mp4
             */

            private List<VideoBean> video;

            public List<VideoBean> getVideo() {
                return video;
            }

            public void setVideo(List<VideoBean> video) {
                this.video = video;
            }

            public static class VideoBean {
                private String image;
                private String title;
                private String duration;
                private String filesize;
                private String source_link;
                private String qiniu_url;

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDuration() {
                    return duration;
                }

                public void setDuration(String duration) {
                    this.duration = duration;
                }

                public String getFilesize() {
                    return filesize;
                }

                public void setFilesize(String filesize) {
                    this.filesize = filesize;
                }

                public String getSource_link() {
                    return source_link;
                }

                public void setSource_link(String source_link) {
                    this.source_link = source_link;
                }

                public String getQiniu_url() {
                    return qiniu_url;
                }

                public void setQiniu_url(String qiniu_url) {
                    this.qiniu_url = qiniu_url;
                }
            }
        }

        public static class ShareLinkBean {
            private String sweibo;
            private String weixin;
            private String qzone;
            private String qq;

            public String getSweibo() {
                return sweibo;
            }

            public void setSweibo(String sweibo) {
                this.sweibo = sweibo;
            }

            public String getWeixin() {
                return weixin;
            }

            public void setWeixin(String weixin) {
                this.weixin = weixin;
            }

            public String getQzone() {
                return qzone;
            }

            public void setQzone(String qzone) {
                this.qzone = qzone;
            }

            public String getQq() {
                return qq;
            }

            public void setQq(String qq) {
                this.qq = qq;
            }
        }
    }
}
