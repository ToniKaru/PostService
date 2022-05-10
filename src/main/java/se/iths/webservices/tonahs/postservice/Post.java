package se.iths.webservices.tonahs.postservice;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
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
    private final String text;

    @NonNull
    @NotBlank
    @BsonProperty
    private final Long userId;


    @Nullable
    @BsonProperty
    private final ObjectId parentId;


    public Post(@NotBlank @BsonProperty String text,
                @NotBlank @BsonProperty Long userId) {
        this(text, userId, null);
    }

    @BsonCreator
    public Post(@NotBlank @BsonProperty String text,
                @NotBlank @BsonProperty Long userId,
                @BsonProperty ObjectId parentId) {
        this.text = text;
        this.userId = userId;
        this.parentId = parentId;
    }


    @NonNull
    public String getText() {
        return text;
    }

    public Long getUserId() {
        return userId;
    }

    @Nullable
    public ObjectId getParentId() {
        return parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return text.equals(post.text) && userId.equals(post.userId) && Objects.equals(parentId, post.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, userId, parentId);
    }
}
