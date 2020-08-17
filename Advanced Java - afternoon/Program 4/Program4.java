import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Program4 {
    public static void main(String []args) {
        List<Integer> integers = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());

        System.out.println("Printing only even numbers");
        integers.forEach(integer -> {
            if(integer%2 == 1)
                return;
            System.out.println(integer);
        });
    }
}
