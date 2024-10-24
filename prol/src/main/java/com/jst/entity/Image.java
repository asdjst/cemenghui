package com.jst.entity;

public class Image {
    private int image_id;
    private String image;
    private String tel;

    public String getImage() {
        return image;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }
}
