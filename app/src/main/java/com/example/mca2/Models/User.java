package com.example.mca2.Models;

import android.widget.ImageView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private  String id;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("profilePicture")
    @Expose
    private String profilePicture;
    @SerializedName("userAvatar")
    @Expose
    private String userAvatar;
    // po potreba da nema default-en konstruktor
    /*private User (String userName, String password){
        this.userName = userName;
        this.password = password;
    }*/

    public String getId() {return id;}
    public String getUserName(){ return userName;}
    public String getPassword(){return password;}
    public String getCreatedAt(){return createdAt;}
    public String getProfilePicture(){return profilePicture;}
    public String getUserAvatar() {return userAvatar;}

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    /*
    String username;
    String password;
    ImageView profilePicture;

    public User () {
        username = "username";
        password = "password";
    }

   /* public User (String username, String password ,ImageView profilePicture){
        this.username = username;
        this.password = password;
        this.ImageView = ImageView;
    }*//*
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public ImageView getProfilePicture(){
        return profilePicture;
    }
    */
}
