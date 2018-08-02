package com.ralap.bigdata.zk.client;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @author: ralap
 * @date: created at 2018/8/2 13:44
 */
public class ZKClient {

    private final static String ZK_PATH = "47.93.196.193:2181";
    static ZooKeeper zk;

    public static void getConnect(String name) throws IOException {
        zk = new ZooKeeper(ZK_PATH, 3000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

                if (event.getType() == EventType.NodeChildrenChanged && "/server"
                        .equals(event.getPath())) {
                    try {
                        getServerList(name);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void getServerList(String name)
            throws IOException, KeeperException, InterruptedException {

        getConnect(name);
        List<String> childrenList = zk.getChildren("/server", true);
        List<String> serverPahtList = new ArrayList<>();
        for (String children : childrenList) {
            serverPahtList.add(new String(zk.getData("/server/" + children, false, new Stat()),"utf-8"));
        }
        System.out.println(serverPahtList);
        Thread.sleep(Long.MAX_VALUE);
    }

    public static void main(String[] args)
            throws InterruptedException, IOException, KeeperException {
        getServerList(args[0]);
    }
}
