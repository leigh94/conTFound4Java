package com.leigh4java.contfound4java.designMode.prototypePattern.example.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeManager {
    private Map<String, Prototype> prototypes = new HashMap<>();

    public void registerPrototype(String key, Prototype prototype) {
        prototypes.put(key, prototype);
    }

    public Prototype createPrototype(String key) throws CloneNotSupportedException {
        Prototype prototype = prototypes.get(key);
        if (prototype != null) {
            return prototype.clone();
        }
        return null;
    }
}
