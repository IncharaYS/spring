package com.xworkz.travelAgencyApp.constants;

public enum DbConstants {
    URL("jdbc:mysql://localhost:3306/travel_agency"),USERNAME("root"),PASSWORD("Root@123");

    private String properties;

    private DbConstants(String properties){
        this.properties=properties;
    }

    public String getProperties() {
        return properties;
    }
}
