package com.ralap.bigdata.demo;

import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author: ralap
 * @date: created at 2018/8/7 21:56
 */
public class Test {

    private CountDownLatch latch = new CountDownLatch(1);

    /**
     * 连接zookeeper
     */
    public void connectZookeeper() throws Exception {

        System.out.println("静静地等待");
        // 等待连接建立
        latch.await();
        System.out.println("执行了------》");

    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    try {
                        Test dl = new Test();
                        dl.connectZookeeper();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
