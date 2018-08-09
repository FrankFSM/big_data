package com.ralap.bigdata.lock;

import org.junit.jupiter.api.Test;

/**
 * @author: ralap
 * @date: created at 2018/8/8 22:13
 */
public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            int finalI = i;
            new Thread(() -> {
                SyncDemo demo = new SyncDemo();
                try {
                    demo.sy("Demo" + finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }


    }

    @Test
    public void lockDemo() throws InterruptedException {

        LockDemo demo = new LockDemo();
        demo.lock();
        demo.lock();
        Thread.sleep(10000);
    }

    @Test
    public void InterruptiblyLockDemo() {

        LockDemo demo = new LockDemo();
        Thread thread = demo.InterruptiblyLock();
        Thread thread2 = demo.InterruptiblyLock();
        thread.start();
        thread2.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }

    @Test
    public void RWLockDemo() {
        LockDemo lockDemo = new LockDemo();
        lockDemo.rWLock();
        lockDemo.rWLock();
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
