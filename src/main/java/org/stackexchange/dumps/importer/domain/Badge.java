package org.stackexchange.dumps.importer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 *   <row Id="1" UserId="5" Name="Student" Date="2010-07-28T19:09:00.243" />
 */

@Entity
@XmlRootElement(name = "row")
public class Badge {

    @Id
    @XmlAttribute(name = "Id")
    public int id;

    @XmlAttribute(name = "Name")
    public String name;

    @XmlAttribute(name = "Date")
    public Date date;

    @XmlAttribute(name = "UserId")
    public int userId;

}

