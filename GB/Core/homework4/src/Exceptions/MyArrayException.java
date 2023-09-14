package Exceptions;

public class MyArrayException extends Exception{
      private Object[][] array;
    public MyArrayException(String msg, Object[][] array) {
        super(msg);
        this.array = array;
    }


    public Object[][] getArray() {
        return array;
    }
}
