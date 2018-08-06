package com.ralap.bigdata.zk.lock;

import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author: ralap
 * @date: created at 2018/8/5 20:23
 */
public class DistributedClient {

    // 超时时间
    private static final int SESSION_TIMEOUT = 5000;
    // zookeeper server列表
    private String hosts = "47.93.196.193:2181";

    private String groupNode = "locks";

    private String subNode = "sub";
    private ZooKeeper zk;

    CountDownLatch lock = new CountDownLatch(1);

    public void connectZk() throws Exception {
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, event -> {
            if (event.getState() == KeeperState.SyncConnected) {
                lock.countDown();
            }

        });

    }

}

