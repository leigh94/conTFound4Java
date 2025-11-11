package com.leigh4java.contfound4java.designMode.abstractFactoryPattern;

import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.factory.MacFactory;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.factory.WindowsFactory;

// 工厂提供者
public class GUIFactoryProvider {
    public enum OSType {
        WINDOWS, MAC, LINUX
    }

    public static GUIFactory getFactory(OSType osType) {
        switch (osType) {
            case WINDOWS:
                return new WindowsFactory();
            case MAC:
                return new MacFactory();
            default:
                throw new IllegalArgumentException("不支持的操作系统类型: " + osType);
        }
    }

    // 根据系统属性自动检测
    public static GUIFactory getFactory() {
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("win")) {
            return new WindowsFactory();
        } else if (osName.contains("mac")) {
            return new MacFactory();
        } else {
            throw new UnsupportedOperationException("不支持的操作系统: " + osName);
        }
    }
}
