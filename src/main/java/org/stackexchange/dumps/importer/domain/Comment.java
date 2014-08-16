package org.stackexchange.dumps.importer.domain;

// "  <row Id=\"41\" PostId=\"47\" Score=\"1\" Text=\"Might be related to https://bugs.kde.org/show_bug.cgi?id=222014 - in any case, I have the same problem on Gentoo so it definitely seems to be a Kate bug, not anything specific to Kubuntu.\" CreationDate=\"2010-07-28T19:51:00.770\" UserId=\"104\" />\n";

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@XmlRootElement(name = "row")
public class Comment {

    public Comment() {
        // for jpa
    }

    @XmlAttribute(name = "PostId")
    public int postId;

    @Id
    @XmlAttribute(name = "Id")
    public int id;

    @XmlAttribute(name = "Score")
    public int score;

    @XmlAttribute(name = "Text")
    @Column(columnDefinition="TEXT")
    public String text;

    @XmlAttribute(name = "CreationDate")
    public Date creationDate;

    @XmlAttribute(name = "UserId")
    public int userId;

    public Comment(int commentId) {
        this.id = commentId;
    }

}

