package com.leigh4java.contfound4java.designMode.interpreterPattern.example;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<String, Boolean> variables = new HashMap<>();

    public void setVariable(String name, boolean value) {
        variables.put(name, value);
    }

    public boolean getVariable(String name) {
        return variables.get(name);
    }
}
