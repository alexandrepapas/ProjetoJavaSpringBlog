package com.alexandrepapas.desafioBlog.Exepections;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
