package com.msun.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class JmsMessageListener {
    public static final String MSG_SENDER = "MsgSender";
    static int count = 0;

    @JmsListener(destination = MSG_SENDER)
    //@SendTo("RecvToSend")
    public String processMessage(String text) {

        long threadId = Thread.currentThread().getId();
        System.out.println("current thread #" + threadId + " Received: " + text);
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (text.contains("11:55:13")) {
            System.out.println("retrial==" + count++);
            throw new RuntimeException("redelivery for " + text);
        }
        return "ACK from handleMessage " + text;
    }
}