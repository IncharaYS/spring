package com.xworkz.clothingapp.exception;

public class DuplicateClothNameException extends RuntimeException{
    public DuplicateClothNameException(String errMsg){
        super(errMsg);
    }
}
