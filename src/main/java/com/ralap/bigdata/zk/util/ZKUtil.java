package com.ralap.bigdata.zk.util;

import com.ralap.bigdata.zk.server.ZKServer;
import java.io.IOException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author: ralap
 * @date: created at 2018/8/2 13:51
 */
public class ZKUtil {

    private static ZooKeeper zk;
    /**
     * zk地址
     */
    private final static String ZK_PATH = "47.93.196.193:2181";

    private ZKUtil() {
    }

    public static ZooKeeper getConnect(int timeOutTime, Watcher watcher) throws IOException {
        zk = new ZooKeeper(ZK_PATH, timeOutTime, watcher);
        return zk;
    }

}
