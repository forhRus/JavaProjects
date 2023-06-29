package lesson_2.hm2;

public class Task3 {
    // Удалил отлов Exception, потому что из метода main потому что никакие методы сюда исключения не пробрасывает.
    public static void main(String[] args){
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
        // этот блок должен идти в самом конце, для отлова оставшихся ошибок. Но достаточно Exception ловить
        catch (Exception ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    //    Нигде не работаем с файлом, ошибку отслеживать не нужно.
//    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

}
