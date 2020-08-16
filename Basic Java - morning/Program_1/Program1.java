import java.util.Scanner;

public class Program1 {
    public static void main(String []args)
    {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the source string: ");
        String sourceString = s.nextLine();
        System.out.println("Enter the regex string: ");
        String regexExpression = s.nextLine();
        System.out.println("Enter the replacement string: ");
        String replacementString = s.nextLine();

        String ans = sourceString.replaceAll(regexExpression, replacementString);
        System.out.println("String after replacement: " + ans);
    }
}
