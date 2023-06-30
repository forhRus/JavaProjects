package lesson_3.hm3.MVC;

import lesson_3.hm3.db.Config;
import lesson_3.hm3.exception.CountException;
import lesson_3.hm3.exception.PhoneException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    String pathDataBase;

    public Model() {
    }

    public Model(Config c) {
        this.pathDataBase = c.getPathSave();
    }

    public void saveContact(String contact) {
        try {
            String[] field = contact.split(" ");
            if (field.length != 4) {
                throw new CountException(field.length);
            } else {
                try {
                    //  Не придумал, как проверить контакт на наличе символов
                    int phone = Integer.parseInt(field[3]);
                } catch (NumberFormatException e) {
                    throw new PhoneException(field[3]);
                }
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < field.length; i++) {
                result.append(String.format("<%s>", field[i]));
            }
            result.append("\n");
            save(field[0], result.toString());
        } catch (CountException e) {
            System.out.println(e.getMessage());
        } catch (PhoneException e) {
            System.out.println(e.getMessage());
        }
    }

    private void save(String nameFile, String contact) {
        try (FileWriter fw = new FileWriter(String.format("%s/%s", pathDataBase, nameFile), true)) {
            fw.write(contact);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}