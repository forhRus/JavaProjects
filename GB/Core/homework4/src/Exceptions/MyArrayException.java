package Exceptions;

public class MyArrayException extends Exception{
      private String[][] array;
    public MyArrayException(String msg, String[][] array) {
        super(msg);
        this.array = array;
    }


    public String[][] getArray() {
        return array;
    }
}
