package lesson_2.hm2;

public class Task2 {
    public static void main(String[] args) {
        /**
         * Я не понял, что тут хотели сделать?
         * Инициализация переменной с плавающей точкой, через деление длины нового массива на взаранее
         * инициализированную переменную, с отловом исключений деления на 0
         * Нужно больше информации давать.
         */
        try {
            int d = 0;
            // double catchedRes1 = intArray[8] / d;
            double catchedRes1 = new int[8].length / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }


}
