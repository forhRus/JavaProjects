package lesson_2.lec2;

public class Ex2 {
    public static void main(String[] args) {
        int number = 1;
        try{
            number = 10 / 0;
            String test = null;
        } catch (ArithmeticException e){
            System.out.println("На ноль делить нельзя");
        } catch (NullPointerException e){
            System.out.println("null");
        }
        System.out.println(number);
    }
}
