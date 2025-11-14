package com.leigh4java.contfound4java.designMode.abstractFactoryPattern.factory;

import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl.Button;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl.CheckBox;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl.TextBox;

public interface GUIFactory {
    Button createButton();
    TextBox createTextBox();
    CheckBox createCheckBox();
}
