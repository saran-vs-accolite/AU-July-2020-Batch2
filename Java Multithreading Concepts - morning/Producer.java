import java.util.Random;

public class Producer implements Runnable {
    int id;
    BlockingQueue obj;
    Random rand = new Random();

    Producer(int id, BlockingQueue obj) {
        this.id = id;
        this.obj = obj;
    }

    @Override
    public void run() {
        try {
            obj.put(this.id, this.rand.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
