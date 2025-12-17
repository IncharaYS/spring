package com.xworkz.medicalStoreApp.constants;

public enum DbConstants {
    URL("jdbc:mysql://localhost:3306/medical_store"),USERNAME("root"),PASSWORD("Root@123");

    final String properties;

    private DbConstants(String properties){
        this.properties=properties;
    }

    public String getProperties() {
        return properties;
    }
}
