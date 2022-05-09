package se.iths.webservices.tonahs.postservice;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotBlank;



public class Post {

    @NonNull
    @NotBlank
    @BsonProperty
    private final String text;

    @NonNull
    @NotBlank
    @BsonProperty
    private final long userId;


    @Nullable
    @BsonProperty
    private final ObjectId parentId;


    public Post(@NotBlank @BsonProperty String text,
                @NotBlank @BsonProperty long userId) {
        this(text, userId, null);
    }

    @BsonCreator
    public Post(@NotBlank @BsonProperty String text,
                @NotBlank @BsonProperty long userId,
                @BsonProperty ObjectId parentId) {
        this.text = text;
        this.userId = userId;
        this.parentId = parentId;
    }


    @NonNull
    public String getText() {
        return text;
    }

    public long getUserId() {
        return userId;
    }

    @Nullable
    public ObjectId getParentId() {
        return parentId;
    }
}
