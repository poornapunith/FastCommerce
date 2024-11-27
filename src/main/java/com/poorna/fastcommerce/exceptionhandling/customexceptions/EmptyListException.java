package com.poorna.fastcommerce.exceptionhandling.customexceptions;

public class EmptyListException extends RuntimeException {
    public EmptyListException(String message) {
        super(message);
    }
}
