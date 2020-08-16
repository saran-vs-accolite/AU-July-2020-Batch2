public class AmericanFlag {
    public static void main(String []args)
    {
        for (int i = 0; i < 14; i++) {
            if (i<9) {
                System.out.print(" ");
                if (i % 2 == 0) {
                    for (int j = 0; j < 6; j++) {
                        System.out.print("* ");
                    }
                    for (int j = 0; j < 17; j++) {
                        System.out.print("=");
                    }
                } else {
                    for (int j = 0; j < 5; j++)
                        System.out.print(" *");
                    System.out.print("  ");
                    for (int j = 0; j < 17; j++)
                        System.out.print("=");
                }
            }
            else
            {
                for (int j = 0; j < 30; j++) {
                    System.out.print("=");
                }
            }
            System.out.println();
        }
    }
}
