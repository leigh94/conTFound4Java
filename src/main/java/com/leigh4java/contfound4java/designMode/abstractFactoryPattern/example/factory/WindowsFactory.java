package com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.factory;

import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.impl.Button;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.impl.CheckBox;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.impl.TextBox;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.impl.WindowsButton;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.impl.WindowsCheckBox;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.impl.WindowsTextBox;

// Windows工厂
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextBox createTextBox() {
        return new WindowsTextBox();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
