package gc.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftReferenceTest {
    public static void main(String[] args){
       test1();
    }
    public static void test1(){
        // 软引用可以和一个引用队列(ReferenceQueue)联合使用。如果软引用所引用对象被垃圾回收，JAVA虚拟机就会把这个软引用加入到与之关联的引用队列中
        ReferenceQueue<String> softReferenceQueue = new ReferenceQueue<>();
        String str1 = new String("abc"); // 堆空间上new出一个"abc"字符串，这里称这个"abc"为A对象，str1是指向A对象的强引用（这里一共产生了两个"abc"字符串，一个在堆空间，一个在常量池）
        SoftReference<String> softReference = new SoftReference<>(str1, softReferenceQueue); // 建立一个弱引用，指向堆空间上的"abc"

        ReferenceQueue<String> weakReferenceQueue = new ReferenceQueue<>();
        String str2 = new String("abc"); // 堆空间上new出一个"abc"字符串，这里称这个"abc"为B对象，str2是指向B对象的强引用（B对象和A对象不是同一个。也就是说，现在堆空间上有两个"abc"对象）
        WeakReference<String> weakReference = new WeakReference<>(str2, weakReferenceQueue);

        str1 = null; // 去掉了A对象的强引用（A目前只有一个软引用了）
        str2 = null; // 去掉了B对象的强引用（B目前只有一个弱引用了）

        // Notify GC
        System.gc(); // System.gc()方法只是起通知作用，JVM什么时候扫描回收对象是JVM自己的状态决定的

        // 由于垃圾回收器是一个优先级很低的线程，因此不一定会很快发现那些只具有弱引用的对象。所以这里等待几秒
        try {
            // 休息几分钟，等待上面的垃圾回收线程运行完成
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 如果一个对象只具有软引用，则内存空间充足时，垃圾回收器就不会回收它；如果内存空间不足了，就会回收这些对象的内存
        System.out.println(softReference.get()); // abc
        Reference<? extends String> softReferenceGc = softReferenceQueue.poll();
        System.out.println(softReferenceGc); // null

        // 在垃圾回收器线程扫描它所管辖的内存区域的过程中，一旦发现了只具有弱引用的对象，不管当前内存空间足够与否，都会回收它的内存
        System.out.println(weakReference.get()); // null
        Reference<? extends String> weakReferenceGc = weakReferenceQueue.poll();
        System.out.println(weakReferenceGc); //not null
    }

    public static void test2(){
        ReferenceQueue<String> softReferenceQueue = new ReferenceQueue<>();
        SoftReference<String> softReference = new SoftReference<>("abc", softReferenceQueue); // 建立一个弱引用，指向常量池中的"abc"（常量池中的"abc"是唯一的）

        ReferenceQueue<String> weakReferenceQueue = new ReferenceQueue<>();
        WeakReference<String> weakReference = new WeakReference<>("abc", weakReferenceQueue); // 建立一个弱引用，指向常量池中的"abc"（和上面那个"abc"是同一个）

        // Notify GC
        System.gc();

        try {
            // 休息几分钟，等待上面的垃圾回收线程运行完成
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 常量池中的"abc"目前有一个软引用和一个弱引用
        System.out.println(softReference.get()); // abc
        Reference<? extends String> softReferenceGc = softReferenceQueue.poll();
        System.out.println(softReferenceGc); // null

        System.out.println(weakReference.get()); // abc
        Reference<? extends String> weakReferenceGc = weakReferenceQueue.poll();
        System.out.println(weakReferenceGc); // null
    }

    public static void test3(){
        String str = new String("abc");
        WeakReference<String> weakReference = new WeakReference<>(str);
        // 弱引用转强引用
        String strongReference = weakReference.get();
    }
}


