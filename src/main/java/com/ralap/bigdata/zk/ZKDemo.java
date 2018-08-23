package com.ralap.bigdata.zk;

import java.io.IOException;
import java.util.List;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author: ralap
 * @date: created at 2018/8/2 11:30
 */
public class ZKDemo {

    private final static int SESSION_TIMEOUT = 3000;
    ZooKeeper zk;


    public void getConnect() throws IOException {
        zk = new ZooKeeper("47.93.196.193:2181", ZKDemo.SESSION_TIMEOUT, this.watcher);
    }

    Watcher watcher = new Watcher() {
        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println(watchedEvent.toString());
        }
    };

    @Test
    public void test() throws KeeperException, InterruptedException, IOException {
        getConnect();
//        zk.create("/server", "server".getBytes(), Ids.OPEN_ACL_UNSAFE,
//                CreateMode.PERSISTENT);
        Stat exists = zk.exists("/server", false);
        System.out.println("------------>");
        System.out.println(exists);
        after();
    }


    public void after() throws InterruptedException {
        zk.close();
    }

}
