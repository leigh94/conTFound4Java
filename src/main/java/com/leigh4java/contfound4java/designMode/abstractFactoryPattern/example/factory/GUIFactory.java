package com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.factory;

import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.impl.Button;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.impl.CheckBox;
import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.impl.TextBox;

public interface GUIFactory {
    Button createButton();
    TextBox createTextBox();
    CheckBox createCheckBox();
}
