package org.stackexchange.dumps.importer.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@XmlRootElement(name = "row")
public class SeUser {

    @Id
    @XmlAttribute(name = "Id")
    public int id;

    @XmlAttribute(name = "Reputation")
    public int reputation;

    @XmlAttribute(name = "CreationDate")
    public Date creationDate;

    @XmlAttribute(name = "DisplayName")
    public String displayName;

    @XmlAttribute(name = "LastAccessDate")
    public Date lastAccessDate;

    @XmlAttribute(name = "Location")
    public String location;

    @XmlAttribute(name = "AboutMe")
    @Column(columnDefinition="TEXT")
    public String aboutMe;

    @XmlAttribute(name = "Views")
    public int views;

    @XmlAttribute(name = "UpVotes")
    public int upVotes;

    @XmlAttribute(name = "DownVotes")
    public int downVotes;

    @XmlAttribute(name = "EmailHash")
    public String emailHash;

}
