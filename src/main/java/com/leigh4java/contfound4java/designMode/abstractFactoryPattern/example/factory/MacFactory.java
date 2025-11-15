package com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.factory;

import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.impl.Button;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.impl.CheckBox;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.impl.TextBox;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.impl.MacButton;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.impl.MacCheckBox;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.impl.MacTextBox;

// Mac工厂
public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextBox createTextBox() {
        return new MacTextBox();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
