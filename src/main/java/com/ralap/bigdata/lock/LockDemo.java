package com.ralap.bigdata.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: ralap
 * @date: created at 2018/8/9 21:36
 */
public class LockDemo {


    Lock lock = new ReentrantLock();

    public void lock() {

        new Thread(() -> {
            boolean b = lock.tryLock();
            System.out.println(b);
            if (b) {
                try {
//                lock.lock();
                    System.out.println(Thread.currentThread().getName() + "---->start");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "---->finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

    }

    public Thread InterruptiblyLock() {

        Thread t = new Thread(() -> {

            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "---->被中断");
                return;
            }
            try {
                System.out.println(Thread.currentThread().getName() + "---->start");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName() + "---->finish");
            } catch (InterruptedException e) {

                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        return t;
    }

    ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void rWLock() {

        new Thread(() -> {
            read(Thread.currentThread());
            write(Thread.currentThread());
        }).start();

    }

    public void read(Thread thread) {
        rwLock.readLock().lock();
        try {
            long millis = System.currentTimeMillis();
            while (System.currentTimeMillis() - millis <= 1) {
                System.out.println(thread.getName() + "reading");
            }
            System.out.println(thread.getName() + "read finish");

        } finally {
            rwLock.readLock().unlock();
        }
    }

    public void write(Thread thread) {
        rwLock.writeLock().lock();
        try {
            long millis = System.currentTimeMillis();
            while (System.currentTimeMillis() - millis <= 1) {
                System.out.println(thread.getName() + "writeing");
            }
            System.out.println(thread.getName() + "write finish");

        } finally {
            rwLock.writeLock().unlock();
        }
    }
}
