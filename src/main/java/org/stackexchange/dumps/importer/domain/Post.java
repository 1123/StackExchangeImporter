package org.stackexchange.dumps.importer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@Entity
@XmlRootElement(name = "row")
public class Post {

    public Integer getId() {
        return id;
    }

    public Integer getOwnerUserId() {
        return ownerUserId;
    }

    public Integer getPostTypeId() {
        return postTypeId;
    }

    public Integer getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public Integer getScore() {
        return score;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public String getBody() {
        return body;
    }

    @Id
    @XmlAttribute(name = "Id")
    private Integer id;

    @XmlAttribute(name = "UserId")
    private Integer userId;

    @XmlAttribute(name = "OwnerUserId")
    private Integer ownerUserId;

    @XmlAttribute(name = "ParentId")
    private Integer parentId;

    @XmlAttribute(name = "PostTypeId")
    private Integer postTypeId;

    @XmlAttribute(name = "AcceptedAnswerId")
    private Integer acceptedAnswerId;

    @XmlAttribute(name = "Score")
    private Integer score;

    @XmlAttribute(name = "CreationDate")
    private Date creationDate;

    @XmlAttribute(name = "LastEditDate")
    private Date lastEditDate;

    @XmlAttribute(name = "LastActivityDate")
    private Date lastActivityDate;

    @XmlAttribute(name = "ViewCount")
    private Integer viewCount;

    @XmlAttribute (name = "AnswerCount")
    private Integer answerCount;

    @XmlAttribute(name = "CommentCount")
    private Integer commentCount;

    @XmlAttribute(name = "FavoriteCount")
    private Integer favoriteCount;

    @XmlAttribute(name = "Body")
    @Column(columnDefinition="TEXT")
    private String body;

    public Integer getUserId() {
        return userId;
    }
}
