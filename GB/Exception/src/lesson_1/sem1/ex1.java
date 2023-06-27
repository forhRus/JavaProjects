package lesson_1.sem1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class ex1 {
    public class Main {
        static Scanner scanner = new Scanner(System.in);
        static Random random = new Random();


        public static void main(String[] args) {
            // System.out.printf("Длина массива: %d \n", Task1(new int[]{2, 3, 4, 5, 98}));
            // Task2();
            // Task3();
            Task4();
        }

        /**
         * Реализуте метод, принимающий в качестве аргумента целочисленный массив.
         * Если длина массива меньшенекоторого заданного минимума, метод возвращает -1
         * в качестве кода ошибки, иначе - длину массива
         */
        static int Task1(int[] arr) {
            if (arr.length == 0) {
                return -1;
            }
            return arr.length;
        }

        /**
         * Реализуйте метод, принимающие в качестве агрумента целочисленный массив и некоторое значение.
         * Метод ищет в массиве значение и возращает его индекс. При этом, например:
         * 1. если длина массива меньше некоторого заданного минимума, метод возвращает -1
         * 2. если искомый элемент не найден, -2
         * 3. если вместо массивы приш1л null, -3
         */

        static void Task2() {
            while (true) {
                System.out.println("Введите число для поиска: ");
                if (scanner.hasNextInt()) {
                    int searchNumber = scanner.nextInt();
                    int[] array = new int[random.nextInt(5) + 1];
                    if (random.nextInt(2) == 0) {
                        array = null;
                    }
                    if (array != null) {
                        for (int i = 0; i < array.length; i++) {
                            array[i] = random.nextInt(10);
                            System.out.printf("%d \t", array[i]);
                        }
                        System.out.println();
                    }
                    int codeResult = processArray(array, searchNumber);
                    if (codeResult == -1) {
                        System.out.println("Длина массива < 3 элементов");
                    } else if (codeResult == -2) {
                        System.out.println("Элемент не найден");
                    } else if (codeResult == -3) {
                        System.out.println("Массив некоректно проинициализирован");
                    } else {
                        System.out.println("Массив успешно обработан");
                        System.out.printf("Элемент найден по индексу: %d\n", codeResult);
                    }
                } else {
                    System.out.println("Вы ввели не число, повторите ввод: ");
                    scanner.nextLine();
                }
            }

        }

        static int processArray(int[] arr, int searchNumber) {
            if (arr == null) {
                return -3;
            }
            if (arr.length < 3) {
                return -1;
            }
            Arrays.sort(arr);
            int searchRes = Arrays.binarySearch(arr, searchNumber);
            for (int el : arr) {
                System.out.printf("%d\t", el);
            }
            System.out.println();
            if (searchRes < 0) {
                return -2;
            }
            return searchRes;
        }


        /**
         * Реализуейте метод, принимающий в качестве аргумента целочисленный двумерный массив.
         * необходимо посчитать и венуть сумму лементов этого массива.
         * при это накладываем на метод 2 ограничения: метод может работать только с квадраными массивами.
         * и в каждой ячейки может лежать значение 0 или 1
         * если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке
         */

        static void Task3() {
            for (int i = 0; i < 5; i++) {
                System.out.printf("\n ***Итерация %d***\n\n", i + 1);
                processArray(generateArray());
            }
        }

        static void processArray(int[][] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != arr.length) {
                    // throw new IOException();
                    throw new RuntimeException("Некорректная размерность массива");
                }
            }
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] != 0 && arr[i][j] != 1) {
                        throw new RuntimeException(String.format("Некорректное значение элемента массива", i, j));
                    } else {
                        sum += arr[i][j];
                    }
                }
            }
            System.out.printf("Сумма элементов: %d\n", sum);
        }


        static int[][] generateArray() {
            int[][] arr = new int[random.nextInt(2) + 4][5];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = random.nextInt(2);
                    if (random.nextInt(1000) == 0) {
                        arr[i][j] = 2; // РќР°РјРµСЂРЅРµРЅРЅР°СЏ РѕС€РёР±РєР°
                    }
                    System.out.printf("%d ", arr[i][j]);
                }
                System.out.println();
            }
            return arr;
        }


        /**
         * Р РµР°Р»РёР·СѓР№С‚Рµ РјРµС‚РѕРґ, РїСЂРёРЅРёРјР°СЋС‰РёР№ РІ РєР°С‡РµСЃС‚РІРµ Р°СЂРіСѓРјРµРЅС‚Р° С†РµР»РѕС‡РёСЃР»РµРЅРЅС‹Р№ РґРІСѓРјРµСЂРЅС‹Р№ РјР°СЃСЃРёРІ.
         * РќРµРѕР±С…РѕРґРёРјРѕ РїРѕСЃС‡РёС‚Р°С‚СЊ Рё РІРµСЂРЅСѓС‚СЊ СЃСѓРјРјСѓ СЌР»РµРјРµРЅС‚РѕРІ СЌС‚РѕРіРѕ РјР°СЃСЃРёРІР°.
         * РџСЂРё СЌС‚РѕРј РЅР°РєР»Р°РґС‹РІР°РµРј РЅР° РјРµС‚РѕРґ 2 РѕРіСЂР°РЅРёС‡РµРЅРёСЏ: РјРµС‚РѕРґ РјРѕР¶РµС‚ СЂР°Р±РѕС‚Р°С‚СЊ С‚РѕР»СЊРєРѕ СЃ РєРІР°РґСЂР°С‚РЅС‹РјРё РјР°СЃСЃРёРІР°РјРё
         * (РєРѕР»-РІРѕ СЃС‚СЂРѕРє = РєРѕР»-РІСѓ СЃС‚РѕР»Р±С†РѕРІ), Рё РІ РєР°Р¶РґРѕР№ СЏС‡РµР№РєРµ РјРѕР¶РµС‚ Р»РµР¶Р°С‚СЊ С‚РѕР»СЊРєРѕ Р·РЅР°С‡РµРЅРёРµ 0 РёР»Рё 1.
         * Р•СЃР»Рё РЅР°СЂСѓС€Р°РµС‚СЃСЏ РѕРґРЅРѕ РёР· СѓСЃР»РѕРІРёР№, РјРµС‚РѕРґ РґРѕР»Р¶РµРЅ РІРµСЂРЅСѓС‚СЊ РєРѕРґ РѕС€РёР±РєРё.
         * РџСЂРѕРіСЂР°РјРјР° РґРѕР»Р¶РЅР° РєРѕСЂСЂРµРєС‚РЅРѕ РѕР±СЂР°Р±РѕС‚Р°С‚СЊ РєРѕРґ РѕС€РёР±РєРё Рё РІС‹РІРµСЃС‚Рё СЃРѕРѕС‚РІРµС‚СЃС‚РІСѓСЋС‰РµРµ СЃРѕРѕР±С‰РµРЅРёРµ РїРѕР»СЊР·РѕРІР°С‚РµР»СЋ.
         * РЎСЂР°РІРЅРёС‚СЊ С‚Р°РєРѕР№ РІР°СЂРёР°РЅС‚ РѕР±СЂР°Р±РѕС‚РєРё РёСЃРєР»СЋС‡РµРЅРёР№ СЃ РїСЂРµРґС‹РґСѓС‰РёРј.
         */

        static void Task4() {
            for (int i = 0; i < 5; i++) {
                System.out.printf("\n ***РС‚РµСЂР°С†РёСЏ %d ***\n\n", i + 1);
                int errCode = processArrayV2(generateArray());
                if (errCode == -1) {
                    System.out.println("РќРµРєРѕСЂСЂРµРєС‚РЅР°СЏ СЂР°Р·РјРµСЂРЅРѕСЃС‚СЊ");
                } else if (errCode == -2) {
                    System.out.println("РќРµРєРѕСЂСЂРµРєС‚РЅРѕРµ Р·РЅР°С‡РµРЅРёРµ РјР°СЃСЃРёРІР°");
                } else {
                    System.out.printf("РЎСѓРјРјР° СЌР»РµРјРµРЅС‚РѕРІ РјР°СЃСЃРёРІР°: %d", errCode);
                }
            }
        }

        static int processArrayV2(int[][] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != arr.length) {
                    return -1;
                }
            }
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] != 0 && arr[i][j] != 1) {
                        return -2;
                    } else {
                        sum += arr[i][j];
                    }
                }
            }
            return sum;
        }
    }
}