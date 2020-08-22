import java.util.Scanner;

public class BlockingQueueExecutor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the capacity of the blocking queue: ");
        int blockingQueueCapacity = s.nextInt();
        BlockingQueue queue = new BlockingQueue(blockingQueueCapacity);

        System.out.println("Enter the number of producer threads: ");
        int numberOfProducerThreads = s.nextInt();
        Thread[] producerThreads = new Thread[numberOfProducerThreads];

        System.out.println("Enter the number of consumer threads: ");
        int numberOfConsumerThreads = s.nextInt();
        Thread[] consumerThreads = new Thread[numberOfConsumerThreads];

        for(int i=0; i< numberOfProducerThreads; i++) {
            producerThreads[i] = new Thread(new Producer(i, queue));
            producerThreads[i].start();
        }

        for (int i = 0; i < numberOfConsumerThreads; i++) {
            consumerThreads[i] = new Thread(new Consumer(i, queue));
            consumerThreads[i].start();
        }

        for (int i = 0; i < numberOfProducerThreads; i++) {
            try {
                producerThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < numberOfConsumerThreads; i++) {
            try {
                consumerThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


