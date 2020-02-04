package com.theghostshell;

import java.io.IOException;

public class TestClass {
    public static void main(String[] args) throws IOException {
        PropertiesReader reader  = new PropertiesReader("src/com/theghostshell/example-config.properties", null);
        PropertiesCollection propertiesCollection = reader.read();

        Properties propertiesMachineHost = propertiesCollection.read("machine.host");
        Properties propertiesAdminName = propertiesCollection.read("admin.name");

        System.out.println(propertiesMachineHost.getValue());
        System.out.println(propertiesAdminName.getValue());
    }
}
