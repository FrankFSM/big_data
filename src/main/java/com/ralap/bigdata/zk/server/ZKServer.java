package com.ralap.bigdata.zk.server;


import com.ralap.bigdata.zk.util.ZKUtil;
import java.io.IOException;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author: ralap
 * @date: created at 2018/8/2 13:44
 */
public class ZKServer {

    public static void regist(String name)
            throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = ZKUtil.getConnect(3000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("------------>监听");
            }
        });

        zooKeeper.create("/server/" + name, name.getBytes(), Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("----------------->注册成功");
        Thread.sleep(Long.MAX_VALUE);
    }

    public static void main(String[] args)
            throws InterruptedException, IOException, KeeperException {
        regist(args[0]);
    }
}
