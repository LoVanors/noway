package com.example.noway.exceptions;

public class EntityNotFoundException extends EntityException{
    public EntityNotFoundException(){
        super("not found.");
    }

    public EntityNotFoundException(String message){
        super(message);
    }
}
