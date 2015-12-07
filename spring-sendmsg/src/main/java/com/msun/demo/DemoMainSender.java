package com.msun.demo;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;


public class DemoMainSender {

    public static void main(String[] args) {
        // init spring context
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");

        // get bean from context
        JmsMessageSender jmsMessageSender = (JmsMessageSender) ctx.getBean("jmsMessageSender");

        // send to default destination
        for (int i = 0; i <1 ; i++) {
            jmsMessageSender.send("hello JMS11 at " + new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // send to a code specified destination
        Queue queue = new ActiveMQQueue("AnotherDest");
        jmsMessageSender.send(queue, "hello Another Message");

        // close spring application context
        ((ClassPathXmlApplicationContext) ctx).close();
    }

}