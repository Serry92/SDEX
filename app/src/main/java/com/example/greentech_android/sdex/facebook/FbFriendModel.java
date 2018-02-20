package com.example.greentech_android.sdex.facebook;

/**
 * Created by GreenTech-Android on 2/20/2018.
 */

public class FbFriendModel {
    private String id;
    private String name;
    private String imgURL;


    public FbFriendModel(String name, String imgURL) {
        this.name = name;
        this.imgURL = imgURL;
    }

    public FbFriendModel() {

    }

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

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

}
