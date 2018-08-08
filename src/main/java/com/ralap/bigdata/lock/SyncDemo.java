package com.ralap.bigdata.lock;

/**
 * @author: ralap
 * @date: created at 2018/8/8 22:11
 */
public class SyncDemo {


    public synchronized void sy(String flag) throws InterruptedException {
        synchronized (SyncDemo.class) {
//        synchronized (this){
            System.out.println("Start------->" + flag);
            Thread.sleep(1000L);
            System.out.println("End------->" + flag);
        }

    }

}
