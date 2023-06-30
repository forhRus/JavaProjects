package lesson_3.hm3.exception;

public class CountException extends Exception{
    public CountException(int count) {
        super(String.format("CountException: Разрешённое количество полей 4. Вы ввели: %d", count));
    }
}
