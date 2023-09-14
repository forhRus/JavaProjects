package Exceptions;

public class MyArrayDataException extends MyArrayException{
    private final int i;
    private final int j;

    public MyArrayDataException(String msg, String [][] array, int i, int j) {
        super(msg, array);
        this.i = i;
        this.j = j;
    }

    @Override
    public String[][] getArray() {
        return super.getArray();
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
