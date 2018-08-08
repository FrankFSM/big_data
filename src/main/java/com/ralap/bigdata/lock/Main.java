package com.ralap.bigdata.lock;

/**
 * @author: ralap
 * @date: created at 2018/8/8 22:13
 */
public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            int finalI = i;
            new Thread(()->{
                SyncDemo demo = new SyncDemo();
                try {
                    demo.sy("Demo" + finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }


    }
}
