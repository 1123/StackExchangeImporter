package org.stackexchange.dumps.importer.domain;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


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

    public String getTitle() { return title; }

    @Id
    @XmlAttribute(name = "Id")
    private Integer id;

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

    @XmlAttribute(name = "Title")
    @Column(columnDefinition="TEXT")
    private String title;

    @XmlAttribute(name = "Tags")
    private String tags;

    /**
     * Unfortunately, the tags are not delivered as structured xml, but encoded within a single XML attribute value. Therefore
     * manual parsing is necessary here. This method is not used when saving the data to the database. It may be useful for postprocessing though.
     *
     * For running reports based upon tags it may be useful to compute a many to many relationship between posts and tags.
     *
     * @return the list of tags
     */
    public List<String> getTagList() {
        String unescaped = StringEscapeUtils.unescapeHtml4(this.tags);
        String trimmed = unescaped.substring(1, unescaped.length() - 1);
        return Arrays.asList(trimmed.split("><"));
    }

}
