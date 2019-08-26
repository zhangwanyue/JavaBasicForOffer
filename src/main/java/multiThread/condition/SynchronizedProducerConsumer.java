package multiThread.condition;

import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedProducerConsumer {
    public static void main(String[] args){
        LinkedList plate = new LinkedList<String>();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i=0; i<5; i++){
            cachedThreadPool.submit(new SynchronizedProducerConsumer.Producer(plate, 5));
        }
        for(int i=0; i<3; i++){
            cachedThreadPool.submit(new SynchronizedProducerConsumer.Consumer(plate));
        }
    }


    static class Producer implements Callable<String> {
        LinkedList<String> plate;
        int maxSize;

        public Producer(LinkedList<String> plate, int maxSize) {
            this.plate = plate;
            this.maxSize = maxSize;
        }

        @Override
        public String call() throws Exception {
            while(true) {
                synchronized (plate) {
                    while (plate.size() == maxSize) {
                        plate.wait();
                    }
                    plate.push("apple");
                    plate.notifyAll();
                    System.out.println("produce an apple, remain: " + plate.size());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Callable<String>{
        LinkedList<String> plate;

        public Consumer(LinkedList<String> plate) {
            this.plate = plate;
        }

        @Override
        public String call() throws Exception {
            while(true) {
                synchronized (plate) {
                    while (plate.isEmpty()) {
                        plate.wait();
                    }
                    String result = plate.poll();
                    plate.notifyAll();
                    System.out.println("consume an " + result + ", remain: " + plate.size());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
