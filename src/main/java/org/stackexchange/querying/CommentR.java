package org.stackexchange.querying;

import lombok.Data;

import javax.persistence.*;

@Entity()
@Table(name="comment")
@Data
public class CommentR {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostR post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserR user;

    @Column(columnDefinition="TEXT")
    public String text;

    @Id
    public Integer id;

    public Integer score = 0;

}
