package com.ralap.bigdata.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: ralap
 * @date: created at 2018/8/30 11:48
 */
public class Starproxy {

    public static IStar getProxyStar() {
        return (IStar) Proxy.newProxyInstance(Star.class.getClassLoader(), new Class[]{IStar.class},
                (proxy, method, args) -> {
                    method.invoke(new Star(), args);
                    System.out.println("兄弟，动态代理了");
                    return null;
                });

    }

}
