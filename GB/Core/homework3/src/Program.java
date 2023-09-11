import Base.*;
import Comparators.*;

import java.util.*;
import java.util.function.Consumer;

public class Program {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Random random = new Random();
        /*
        Создаём штат сотрудников
         */
        Staff staff = new Staff();
        /*
        количество будущих сотрдуников
         */
        int countEmployees = 10;
        /*
        Генерируем десяти сотрудников случайного типа занятости и добавляем их в штат
         */
        for (int i = 0; i < countEmployees; i++) {
            int r = random.nextInt(0, 2);
            if (r == 0) {
                staff.add(Worker.getInstance());
            } else {
                staff.add(Freelancer.getInstance());
            }
        }

        /*
        Выводим список
         */
        printList(staff);
        /*
        Сортируем по з\п(по-умолчанию)
         */
        System.out.println("Сортировка по з\\п");
        staff.sort();
        printList(staff);

        /*
        Сортируем по типу занятости
         */
        System.out.println("Сортировка по типу занятости");
        staff.sort(new EmployeeTypeComparator());
        printList(staff);
        /*
        Сортируем по фамилии и имени
         */
        System.out.println("Сортировка по фамилии и имени");
        staff.sort(new EmployeeNameComparator());
        printList(staff);
    }

    /**
     * Вывод штата на экран через foreach
     * @param staff
     */
    private static void printList(Staff staff) {
        for (Employee em : staff) {
            System.out.println(em);
        }
        System.out.println();
    }

}

