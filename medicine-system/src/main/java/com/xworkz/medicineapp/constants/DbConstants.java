package com.xworkz.medicineapp.constants;

public enum DbConstants {
    URL("jdbc:mysql://localhost:3306/medicine"),USERNAME("root"),PASSWORD("Root@123");

    private String properties;

    private DbConstants(String properties){
        this.properties=properties;
    }

    public String getProperties() {
        return properties;
    }
}
