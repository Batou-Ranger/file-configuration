package com.theghostshell;

import java.util.HashMap;

public class PropertiesCollection {
    private HashMap<String, String> props;

    public PropertiesCollection(HashMap<String, String> props) {
        this.props = props;
    }

    public Properties read(String key) {
        String value = props.get(key);
        if (value == null) {
            throw new KeyNotFoundException("Value not found for key " + key);
        }

        return new Properties(key, value);
    }
}
