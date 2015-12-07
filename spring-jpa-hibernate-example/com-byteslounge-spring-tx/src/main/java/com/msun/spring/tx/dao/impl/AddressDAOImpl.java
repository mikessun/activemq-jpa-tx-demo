package com.msun.spring.tx.dao.impl;

import com.msun.spring.tx.dao.AddressDAO;
import com.msun.spring.tx.dao.UserDAO;
import com.msun.spring.tx.model.Address;
import com.msun.spring.tx.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AddressDAOImpl implements AddressDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void insertAddress(Address address) {
        entityManager.persist(address);
    }

    @Override
    public List<Address> findAllAddresses() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Address> cq = builder.createQuery(Address.class);
        Root<Address> root = cq.from(Address  .class);
        cq.select(root);

        return entityManager.createQuery(cq).getResultList();
    }
}
