package com.msun.spring.tx.model;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "street_name", nullable = false, length = 50)
    private String streetName;

    @Column(name = "zip_code", nullable = false, length = 50)
    private String zipCode;

    @Column(name = "state_code", nullable = false, length = 50)
    private String stateCode;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "addresses")
    private Set<User> users=new HashSet<>(0);

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public int getId() {

        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStateCode() {
        return stateCode;
    }


    public Set<User> getUsers() {
        return this.users;
    }

    public void setStocks(Set<User> users) {
        this.users = users;
    }
}