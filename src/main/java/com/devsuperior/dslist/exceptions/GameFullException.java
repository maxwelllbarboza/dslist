package com.devsuperior.dslist.exceptions;

public class GameFullException extends RuntimeException{

    public GameFullException(){
        super("Game não existe!");
    }

    public GameFullException(String message){
        super(message);
    }
}
