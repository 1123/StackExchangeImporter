package org.stackexchange.querying;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="post")
public class UserR {

    @Id
    public int id;

    public int reputation;

    public String displayname;

}

