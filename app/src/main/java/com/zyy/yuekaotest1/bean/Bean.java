package com.zyy.yuekaotest1.bean;

/**
 * description
 * Created by 张芸艳 on 2017/6/10.
 */

public class Bean {
    private String title;
    private String content;

    public Bean(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Bean(String title) {
        this.title = title;
    }

    public Bean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
