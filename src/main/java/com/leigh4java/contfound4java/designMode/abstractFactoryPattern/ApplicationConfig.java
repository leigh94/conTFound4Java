package com.leigh4java.contfound4java.designMode.abstractFactoryPattern;

// 应用配置
public class ApplicationConfig {
    private GUIFactoryProvider.OSType osType;

    public ApplicationConfig(GUIFactoryProvider.OSType osType) {
        this.osType = osType;
    }

    public GUIFactory createFactory() {
        return GUIFactoryProvider.getFactory(osType);
    }

    // 可以从配置文件读取配置
    public static ApplicationConfig loadFromConfig() {
        // 模拟从配置文件读取
        String configOS = "WINDOWS"; // 这里可以改为从文件读取
        return new ApplicationConfig(GUIFactoryProvider.OSType.valueOf(configOS));
    }
}