package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

public class WebFilterDemo {
    public static void main(String[] args) {
        System.out.println("=== Web过滤器责任链演示 ===\n");

        // 构建过滤器链
        FilterChain chain = new FilterChain();
        chain.addFilter(new LoggingFilter())
                .addFilter(new AuthenticationFilter())
                .addFilter(new ValidationFilter())
                .addFilter(new BusinessFilter());

        // 测试请求1 - 正常请求
        System.out.println("测试1: 正常请求");
        HttpRequest request1 = new HttpRequest("POST", "/api/users");
        request1.setHeader("Authorization", "Bearer valid-token");
        request1.setParameter("name", "张三");
        request1.setParameter("email", "zhangsan@example.com");

        HttpResponse response1 = new HttpResponse();
        chain.doFilter(request1, response1);

        System.out.println("\n响应: " + response1.getStatusCode() + " - " + response1.getContent());

        // 测试请求2 - 未认证请求
        System.out.println("\n测试2: 未认证请求");
        HttpRequest request2 = new HttpRequest("GET", "/api/data");
        // 不设置Authorization头

        HttpResponse response2 = new HttpResponse();
        // 需要重新创建链，因为index已经到末尾
        FilterChain chain2 = new FilterChain();
        chain2.addFilter(new LoggingFilter())
                .addFilter(new AuthenticationFilter())
                .addFilter(new ValidationFilter())
                .addFilter(new BusinessFilter());

        chain2.doFilter(request2, response2);
        System.out.println("响应: " + response2.getStatusCode() + " - " + response2.getContent());
    }
}
