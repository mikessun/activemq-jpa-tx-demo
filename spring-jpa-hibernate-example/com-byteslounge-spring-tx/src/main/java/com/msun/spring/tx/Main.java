package com.msun.spring.tx;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.msun.spring.tx.model.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.msun.spring.tx.model.User;
import com.msun.spring.tx.user.UserManager;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring.xml");

        UserManager userManager = (UserManager) ctx.getBean("userManagerImpl");

        List<User> list = userManager.findAllUsers();
        System.out.println("User count1: " + list.size());

        Set addresses = new HashSet(2);
        addresses.add(getAddress());
        addresses.add(getAddress());

        User user = new User();
        user.setUsername("johndoe" + Math.abs(new Random().nextInt()));
        user.setName("John Doe");
        user.setAddresses(addresses);
        userManager.insertUser(user);
        System.out.println("User inserted!");
        list = userManager.findAllUsers();
        System.out.println("User count2: " + list.size());

        String userName = list.get(list.size() - 1).getUsername();

        User userByUserName = userManager.findUserByUserName(userName);

        System.out.println("total address: " + userByUserName.getName());
    }

    static Address getAddress() {
        Address address = new Address();
        address.setStateCode("CA");
        address.setStreetName(Math.abs(new Random().nextInt()) + " main st");
        address.setZipCode("" + Math.abs(new Random().nextInt()));
        return address;
    }
}
