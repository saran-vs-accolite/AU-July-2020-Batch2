import java.io.*;

public class Program9 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("/home/saran/Desktop/Accolite/1.txt");
            File outputFile = new File("/home/saran/Desktop/Accolite/1copy.txt");

            FileInputStream fin = new FileInputStream(inputFile);
            FileOutputStream fout = new FileOutputStream(outputFile);

            byte[] buffer = new byte[1024];
            int length;

            while((length = fin.read(buffer))>0)
            {
                fout.write(buffer, 0, length);
            }
            fin.close();
            fout.close();
            System.out.println("File Copy Successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
