package org.stackexchange.dumps.importer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

//  <row Id="1" PostHistoryTypeId="2" PostId="1" RevisionGUID="0c0a2a64-8fac-428d-95a1-9ea8eae674c0" CreationDate="2010-07-28T19:04:21.300" UserId="5" Text="Everytime I turn on my computer, I see a message saying something like:&#xD;&#xA;&#xD;&#xA;&gt; Your battery may be old or broken. Etc...&#xD;&#xA;&#xD;&#xA;I know my battery is not working. How can I make the message go away?" />


@Entity
@XmlRootElement(name = "row")
public class PostHistory {

    @Id
    @XmlAttribute(name = "Id")
    public int id;

    @XmlAttribute(name = "PostId")
    public int postId;

    @XmlAttribute(name = "UserId")
    public int userId;

    @XmlAttribute(name = "PostHistoryTypeId")
    public int postHistoryTypeId;

    @XmlAttribute(name = "RevisionGUID")
    public String revisionGUID;

    @XmlAttribute(name = "CreationDate")
    public Date creationDate;

    @Column(columnDefinition="TEXT")
    @XmlAttribute(name = "Text")
    public String text;

}
