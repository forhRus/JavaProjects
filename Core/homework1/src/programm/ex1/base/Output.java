package ex1.base;


/**
 * Класс для вывода
 */
public class Output {

    public static String format(Object[] ar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ar.length; i++) {
            sb.append(ar[i]);
        }
        return String.format("Программу запустили:\n%s", sb.toString());
    }


}
