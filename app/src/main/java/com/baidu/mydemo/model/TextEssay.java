package com.baidu.mydemo.model;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Project: MyDemo
 * Author: wm
 * Data:   16-5-27
 */
public class TextEssay {

    private String context;

    private String userName;

    private String avatarUrl;

    private String content;

    public void parseJson(JSONObject json) throws JSONException {
        if (json != null) {

            JSONObject group = json.getJSONObject("group");

            content = group.getString("content");

            JSONObject user = group.getJSONObject("user");

            userName = user.getString("name");

            avatarUrl = user.getString("avatar_url");
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getContent() {
        return content;
    }
}
