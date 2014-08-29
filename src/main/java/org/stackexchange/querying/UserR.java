package org.stackexchange.querying;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="se_user")
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

    public UserR() {
        // for hibernate
    }

    public List<CommentR> getComments() {
        return comments;
    }

    public void setComments(List<CommentR> comments) {
        this.comments = comments;
    }

    public List<PostR> getPosts() {
        return posts;
    }

    public void setPosts(List<PostR> posts) {
        this.posts = posts;
    }

    public List<BadgeR> getBadges() {
        return badges;
    }

    public void setBadges(List<BadgeR> badges) {
        this.badges = badges;
    }
}

