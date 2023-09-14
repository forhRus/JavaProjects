package Exceptions;

public class MyArrayDataException extends MyArrayException{


    public MyArrayDataException(String msg, Object [][] arr) {
        super(msg, arr);
    }
}
