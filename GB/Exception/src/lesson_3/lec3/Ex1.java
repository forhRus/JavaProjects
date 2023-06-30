package lesson_3.lec3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex1 {
    public static void main(String[] args) {
        String p1 = "/home/forh/1.My_files/Projects/Java_Projects/GB/Exception/src/lesson_3/lec3/test.txt";
        String p2 = "/home/forh/1.My_files/Projects/Java_Projects/GB/Exception/src/lesson_3/lec3/writer.txt";
        try(FileReader reader = new FileReader(p1);
            FileWriter writer = new FileWriter(p2)){
            while (reader.ready()){
                writer.write(reader.read());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
