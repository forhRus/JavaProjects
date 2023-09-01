package ex1;

import ex1.base.Ar;
import ex1.base.Output;

/**
 * Основной класс приложения.
 */
public class Main {

    /**
     * Программа получает массив строк из класса Ar,
     * обращается к классу Output для получения отформатированной строки
     * и выводит на экран результ
     * @param args
     */
    public static void main(String[] args) {
        String[] array = Ar.getArray();
        String result = Output.format(array);
        System.out.println(result);
    }

}
