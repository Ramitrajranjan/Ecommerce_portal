package com.e_Commerce.helper;

public class UserNotFoundException extends Exception{
    public UserNotFoundException()
    {
        super("user with this username is not found present in DB");
    }
    public UserNotFoundException(String msg)
    {
        super(msg);
    }
}
