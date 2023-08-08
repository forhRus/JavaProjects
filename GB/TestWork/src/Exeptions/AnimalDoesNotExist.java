package Exeptions;

public class AnimalDoesNotExist extends Exception{
    public AnimalDoesNotExist() {
        super("Животное с таким ID не существует");
    }
}
