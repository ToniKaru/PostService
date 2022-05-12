package se.iths.webservices.tonahs.postservice.dto;


import java.util.Date;

public class PostDto {

    private String id;
    private String text;
    private String userId;
    private String parentId;
    private Date created;



    public String getId() {
        return id;
    }

    public PostDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public PostDto setText(String text) {
        this.text = text;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public PostDto setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public PostDto setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public PostDto setCreated(Date created) {
        this.created = created;
        return this;
    }
}
