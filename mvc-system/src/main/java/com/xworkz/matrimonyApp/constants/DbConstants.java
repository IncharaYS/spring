package com.xworkz.matrimonyApp.constants;

public enum DbConstants {
    URL("jdbc:mysql://localhost:3306/matrimony"),USERNAME("root"),PASSWORD("Root@123");

    private String properties;

    private DbConstants(String properties){
        this.properties=properties;
    }

    public String getProperties() {
        return properties;
    }
}
