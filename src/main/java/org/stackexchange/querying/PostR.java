package org.stackexchange.querying;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="post")
public class PostR {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
    private List<CommentR> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_user_id")
    private UserR user;

    @Id
    public int id;

    public int score = 0;

    public List<CommentR> getComments() {
        return comments;
    }

    public void setComments(List<CommentR> comments) {
        this.comments = comments;
    }

    public UserR getUser() {
        return user;
    }

    public void setUser(UserR user) {
        this.user = user;
    }
}

