package com.ralap.bigdata.zk.lock;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @author: ralap
 * @date: created at 2018/8/5 20:23
 */
public class DistributedClient {

    // 超时时间
    private static final int SESSION_TIMEOUT = 5000;
    // zookeeper server列表
    private String hosts = "47.93.196.193:2181";

}

