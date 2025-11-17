package com.leigh4java.contfound4java.designMode.proxyPattern.example;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// CGLIB方法拦截器
public class CglibProxy implements MethodInterceptor {
    private Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    // 创建代理对象
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("【CGLIB代理】前置处理: " + method.getName());

        // 执行真实方法
        Object result = proxy.invokeSuper(obj, args);

        System.out.println("【CGLIB代理】后置处理: " + method.getName());
        return result;
    }
}