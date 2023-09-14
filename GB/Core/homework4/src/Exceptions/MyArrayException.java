package Exceptions;

public class MyArrayException extends Exception{
    private String _msg;
    private Object[][] arr;
    public MyArrayException(String msg, Object[][] arr) {
        super(msg);
        _msg = msg;
    }

    public String get_msg() {
        return _msg;
    }

    public Object[][] getArr() {
        return arr;
    }
}
