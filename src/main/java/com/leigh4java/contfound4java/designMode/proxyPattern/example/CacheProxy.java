package com.leigh4java.contfound4java.designMode.proxyPattern.example;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 缓存代理
public class CacheProxy implements MethodInterceptor {
    private Object target;
    private Map<String, Object> cache = new HashMap<>();

    public CacheProxy(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        String methodName = method.getName();
        String key = methodName + "_" + (args != null ? Arrays.toString(args) : "");

        // 只有get方法才缓存
        if (methodName.startsWith("get")) {
            if (cache.containsKey(key)) {
                System.out.println("【缓存代理】从缓存获取结果: " + key);
                return cache.get(key);
            } else {
                Object result = proxy.invokeSuper(obj, args);
                cache.put(key, result);
                System.out.println("【缓存代理】缓存结果: " + key);
                return result;
            }
        }

        // 非get方法直接执行
        return proxy.invokeSuper(obj, args);
    }
}
