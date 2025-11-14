package com.leigh4java.contfound4java.designMode.abstractFactoryPattern.factory;

import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl.Button;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl.CheckBox;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl.TextBox;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl.MacButton;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl.MacCheckBox;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl.MacTextBox;

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
