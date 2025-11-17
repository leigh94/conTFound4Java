package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

import java.util.*;

// Web请求和响应
class HttpRequest {
    private String method;
    private String path;
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> parameters = new HashMap<>();

    public HttpRequest(String method, String path) {
        this.method = method;
        this.path = path;
    }

    public void setHeader(String key, String value) {
        headers.put(key, value);
    }

    public void setParameter(String key, String value) {
        parameters.put(key, value);
    }

    // getters
    public String getMethod() { return method; }
    public String getPath() { return path; }
    public Map<String, String> getHeaders() { return headers; }
    public Map<String, String> getParameters() { return parameters; }
}

class HttpResponse {
    private int statusCode = 200;
    private String content;
    private Map<String, String> headers = new HashMap<>();

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setHeader(String key, String value) {
        headers.put(key, value);
    }

    // getters
    public int getStatusCode() { return statusCode; }
    public String getContent() { return content; }
    public Map<String, String> getHeaders() { return headers; }
}

// 过滤器接口
interface Filter {
    void doFilter(HttpRequest request, HttpResponse response, FilterChain chain);
}

// 过滤器链
class FilterChain {
    private List<Filter> filters = new ArrayList<>();
    private int index = 0;

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    public void doFilter(HttpRequest request, HttpResponse response) {
        if (index < filters.size()) {
            Filter filter = filters.get(index++);
            filter.doFilter(request, response, this);
        }
    }
}

// 具体过滤器实现
class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(HttpRequest request, HttpResponse response, FilterChain chain) {
        System.out.println("【认证过滤器】检查用户认证...");

        String token = request.getHeaders().get("Authorization");
        if (token == null || !token.equals("Bearer valid-token")) {
            response.setStatusCode(401);
            response.setContent("未授权访问");
            return;
        }

        System.out.println("【认证过滤器】认证通过");
        chain.doFilter(request, response);
    }
}

class LoggingFilter implements Filter {
    @Override
    public void doFilter(HttpRequest request, HttpResponse response, FilterChain chain) {
        System.out.println("【日志过滤器】请求: " + request.getMethod() + " " + request.getPath());
        long startTime = System.currentTimeMillis();

        chain.doFilter(request, response);

        long endTime = System.currentTimeMillis();
        System.out.println("【日志过滤器】响应: " + response.getStatusCode() +
                ", 耗时: " + (endTime - startTime) + "ms");
    }
}

class ValidationFilter implements Filter {
    @Override
    public void doFilter(HttpRequest request, HttpResponse response, FilterChain chain) {
        System.out.println("【验证过滤器】验证请求参数...");

        if ("POST".equals(request.getMethod()) && request.getParameters().isEmpty()) {
            response.setStatusCode(400);
            response.setContent("请求参数不能为空");
            return;
        }

        System.out.println("【验证过滤器】参数验证通过");
        chain.doFilter(request, response);
    }
}

class BusinessFilter implements Filter {
    @Override
    public void doFilter(HttpRequest request, HttpResponse response, FilterChain chain) {
        System.out.println("【业务过滤器】处理业务逻辑...");

        // 模拟业务处理
        response.setContent("业务处理完成: " + request.getPath());
        response.setHeader("X-Processed-By", "BusinessFilter");

        System.out.println("【业务过滤器】业务处理完成");
        // 这里不调用chain.doFilter，因为业务处理是终点
    }
}