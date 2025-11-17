package com.leigh4java.contfound4java.designMode.proxyPattern.example;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

// 不需要接口的类
public class ProductService {
    public void saveProduct(String productName) {
        System.out.println("保存产品: " + productName);
    }

    public void deleteProduct(String productName) {
        System.out.println("删除产品: " + productName);
    }

    public final void finalMethod() {
        System.out.println("这是一个final方法，无法被代理");
    }
}