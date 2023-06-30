package lesson_3.hm3.MVC;

public class Presenter {
    View v;
    Model m;

    public Presenter(View v, Model m) {
        this.v = v;
        this.m = m;
    }

    public void addContact(){
        v.println("Введите ФИО контакта и номер телефона без символов (всё данные вводятся через пробел)");
        String contact = v.inputString(); // получаем строку от пользователя
        m.saveContact(contact); // записываем, если удовлетворит условию

//Я процессе отладки, я понял, что обрабатывать ошибки надо было тут,
// чтобы можно было вьюшкой пользоваться, но переделывать лень
    }

}
