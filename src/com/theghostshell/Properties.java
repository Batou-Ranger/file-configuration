package com.theghostshell;

public class Properties {
    private String key;

    private String value;

    public Properties(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
