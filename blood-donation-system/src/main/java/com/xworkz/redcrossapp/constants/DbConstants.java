package com.xworkz.redcrossapp.constants;

public enum DbConstants {
    URL("jdbc:mysql://localhost:3306/blood_donation"),USERNAME("root"),PASSWORD("Root@123");

    private String properties;

    private DbConstants(String properties){
        this.properties=properties;
    }

    public String getProperties() {
        return properties;
    }
}
