package com.juc.creat;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * TODO
 *
 * @author ahao 2020-07-15
 */
public class ThreadTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        Method1 method1 = new Method1();
        Method1.ThreadTest threadTest = new Method1.ThreadTest();
        threadTest.start();

        System.out.println("============二=================");
        new Thread(new Method2.RunnableImpl()).start();

        System.out.println("=============三==================");
        FutureTask<String> future = new FutureTask<>(new Method3.CallableImpl());
        new Thread(future).start();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
