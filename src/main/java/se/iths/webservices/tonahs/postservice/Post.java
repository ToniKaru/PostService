package se.iths.webservices.tonahs.postservice;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Document("posts")
public class Post {

    @Id
    private String id;

    @NonNull
    @NotBlank
    @BsonProperty
    private String text;

    @NonNull
    @NotBlank
    @BsonProperty
    private String userId;


    @Nullable
    @BsonProperty
    private String parentId;


    public Post (){
        this("default", "userId", null);
    }

    public Post(@NotBlank @BsonProperty String text,
                @NotBlank @BsonProperty String userId) {
        this(text, userId, null);
    }

    @BsonCreator
    public Post(@NotBlank @BsonProperty String text,
                @NotBlank @BsonProperty String userId,
                @BsonProperty String parentId) {
        this.text = text;
        this.userId = userId;
        this.parentId = parentId;
    }


    public String getId() {
        return id;
    }

    public Post setId(String id) {
        this.id = id;
        return this;
    }

    @NonNull
    public String getText() {
        return text;
    }

    public Post setText(@NonNull String text) {
        this.text = text;
        return this;
    }

    @NonNull
    public String getUserId() {
        return userId;
    }

    public Post setUserId(@NonNull String userId) {
        this.userId = userId;
        return this;
    }

    @Nullable
    public String getParentId() {
        return parentId;
    }

    public Post setParentId(@Nullable String parentId) {
        this.parentId = parentId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return text.equals(post.text) && userId.equals(post.userId) && Objects.equals(parentId, post.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, userId, parentId);
    }
}
