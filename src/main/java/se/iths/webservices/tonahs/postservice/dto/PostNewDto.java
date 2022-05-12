package se.iths.webservices.tonahs.postservice.dto;


import javax.validation.constraints.NotNull;

public class PostNewDto {

//    @NotNull(message = "ID cannot be empty")
//    private String id;
    @NotNull(message = "Text cannot be empty")
    private String text;
    private String userId;
    private String parentId;


//    public String getId() {
//        return id;
//    }
//
//    public PostNewDto setId(String id) {
//        this.id = id;
//        return this;
//    }

    public String getText() {
        return text;
    }

    public PostNewDto setText(String text) {
        this.text = text;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public PostNewDto setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public PostNewDto setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }
}
