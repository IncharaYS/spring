package com.xworkz.Iapp.constants;


public enum IssueCode {

    ALLOK("No Issues"),
    EMAILEXISTS("Entered email already exists"),
    EMAILNOTREGISTERED("Entered email is not registered"),
    INVALIDPWD("Entered password is invalid"),
    PWDTRIESLIMITREACHED("Entered incorrect password more than 3 times login using otp"),
    PASSWORDMISMATCH("Entered confirm password does not match password"),
    DBERROR("Failed to save"),
    PHONENOEXISTS("Entered phone number already exists");

    private String message;

    private IssueCode(String messsage){
        this.message=messsage;
    }

    public String getMessage(){
        return message;
    }


}
