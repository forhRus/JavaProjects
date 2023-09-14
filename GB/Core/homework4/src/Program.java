import Exceptions.MyArraySizeException;

public class Program {
    public static void main(String[] args) {
        Integer[][] MyArray = new Integer[4][4];
        //Integer[][] MyArray1 = new Integer[5][4];
        //Integer[][] MyArray2 = new Integer[4][5];
        Integer[][] MyArray3 = new Integer[4][];
        MyArray3[0] = new Integer[4];
        MyArray3[1] = new Integer[4];
        MyArray3[2] = new Integer[5];
        MyArray3[3] = new Integer[3];
        System.out.println(MyArray3[3].length);;
        try {
            checkSize(MyArray);
            //checkSize(MyArray1); //error
            //checkSize(MyArray2); //error
            //checkSize(MyArray3); //error
        }catch (MyArraySizeException e){
            e.printStackTrace();
        }




    }

    /**
     * Метод выбрасывает исключение если размер массива не 4х4
     * @param array
     * @throws MyArraySizeException
     */
    public static void checkSize(Object[][] array) throws MyArraySizeException{
        int size = 4;
        int length = array.length;

        //первичная проверка
        ERROR:
        if(length == size){
            //проверка зубчатого массива
            for (int i = 0; i < length; i++) {
                if(array[i].length != size){
                    //выходим из проверки к выбросу исключения
                    break ERROR;
                }
            }
            //если все проверки пройдены выходим из метода без ошибки
            return;
        }

        throw new MyArraySizeException("Размер массив не 4х4\n", array);
    }
}
