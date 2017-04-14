package com.suninfo.rxtest.Movie.model;

/**
 * author: zh on 2017/4/13.
 */

public class MovieInfo {

    /**
     * id : 722452014
     * user_id : 1062143259
     * url : http://www.meipai.com/media/722452014
     * cover_pic : http://mvimg2.meitudata.com/58ec42b52bf6e3804.jpg!thumb320
     * screen_name : 内涵神评论
     * caption : 这时候给我钱，明显我是卖的@阿葩罩爷 @阿阿阿阿圣 互动话题：评论告诉我你谁还欠你钱💰，说不定ta就看见了！😘为自己的机智，请双击点赞！#女神##搞笑##我要上热门#
     * avatar : http://mvavatar2.meitudata.com/571c2e8baa4133415.jpg
     * plays_count : 346451
     * comments_count : 63
     * likes_count : 4418
     * created_at : 1491878577
     */

    private int id;
    private int user_id;
    private String url;
    private String cover_pic;
    private String screen_name;
    private String caption;
    private String avatar;
    private int plays_count;
    private int comments_count;
    private int likes_count;
    private String created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCover_pic() {
        return cover_pic;
    }

    public void setCover_pic(String cover_pic) {
        this.cover_pic = cover_pic;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getPlays_count() {
        return plays_count;
    }

    public void setPlays_count(int plays_count) {
        this.plays_count = plays_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
