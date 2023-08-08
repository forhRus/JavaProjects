package Exeptions;

public class EmptyField extends Exception{
    public EmptyField() {
        super("ОШИБКА! Не все поля заполнены.\n");
    }
}
