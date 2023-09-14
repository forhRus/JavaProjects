import Exceptions.MyArrayDataException;
import Exceptions.MyArraySizeException;

public class Program {
    public static void main(String[] args) {
        String[][] MyArray = new String[4][4];
        //Integer[][] MyArray1 = new Integer[5][4];
        //Integer[][] MyArray2 = new Integer[4][5];

//        Integer[][] MyArray3 = new Integer[4][];
//        MyArray3[0] = new Integer[4];
//        MyArray3[1] = new Integer[4];
//        MyArray3[2] = new Integer[5];
//        MyArray3[3] = new Integer[3];
        int sum = 0;
        try {
            checkSize(MyArray);
            //checkSize(MyArray1); //error
            //checkSize(MyArray2); //error
            //checkSize(MyArray3); //error

            sum = sum(MyArray);
            System.out.println(sum);

        }catch (MyArraySizeException e){
            System.out.println(e.getMessage());;
        }catch (MyArrayDataException e){
            System.out.println(e. getMessage());
        }




    }
    

    public static int sum(String[][] array) throws MyArrayDataException {
        int result = 0;
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                String value = array[i][j];
                try {
                    result += Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Элемент [%d][%d]: \"%s\" - не вляется числом\n", i,j, value), array, i, j);
                }
            }
        }
        return result;
    }


    /**
     * Метод выбрасывает исключение если размер массива не 4х4
     * @param array
     * @throws MyArraySizeException
     */
    public static void checkSize(String[][] array) throws MyArraySizeException{
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
