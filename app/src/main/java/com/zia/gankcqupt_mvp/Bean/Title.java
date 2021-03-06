package com.zia.gankcqupt_mvp.Bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zia on 2017/5/29.
 */

public class Title implements Serializable {
    private String author;
    private String time;
    private Date updatedAt;
    private Date createdAt;
    private String title;
    private String content;
    private String count;
    private String headUrl;
    private String objectId;
    private String userId;

    @Override
    public String toString() {
        return "author:"+author+"\ntime:"+time+"\ntitle:"+title+"\ncontent:"+content+"\ncount:"+count+"\nurl:"+headUrl+"\nobjectId:"+objectId+"\nuserId:"+userId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
}
