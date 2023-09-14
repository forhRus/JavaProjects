import Exceptions.MyArrayDataException;
import Exceptions.MyArraySizeException;

import java.util.Random;

public class Program {
    private static final Random random = new Random();
    public static void main(String[] args) {

        for (int i = 1; i <= 10 ; i++) {
            System.out.printf("Попытка №%d:\n\n", i);
            try {
                String[][] MyArray = createArray();
                checkSize(MyArray);
                fillArray(MyArray);
                System.out.println("Новый массив:");
                printArray(MyArray);
                System.out.printf("Сумма всех элементов массива: %d\n", sum(MyArray));
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println(e.getMessage());                ;
            }
            System.out.println("--------------------------");
        }

    }

    /**
     * Вывод массива
     * @param array
     */
    public static void printArray(String[][] array){
        for (String[] strings : array) {
            System.out.printf("\t%s", strings[0]);
            for (int j = 1; j < strings.length; j++) {
                System.out.printf(", %s", strings[j]);                ;
            }
            System.out.println();
        }
    }

    /**
     * Заполняет элементы массива случайными числами,
     * Шанс 10%, что добавит символ или букву
     * @param array
     */
    public static void fillArray(String[][] array){
        String string1 = "0123456789";
        String string2 = "!=()abcd";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(random.nextInt(0,50) <= 45){
                    array[i][j] = String.valueOf(string1.charAt(random.nextInt(string1.length())));
                } else {
                    array[i][j] = String.valueOf(string2.charAt(random.nextInt(string2.length())));
                }

            }
        }
    }


    /**
     * Метод создаёт двухмерный массив со случайным размером 4х4 или 5х4
     * @return
     */
    public static String[][] createArray() {
        int n = 4;
        return new String[n + random.nextInt(0, 2)][n];
    }


    /**
     * Метод суммирует элементы двухмерного массива и выбрасывает исключение,
     * если элемент невозможно привести к целочисленному значению
     *
     * @param array
     * @return сумма двухмерного массива
     * @throws MyArrayDataException элемент не число
     */
    public static int sum(String[][] array) throws MyArrayDataException {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                String value = array[i][j];
                try {
                    result += Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Элемент [%d][%d]: \"%s\" - не вляется числом\n", i, j, value), array, i, j);
                }
            }
        }
        return result;
    }


    /**
     * Метод выбрасывает исключение если размер массива не 4х4
     *
     * @param array
     * @throws MyArraySizeException
     */
    public static void checkSize(String[][] array) throws MyArraySizeException {
        int size = 4;
        int length = array.length;

        //первичная проверка
        ERROR:
        if (length == size) {
            //проверка зубчатого массива
            for (String[] strings : array) {
                if (strings.length != size) {
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
