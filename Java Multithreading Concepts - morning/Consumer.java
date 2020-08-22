public class Consumer implements  Runnable{
    int id;
    BlockingQueue obj;

    Consumer(int id, BlockingQueue obj) {
        this.id = id;
        this.obj = obj;
    }

    @Override
    public void run() {
        try {
            obj.take(this.id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
