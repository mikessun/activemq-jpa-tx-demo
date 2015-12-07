package com.msun.spring.tx.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;

import com.msun.spring.tx.model.User;
import org.springframework.stereotype.Repository;

import com.msun.spring.tx.dao.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> findAllUsers() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = builder.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);

        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public User findUserByUserName(String userName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = builder.createQuery(User.class);
        Root<User> root = cq.from(User.class);

        Predicate predicate = builder.equal(root.get("username"), userName);
        cq.where(predicate);
        return entityManager.createQuery(cq).getSingleResult();
    }

}
