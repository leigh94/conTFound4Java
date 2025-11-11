package com.leigh4java.contfound4java.designMode.abstractFactoryPattern;

public interface GUIFactory {
    Button createButton();
    TextBox createTextBox();
    CheckBox createCheckBox();
}
