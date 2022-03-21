package ru.netology.exception;

import javax.management.InstanceAlreadyExistsException;

//public class AlreadyExistsException extends InstanceAlreadyExistsException {
public class AlreadyExistsException extends Exception {

    public AlreadyExistsException(String msg) {
        super(msg);
    }
}
