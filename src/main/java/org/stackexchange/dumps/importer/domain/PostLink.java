package org.stackexchange.dumps.importer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 *   <row Id="104" CreationDate="2014-01-21T22:26:32.303" PostId="105" RelatedPostId="5" LinkTypeId="1" />
 */
@Entity
@XmlRootElement(name = "row")
public class PostLink {

    @Id
    @XmlAttribute(name = "Id")
    public int id;

    @XmlAttribute(name = "PostId")
    public int postId;

    @XmlAttribute(name = "RelatedPostId")
    public int relatedPostId;

    @XmlAttribute(name = "LinkTypeId")
    public int linkTypeId;

    @XmlAttribute(name = "CreationDate")
    public Date creationDate;

}
