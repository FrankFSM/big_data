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
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        method.invoke(new Star(), args);
                        System.out.println("兄弟，动态代理了");
                        return null;
                    }
                });

    }

}
