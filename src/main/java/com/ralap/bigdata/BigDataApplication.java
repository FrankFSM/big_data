package com.ralap.bigdata;

import com.ralap.bigdata.zk.lock.ZkDistributedLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BigDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigDataApplication.class, args);
    }


    int n = 200;

    @GetMapping("/zk")
    public void zk() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ZkDistributedLock lock = null;
                try {
                    lock = new ZkDistributedLock("test1");
                    lock.lock();
                    System.out.println("------------>" + --n);
                    System.out.println(Thread.currentThread().getName() + "正在运行");
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }

}
