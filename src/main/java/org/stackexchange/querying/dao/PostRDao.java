package org.stackexchange.querying.dao;

import org.springframework.stereotype.Repository;
import org.stackexchange.querying.PostR;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
public class PostRDao {

    @PersistenceContext
    private EntityManager em;

    public void store(PostR post) {
        this.em.persist(post);
    }

    public PostR find(int id) {
        return this.em.find(PostR.class, id);
    }
}
