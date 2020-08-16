class PrimeNumberException extends Exception {
    int number;

    public PrimeNumberException(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PrimeNumberException{" +
                "number=" + number +
                '}';
    }
}

public class Program3 {
    public static void main(String []args)
    {
        for (int i = 1; i <= 100; i++) {
            try
            {
                if(isPrime(i))
                    throw new PrimeNumberException(i);
            }
            catch (PrimeNumberException e)
            {
                System.out.println(e);
            }
        }
    }

    private static boolean isPrime(int i) {
        if(i<=1)
            return false;

        for (int j = 2; j*j <= i; j++) {
            if(i%j == 0)
                return false;
        }
        return true;
    }
}
