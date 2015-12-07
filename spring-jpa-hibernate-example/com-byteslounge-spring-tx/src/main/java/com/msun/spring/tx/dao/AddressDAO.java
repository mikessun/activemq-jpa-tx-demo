package com.msun.spring.tx.dao;

import com.msun.spring.tx.model.Address;
import com.msun.spring.tx.model.User;

import java.util.List;

public interface AddressDAO {

	void insertAddress(Address address);

	List<Address> findAllAddresses();
}
