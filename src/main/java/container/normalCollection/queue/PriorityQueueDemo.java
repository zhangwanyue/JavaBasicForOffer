package container.normalCollection.queue;

import java.util.Collections;
import java.util.PriorityQueue;

// 该结构是通过最大/小堆实现的（一个完全二叉树，其任意一个非叶子节点的权值都不大于其左右子节点的权值）
public class PriorityQueueDemo {
    public static void main(String[] args){
        PriorityQueue<String> friends = new PriorityQueue<>((x1, x2)->(x2.compareTo(x1))); // 倒序
        Collections.addAll(friends, "John", "David", "Chris", "Alice", "Bob");
        friends.forEach(x->System.out.print(x + " "));
        System.out.println();

        // 添加元素
        friends.add("Eric");
        friends.offer("Floria"); // 和add一样，都是添加元素，但是add在添加失败时抛出异常，offer返回false

        // 获取队首元素
        System.out.println("get front element: " + friends.peek());
        friends.forEach(x->System.out.print(x + " ")); // 输出的时候还是按照队列的顺序输出的
        System.out.println();

        // 删除队首元素
        friends.remove();
        friends.poll(); // 和remove作用相同，都是获取病删除队首元素。但是remove删除失败时抛出异常，poll删除失败时返回null
        friends.forEach(x->System.out.print(x + " "));
        System.out.println();
    }
}
