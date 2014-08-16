package org.stackexchange.querying.dao;

import org.springframework.stereotype.Repository;
import org.stackexchange.querying.PostR;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
public class PostRDao {

    @PersistenceContext(unitName="stackexchangeQuerying")
    private EntityManager em;

    @Transactional()
    public void store(PostR post) {
        this.em.persist(post);
    }

    @Transactional()
    public PostR find(int id) {
        return this.em.find(PostR.class, id);
    }
}
