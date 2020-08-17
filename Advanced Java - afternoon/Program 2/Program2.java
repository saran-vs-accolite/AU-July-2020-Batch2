public class Program2 {
    int instanceVar;

    public Program2(int instanceVar) {
        this.instanceVar = instanceVar;
    }

    public static void main(String []args) {
        Program2 p2 = new Program2(5);
        int a = 6;
        Product p = (int x, int y) -> {
            int ans = p2.instanceVar*x*y;
            p2.instanceVar += 1;
            System.out.println("Instance Variable: " + p2.instanceVar);
            return ans;
        };

        System.out.println(p.findProduct(4, 6));
    }
}

