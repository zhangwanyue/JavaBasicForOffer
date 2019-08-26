package multiThread.condition;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vera on 19-3-19.
 */
public class ConditionProductorConsumer {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition full = lock.newCondition();
    private static Condition empty = lock.newCondition();

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList<Integer>();
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 5; i++) {
            service.submit(new Productor(linkedList, 8));
        }
        for (int i = 0; i < 10; i++) {
            service.submit(new Consumer(linkedList));
        }
    }

    static class Productor implements Runnable {

        private List<Integer> list;
        private int maxLength;


        public Productor(List list, int maxLength) {
            this.list = list;
            this.maxLength = maxLength;

        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (list.size() == maxLength) {
                        full.await();
                    }
                    System.out.println("生产者" + Thread.currentThread().getName());
                    list.add(1);
                    empty.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    static class Consumer implements Runnable {

        private List<Integer> list;

        public Consumer(List list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (list.isEmpty()) {
                        empty.await();
                    }
                    Integer element = list.remove(0);
                    System.out.println("消费者" + Thread.currentThread().getName());
                    full.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}

