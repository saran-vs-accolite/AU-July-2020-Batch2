public class Program1 {
    public static void main(String[] args) {
        //Instantiating using lambda expression
        System.out.println("Instantiated using lambda expression");
        Product p1 = (int x, int y) -> x*y;
        System.out.println("Product of 6 and 7 is " + p1.findProduct(6,7));

        //Instantiating using Static Method
        System.out.println("Instantiated using static method");
        Product p2 = Program1::findProduct;
        System.out.println("Product of 6 and 7 is " + p2.findProduct(6,7));

        //Instantiating using instance method
        System.out.println("Instantiated using instance method");
        Product p3 = new Program1()::product;
        System.out.println("Product of 6 and 7 is " + p3.findProduct(6,7));

        //Instantiating using constructor
        System.out.println("Instantiated using constructor");
        Print pr = PrintUtil::new;
        pr.print("Print successful");
    }

    public static int findProduct(int x, int y) {
        return x*y;
    }

    public int product(int x, int y) {
        return x*y;
    }
}

interface Product {
    int findProduct(int x, int y);
}

interface Print {
    void print(String s);
}

class PrintUtil {
    String s;
    PrintUtil(String s) {
        this.s = s;
        System.out.println(s);
    }
}