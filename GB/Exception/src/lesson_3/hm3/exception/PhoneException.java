package lesson_3.hm3.exception;

public class PhoneException extends Exception{
    public PhoneException(String msg) {
        super(String.format("PhoneException: Контак может содержать только цифры. Вы ввели: %s", msg));
    }
}
