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
            winCount = 4;
            int x = 6, y = 6;
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
        int xB, yB;
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if(field[x][y] == DOT_EMPTY){
                    field[x][y] = DOT_HUMAN;
                    if (checkWin(DOT_HUMAN)){
                        field[x][y] = DOT_AI;
                        return;
                    } else{
                        field[x][y] = DOT_EMPTY;
                    }
                }
            }
        }
        do {
            xB = random.nextInt(fieldSizeX);
            yB = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(xB, yB));
        field[xB][yB] = DOT_AI;
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
                if (checkHor(c, x, y))
                    return true;

                //проверка вертикали
                if (checkVer(c, x, y))
                    return true;

                //проверка диагонали1
                if (checkDi1(c, x, y))
                    return true;

                //проверка диагонали2
                if (checkDi2(c, x, y))
                    return true;
            }
        }
        return false;
    }

    //проверка диагонали1
    private static boolean checkDi1(char c, int x, int y) {
        boolean f = false;
        if (x + winCount <= fieldSizeX && y + winCount <= fieldSizeY) {
            for (int z = 0; z < winCount; z++) {
                if (field[x + z][y + z] != c) {
                    return false;
                }
            }
            f = true;
        }
        return f;
    }

    //проверка диагонали2
    private static boolean checkDi2(char c, int x, int y) {
        boolean f = false;
        if (x - winCount + 1 >= 0 && y + winCount <= fieldSizeY) {
            for (int z = 0; z < winCount; z++) {
                if (field[x - z][y + z] != c) {
                    return false;
                }
            }
            f = true;
        }
        return f;
    }


    /**
     * Проверка горизонтали
     *
     * @param c
     * @param x
     * @param y
     * @return
     */
    private static boolean checkHor(char c, int x, int y) {
        boolean f = false;
        if (y + winCount <= fieldSizeY) {
            for (int z = 0; z < winCount; z++) {
                if (field[x][y + z] != c) {
                    return false;
                }
            }
            f = true;
        }
        return f;
    }

    /**
     * Проверка вертикали
     *
     * @param c
     * @param x
     * @param y
     * @return
     */
    private static boolean checkVer(char c, int x, int y) {
        boolean f = false;
        if (x + winCount <= fieldSizeX) {
            for (int z = 0; z < winCount; z++) {
                if (field[x + z][y] != c) {
                    return false;
                }
            }
            f = true;
        }
        return f;
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
