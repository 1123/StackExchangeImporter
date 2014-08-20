package org.stackexchange.querying;

import javax.persistence.*;

@Entity()
@Table(name="comment")
public class BadgeR {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserR user;

    @Id
    public Integer id;

}
