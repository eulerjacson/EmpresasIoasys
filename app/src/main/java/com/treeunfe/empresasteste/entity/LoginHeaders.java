package com.treeunfe.empresasteste.entity;

public class LoginHeaders {
    private String uid;
    private String client;
    private String accessToken;

    public LoginHeaders(String uid, String client, String accessToken) {
        this.uid = uid;
        this.client = client;
        this.accessToken = accessToken;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
