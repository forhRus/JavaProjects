package Exceptions;

public class MyArraySizeException extends MyArrayException {
     public MyArraySizeException(String msg, String[][] array) {
        super(msg, array);
    }
}
