package org.stackexchange.querying;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="post")
@Data
public class PostR {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
    private List<CommentR> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_user_id")
    private UserR user;

    private String body;

    @Id
    public int id;

    public int score = 0;

}

