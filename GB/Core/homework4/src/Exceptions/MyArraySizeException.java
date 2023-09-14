package Exceptions;

public class MyArraySizeException extends MyArrayException {
     public MyArraySizeException(String msg, Object[][] arr) {
        super(msg, arr);
    }
}
