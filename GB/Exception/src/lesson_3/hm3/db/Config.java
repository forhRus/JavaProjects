package lesson_3.hm3.db;

/**
 * Хранит путь в папку, где будут хранится файлы с контактами
 */
public class Config {
    private String pathSave = "src/lesson_3/hm3/db/contacts";
    public String getPathSave() {
        return pathSave;
    }
}