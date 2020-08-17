import java.io.File;
import java.io.FilenameFilter;

public class Program8 {
    public static void main(String[] args) {
        String directoryPath = "/home/saran/Desktop/Test";
        File directory = new File(directoryPath);

        File[] txtFiles = directory.listFiles(new FilenameFilter() {
                                                @Override
                                                public boolean accept(File file, String s) {
                                                    return s.endsWith(".txt");
                                                }
                                            }
        );

        for (File file: txtFiles) {
            if(file.delete())
                System.out.println("File: " + file.getName()+" successfully deleted");
            else
                System.out.println("File: " + file.getName()+" could not be deleted");
        }
    }
}
