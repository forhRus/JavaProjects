package ru.geekbrains.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final int WIN_COUNT = 4; // Р’С‹РёРіСЂС‹С€РЅР°СЏ РєРѕРјР±РёРЅР°С†РёСЏ
    private static final char DOT_HUMAN = 'X'; // Р¤РёС€РєР° РёРіСЂРѕРєР° - С‡РµР»РѕРІРµРє
    private static final char DOT_AI = '0'; // Р¤РёС€РєР° РёРіСЂРѕРєР° - РєРѕРјРїСЊСЋС‚РµСЂ
    private static final char DOT_EMPTY = '*'; // РџСЂРёР·РЅР°Рє РїСѓСЃС‚РѕРіРѕ РїРѕР»СЏ

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field; // Р”РІСѓРјРµСЂРЅС‹Р№ РјР°СЃСЃРёРІ С…СЂР°РЅРёС‚ С‚РµРєСѓС‰РµРµ СЃРѕСЃС‚РѕСЏРЅРёРµ РёРіСЂРѕРІРѕРіРѕ РїРѕР»СЏ

    private static int fieldSizeX; // Р Р°Р·РјРµСЂРЅРѕСЃС‚СЊ РёРіСЂРѕРІРѕРіРѕ РїРѕР»СЏ
    private static int fieldSizeY; // Р Р°Р·РјРµСЂРЅРѕСЃС‚СЊ РёРіСЂРѕРІРѕРіРѕ РїРѕР»СЏ


    public static void main(String[] args) {
        field = new char[3][];

        while (true){
            initialize();
            printField();
            while (true){
                humanTurn();
                printField();
                if (checkGameState(DOT_HUMAN, "Р’С‹ РїРѕР±РµРґРёР»Рё!"))
                    break;
                aiTurn();
                printField();
                if (checkGameState(DOT_AI, "РџРѕР±РµРґРёР» РєРѕРјРїСЊСЋС‚РµСЂ!"))
                    break;
            }
            System.out.print("Р–РµР»Р°РµС‚Рµ СЃС‹РіСЂР°С‚СЊ РµС‰Рµ СЂР°Р·? (Y - РґР°): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * РРЅРёС†РёР°Р»РёР·Р°С†РёСЏ РѕР±СЉРµРєС‚РѕРІ РёРіСЂС‹
     */
    private static void initialize(){

        fieldSizeX = 3;
        fieldSizeY = 3;
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                field[x][y] = DOT_EMPTY;
            }
        }

    }

    /**
     * РћС‚СЂРёСЃРѕРІРєР° РёРіСЂРѕРІРѕРіРѕ РїРѕР»СЏ
     *
     *     +-1-2-3-
     *     1|*|X|0|
     *     2|*|*|0|
     *     3|*|*|0|
     *     --------
     */
    private static void printField(){
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++){
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        }
        System.out.println();

        for (int x = 0; x < fieldSizeX; x++){
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++){
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int x = 0; x < fieldSizeX * 2 + 2; x++){
            System.out.print("-");
        }
        System.out.println();

    }

    /**
     * РћР±СЂР°Р±РѕС‚РєР° С…РѕРґР° РёРіСЂРѕРєР° (С‡РµР»РѕРІРµРє)
     */
    private static void humanTurn(){
        int x, y;

        do {

            while (true){
                System.out.print("Р’РІРµРґРёС‚Рµ РєРѕРѕСЂРґРёРЅР°С‚Сѓ С…РѕРґР° X (РѕС‚ 1 РґРѕ 3): ");
                if (scanner.hasNextInt()){
                    x = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                }
                else {
                    System.out.println("РќРµРєРѕСЂСЂРµРєС‚РЅРѕРµ С‡РёСЃР»Рѕ, РїРѕРІС‚РѕСЂРёС‚Рµ РїРѕРїС‹С‚РєСѓ РІРІРѕРґР°.");
                    scanner.nextLine();
                }
            }

            while (true){
                System.out.print("Р’РІРµРґРёС‚Рµ РєРѕРѕСЂРґРёРЅР°С‚Сѓ С…РѕРґР° Y (РѕС‚ 1 РґРѕ 3): ");
                if (scanner.hasNextInt()){
                    y = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                }
                else {
                    System.out.println("РќРµРєРѕСЂСЂРµРєС‚РЅРѕРµ С‡РёСЃР»Рѕ, РїРѕРІС‚РѕСЂРёС‚Рµ РїРѕРїС‹С‚РєСѓ РІРІРѕРґР°.");
                    scanner.nextLine();
                }
            }
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }
    /**
     * РџСЂРѕРІРµСЂРєР°, СЏС‡РµР№РєР° СЏРІР»СЏРµС‚СЃСЏ РїСѓСЃС‚РѕР№ (DOT_EMPTY)
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }
    /**
     * РџСЂРѕРІРµСЂРєР° РєРѕСЂСЂРµРєС‚РЅРѕСЃС‚Рё РІРІРѕРґР°
     * (РєРѕРѕСЂРґРёРЅР°С‚С‹ С…РѕРґР° РЅРµ РґРѕР»Р¶РЅС‹ РїСЂРµРІС‹С€Р°С‚СЊ СЂР°Р·РјРµСЂРЅРѕСЃС‚СЊ РёРіСЂРѕРІРѕРіРѕ РїРѕР»СЏ)
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * РћР±СЂР°Р±РѕС‚РєР° С…РѕРґР° РєРѕРјРїСЊСЋС‚РµСЂР°
     */
    private static void aiTurn(){
        int x, y;

        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * РџСЂРѕРІРµСЂРєР° СЃРѕСЃС‚РѕСЏРЅРёСЏ РёРіСЂС‹
     * @param c С„РёС€РєР° РёРіСЂРѕРєР°
     * @param s РїРѕР±РµРґРЅС‹Р№ СЃР»РѕРіР°РЅ
     * @return
     */
    private static boolean checkGameState(char c, String s){
        if (checkWin(c)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("РќРёС‡СЊСЏ!");
            return true;
        }

        return false; // РРіСЂР° РїСЂРѕРґРѕР»Р¶Р°РµС‚СЃСЏ
    }

    /**
     * РџСЂРѕРІРµСЂРєР° РїРѕР±РµРґС‹
     * @param c
     * @return
     */
    private static boolean checkWin(char c){

        // РџСЂРѕРІРµСЂРєР° РїРѕ С‚СЂРµРј РіРѕСЂРёР·РѕРЅС‚Р°Р»СЏРј
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // РџСЂРѕРІРµСЂРєР° РїРѕ С‚СЂРµРј РІРµСЂС‚РёРєР°Р»СЏРј
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // РџСЂРѕРІРµСЂРєР° РїРѕ РґРёР°РіРѕРЅР°Р»СЏРј
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;

        return false;
    }

    private static boolean checkWinV2(char c){


        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){

            }
        }

        return false;
    }

    static boolean check1(int x, int y, int win){
        return false;
    }

    /**
     * РџСЂРѕРІРµСЂРєР° РЅР° РЅРёС‡СЊСЋ
     * @return
     */
    private static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

}
