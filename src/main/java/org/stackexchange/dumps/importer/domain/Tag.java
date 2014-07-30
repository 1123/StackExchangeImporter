package org.stackexchange.dumps.importer.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 *     <row Id="23" TagName="storage" Count="16" ExcerptPostId="615" WikiPostId="614" />
 */

@Entity
@XmlRootElement(name = "row")
public class Tag {

    @Id
    @XmlAttribute(name = "Id")
    public int id;

    @XmlAttribute(name = "TagName")
    public String tagName;

    @XmlAttribute(name = "Count")
    public int count;

    @XmlAttribute(name = "ExcerptPostId")
    public int excerptPostId;

    @XmlAttribute(name = "WikiPostId")
    public int wikiPostId;

}

