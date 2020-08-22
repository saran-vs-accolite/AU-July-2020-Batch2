import java.util.LinkedList;

public class BlockingQueue {
    LinkedList<Integer> list = new LinkedList<>() ;
    int capacity;

    BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void put(int id, int value) throws InterruptedException {
        while(true) {
            synchronized (this) {
                if(list.size() == this.capacity) {
                    System.out.println("Producer " + id + ": Queue is full. No task present is already taken by the consumer");
                    while(list.size() == this.capacity)
                        wait();
                }

                System.out.println("Producer " + id + " has put the value: " + value);
                list.add(value++);
                notifyAll();

                Thread.sleep(1000);
            }
        }
    }

    public void take(int id) throws InterruptedException {
        while(true) {
            synchronized (this) {
                if(list.size() == 0) {
                    System.out.println("Consumer " + id + ": Queue is empty. There is no task present in the queue");
                    while(list.size() == 0)
                        wait();
                }

                int val = list.removeFirst();
                System.out.println("Consumer " + id + " has taken the value: " + val);
                notifyAll();

                Thread.sleep(1000);
            }
        }
    }
}




