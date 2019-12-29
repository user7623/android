package com.example.mca2.Models;

import com.google.gson.annotations.SerializedName;

public class Retro {
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("url")
    private String url;

    public Retro(String username, String password, String url){
        this.username = username;
        this.password = password;
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
