package org.stackexchange.dumps.importer.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@Entity
@XmlRootElement(name = "row")
public class Vote {

    @Id
    @XmlAttribute(name = "Id")
    public int id;

    @XmlAttribute(name = "PostId")
    public int postId;

    @XmlAttribute(name = "VoteTypeId")
    public int voteTypeId;

    @XmlAttribute(name = "CreationDate")
    public Date creationDate;

}
