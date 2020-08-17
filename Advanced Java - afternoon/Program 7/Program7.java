import java.io.File;

public class Program7 {
    public static void main(String[] args) {
        String mainDirectory = "/home/saran/Desktop/Competitive Programming/codeforces";
        File mainDir = new File(mainDirectory);

        if(mainDir.exists() && mainDir.isDirectory())
        {
            File arr[] = mainDir.listFiles();
            System.out.println("Main Directory: " + mainDir);
            listAllFilesOfDirectory(arr, 0, 0);
        }
    }

    private static void listAllFilesOfDirectory(File[] arr, int index, int level) {
        if(index == arr.length)
            return;

        for (int i = 0; i < level; i++)
            System.out.print("\t");

        if(arr[index].isFile())
            System.out.println(arr[index].getName());
        else if(arr[index].isDirectory())
        {
            System.out.println("[" + arr[index].getName() + "]");
            listAllFilesOfDirectory(arr[index].listFiles(), 0, level + 1);
        }
        listAllFilesOfDirectory(arr,index+1, level);
    }

}

