import java.util.*;

public class Program2 {

    public static void main(String []args)
    {
        TreeMap<String, Integer> m = new TreeMap<>();
        System.out.println("Enter the number of Entries: ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the key: ");
            String k = s.next();
            System.out.println("Enter the value: ");
            int v = s.nextInt();
            m.put(k,v);
        }

        System.out.println("Reverse Order View of Keys: " + m.descendingKeySet());
    }

}
