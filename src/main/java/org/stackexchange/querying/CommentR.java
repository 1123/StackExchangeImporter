package org.stackexchange.querying;

import javax.persistence.*;

@Entity()
@Table(name="comment")
public class CommentR {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostR post;

    @Id
    public Integer id;

    public PostR getPost() {
        return post;
    }

    public void setPost(PostR post) {
        this.post = post;
    }
}
