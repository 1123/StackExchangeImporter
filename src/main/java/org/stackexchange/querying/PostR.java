package org.stackexchange.querying;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="post")
public class PostR {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    private List<CommentR> comments;

    @Id
    public int id;

    public List<CommentR> getComments() {
        return comments;
    }

    public void setComments(List<CommentR> comments) {
        this.comments = comments;
    }
}

