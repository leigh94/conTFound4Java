package com.leigh4java.contfound4java.designMode.abstractFactoryPattern.factory;

import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.Button;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.CheckBox;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.GUIFactory;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.TextBox;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl.WindowsButton;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl.WindowsCheckBox;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl.WindowsTextBox;

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
