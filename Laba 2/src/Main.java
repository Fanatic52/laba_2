import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Tasks.taskOneOne("Hello world, i'm very happy! Hello world, i'm very happy!");
        Tasks.taskOneTwo("Hello world, i'm very happy! Hello world, i'm very happy!");
        try {
            Tasks.taskTree("D:\\вадім\\інше\\Пари\\JAVA\\Laba 2\\Laba 2\\\\input.txt","D:\\вадім\\інше\\Пари\\JAVA\\Laba 2\\Laba 2\\output.txt");
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        try {
            Tasks.taskTwo("D:\\вадім\\інше\\Пари\\JAVA\\Laba 2\\Laba 2\\txt.txt");
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
