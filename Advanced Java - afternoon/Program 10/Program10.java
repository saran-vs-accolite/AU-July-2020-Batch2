import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Program10 {
    public static void main(String[] args) {
        try {
            Path src = Paths.get("/home/saran/Desktop/Accolite/1.txt");
            Path dest = Paths.get("/home/saran/Desktop/1.txt");
            Files.copy(src, dest);
            System.out.println("Copy Successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
