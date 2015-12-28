package org.stackexchange.querying;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="se_user")
@Data
@NoArgsConstructor
public class UserR {

    @Id
    public int id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<BadgeR> badges;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<PostR> posts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<CommentR> comments;

    public int downVotes;
    public int upVotes;
    public int views;

    public int reputation;

    public String displayName;

    public UserR(int id) {
        this.id = id;
        this.downVotes = 0;
        this.upVotes = 0;
        this.views = 0;
    }

}

