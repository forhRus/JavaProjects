import java.io.File;

public class Tree {

    public static void main(String[] args) {

        print(new File("."), "", true);

    }

    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else{
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        int length = files.length;

        for (int i = 0; i < length; i++) {
            print(files[i], indent, i == length - 1);
        }
    }

}
