package org.stackexchange.querying;

import javax.persistence.*;

@Entity()
@Table(name="comment")
public class CommentR {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostR post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserR user;

    @Id
    public Integer id;

    public Integer score = 0;

    public PostR getPost() {
        return post;
    }

    public void setPost(PostR post) {
        this.post = post;
    }

    public UserR getUser() {
        return user;
    }

    public void setUser(UserR user) {
        this.user = user;
    }
}
