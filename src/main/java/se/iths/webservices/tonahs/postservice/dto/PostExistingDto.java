package se.iths.webservices.tonahs.postservice.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class PostExistingDto {

    @NotNull(message = "ID cannot be empty")
    private String id;
    @NotNull(message = "Text cannot be empty")
    private String text;
    @NotNull(message = "User ID cannot be empty")
    private String userId;
    private String parentId;
    private Date created;


    public String getId() {
        return id;
    }

    public PostExistingDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public PostExistingDto setText(String text) {
        this.text = text;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public PostExistingDto setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public PostExistingDto setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public PostExistingDto setCreated(Date created) {
        this.created = created;
        return this;
    }
}
