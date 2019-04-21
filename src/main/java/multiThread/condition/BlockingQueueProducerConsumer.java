package multiThread.condition;

import java.util.concurrent.*;

/**
 * Created by vera on 19-4-21.
 */
public class BlockingQueueProducerConsumer {
    public static void main(String[] agrs){
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);
        ExecutorService service = Executors.newFixedThreadPool(15);
        for(int i = 0; i < 5; i++) {
            service.submit(new Producer(blockingQueue));
        }
        for(int i = 0; i < 10; i++) {
            service.submit(new Consumer(blockingQueue));
        }
    }
}

class Producer implements Runnable{
    BlockingQueue<Integer> blockingQueue;
    public Producer(BlockingQueue<Integer> queue){
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                blockingQueue.put(1);
                System.out.println("生产者" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    BlockingQueue<Integer> blockingQueue;
    public Consumer(BlockingQueue<Integer> queue){
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                blockingQueue.take();
                System.out.println("消费者" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
