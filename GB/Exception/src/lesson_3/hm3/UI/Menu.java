package lesson_3.hm3.UI;

public class Menu {
    private String[] menu;
    private int exit = 0;

    public Menu() {
        this.menu = new String[]
                {
                        String.format("%d. Добавить новый контакт", ++exit),
                        String.format("%d. Выход из программы", ++exit)
                };
    }

    public String[] getMenu() {
        return menu;
    }

    public int getExit() {
        return exit;
    }
}
