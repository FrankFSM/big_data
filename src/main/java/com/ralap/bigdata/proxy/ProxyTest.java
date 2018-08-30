package com.ralap.bigdata.proxy;

import org.junit.jupiter.api.Test;

/**
 * @author: ralap
 * @date: created at 2018/8/30 11:52
 */
public class ProxyTest {

    @Test
    public void test() {
        IStar proxyStar = Starproxy.getProxyStar();
        proxyStar.buySomeThing();
    }

}
