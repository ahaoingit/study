package com.ahao.TimerTaskDemo;

import java.util.TimerTask;

/**
 * @author ahao
 */
public class SendTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("test");
    }
}
