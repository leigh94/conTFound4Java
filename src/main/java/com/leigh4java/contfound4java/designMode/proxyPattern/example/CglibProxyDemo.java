package com.leigh4java.contfound4java.designMode.proxyPattern.example;

public class CglibProxyDemo {
    public static void main(String[] args) {
        System.out.println("=== CGLIB代理模式演示 ===\n");

        ProductService realService = new ProductService();

        System.out.println("1. 基本CGLIB代理:");
        CglibProxy cglibProxy = new CglibProxy(realService);
        ProductService proxyService = (ProductService) cglibProxy.getProxy();
        proxyService.saveProduct("笔记本电脑");
        proxyService.deleteProduct("台式机");

        System.out.println("\n2. final方法测试:");
        proxyService.finalMethod(); // final方法不会被代理

        System.out.println("\n3. 缓存代理演示:");
        // 创建一个模拟的查询服务
        QueryService queryService = new QueryService();
        CacheProxy cacheProxy = new CacheProxy(queryService);
        QueryService cachedService = (QueryService) cacheProxy.getProxy();

        // 第一次查询 - 会执行真实方法
        cachedService.getData("user");
        // 第二次相同查询 - 从缓存获取
        cachedService.getData("user");
        // 不同查询 - 执行真实方法
        cachedService.getData("product");
        // 再次查询user - 从缓存获取
        cachedService.getData("user");

        // 非get方法不缓存
        cachedService.updateData("user");
    }
}

// 用于缓存代理测试的类
class QueryService {
    public String getData(String type) {
        System.out.println("执行数据库查询: " + type);
        try {
            Thread.sleep(500); // 模拟耗时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return type + "的数据结果";
    }

    public void updateData(String type) {
        System.out.println("更新数据: " + type);
    }
}