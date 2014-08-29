package org.stackexchange.querying.dao;

import org.springframework.stereotype.Repository;
import org.stackexchange.querying.UserR;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRDao {

    @PersistenceContext
    private EntityManager em;

    public void store(UserR user) {
        this.em.persist(user);
    }

    public UserR find(int id) {
        return this.em.find(UserR.class, id);
    }
}
