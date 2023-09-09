import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final char DOT_HUMAN = 'X'; // Фишка игрока - человек
    private static final char DOT_AI = '0'; // Фишка игрока - компьютер
    private static final char DOT_EMPTY = '*'; // Признак пустого поля


    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field; // Двумерный массив хранит текущее состояние игрового поля

    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля
    private static int winCount; // Выигрышная комбинация

    public static void main(String[] args) {
        while (true) {
            winCount = 3;
            int x = 5, y = 5;
            initialize(x, y);
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkGameState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkGameState(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация объектов игры
     */
    private static void initialize(int xSize, int ySize) {

        fieldSizeX = xSize;
        fieldSizeY = ySize;
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     * <p>
     * +-1-2-3-
     * 1|*|X|0|
     * 2|*|*|0|
     * 3|*|*|0|
     * --------
     */
    private static void printField() {
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++) {
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        }
        System.out.println();

        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int x = 0; x < fieldSizeX * 2 + 2; x++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Обработка хода игрока (человек)
     */
    private static void humanTurn() {
        int x, y;

        do {
            while (true) {
                System.out.print("Введите координату хода X (от 1 до 3): ");
                if (scanner.hasNextInt()) {
                    x = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Некорректное число, повторите попытку ввода.");
                    scanner.nextLine();
                }
            }

            while (true) {
                System.out.print("Введите координату хода Y (от 1 до 3): ");
                if (scanner.hasNextInt()) {
                    y = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Некорректное число, повторите попытку ввода.");
                    scanner.nextLine();
                }
            }
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Проверка, ячейка является пустой (DOT_EMPTY)
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность игрового поля)
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Обработка хода компьютера
     */
    private static void aiTurn() {
        int x, y;

        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка состояния игры
     *
     * @param c фишка игрока
     * @param s победный слоган
     * @return
     */
    private static boolean checkGameState(char c, String s) {
        if (checkWin(c)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }

        return false; // Игра продолжается
    }

    /**
     * Проверка победы
     *
     * @param c
     * @return
     */
    private static boolean checkWin(char c) {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                int count = 0;
                //проверка горизонтали
                if (!(y + winCount - 1 > fieldSizeY)) {
                    for (int z = 0; z < winCount; z++) {
                        if (field[x][y + z] == c) {
                            count++;
                            if (count == winCount) {
                                return true;
                            }
                        } else {
                            break;
                        }
                    }
                }
                count = 0;
                //проверка вертикали
                if (!(x + winCount - 1 > fieldSizeX)) {
                    for (int z = 0; z < winCount; z++) {
                        if (field[x + z][y] == c) {
                            count++;
                            if (count == winCount) {
                                return true;
                            }
                        } else {
                            break;
                        }
                    }
                }
                count = 0;
                //проверка диагонали1
                if (x + winCount - 1 <= fieldSizeX && y + winCount - 1 <= fieldSizeY) {
                    for (int z = 0; z < winCount; z++) {
                        if (field[x + z][y + z] == c) {
                            count++;
                            if (count == winCount) {
                                return true;
                            }
                        } else {
                            break;
                        }
                    }
                }
                count = 0;
                //проверка диагонали2
                if (x - winCount >= 0 && y + winCount - 1 <= fieldSizeY) {
                    for (int z = 0; z < winCount; z++) {
                        if (field[x - z][y + z] == c) {
                            count++;
                            if (count == winCount) {
                                return true;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return false;
    }

    /**
     * Проверка на ничью
     *
     * @return
     */
    private static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

}
