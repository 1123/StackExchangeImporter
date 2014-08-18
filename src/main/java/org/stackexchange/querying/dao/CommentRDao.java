package org.stackexchange.querying.dao;

import org.springframework.stereotype.Repository;
import org.stackexchange.querying.CommentR;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


@Repository
public class CommentRDao {

    @PersistenceContext(unitName="stackexchangeQuerying")
    private EntityManager em;

    @Transactional()
    public Long countComments() {
        Query query = em.createQuery("SELECT COUNT(comment.id) FROM CommentR comment");
        return (Long) query.getSingleResult();
    }

    @Transactional()
    public void createCopy(int oldId, int newId) {
        CommentR copyComment = this.em.find(CommentR.class, oldId);
        this.em.detach(copyComment);
        copyComment.id = newId;
        this.em.persist(copyComment);
    }

    @Transactional()
    public void store(CommentR comment) {
        this.em.persist(comment);
    }

    public CommentR find(int id) {
        return this.em.find(CommentR.class, id);
    }
}
