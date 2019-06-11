package container.normalCollection.list;

import container.entity.Person;

import java.util.*;
import java.util.function.Predicate;

public class ArrayListDemo {

    public static void printIntegerList(String msg, List<Integer> list){
        System.out.print(msg + ": ");
        list.forEach(x->System.out.print(x + " "));
        System.out.println();
    }

    public static void printPersonList(String msg, List<Person> personList){
        System.out.print(msg + ": ");
        personList.forEach(x->System.out.print(x + " "));
        System.out.println();
    }

    public static void main(String[] args){
        // add
        List<Integer> strList = new ArrayList<>();
        strList.add(0, 0);
        strList.add(1, 5);
        strList.add(2, 3);
        strList.add(3, 4);
        Collections.addAll(strList, 7, 6, 10);
        // 输出全部元素(java8 lambda)
        printIntegerList("origin list", strList);
//        strList.forEach(System.out::println);
        // get
        System.out.println("get index 0: " + strList.get(0));
        // size
        System.out.println("size: " + strList.size());
        // set(修改元素)
        strList.set(0, 2);
        System.out.println("get index 0 after set(0, 2): " + strList.get(0));

        // sort
        Collections.sort(strList);
        printIntegerList("asc order", strList);
        Collections.sort(strList, Collections.reverseOrder()); // desc order
        printIntegerList("desc order", strList);
        strList.sort(Collections.reverseOrder());
        printIntegerList("reverse order", strList);
        strList.sort((x1, x2)->(x2-x1)); // desc order
        printIntegerList("desc order using a Comparator lambda method", strList);
        // object sort
        List<Person> personList = new ArrayList<>();
        Collections.addAll(personList, new Person("Sachin", 47), new Person("Chris", 34), new Person("Rajeev", 25), new Person("David", 31));
        printPersonList("origin personList", personList);
        personList.sort((x1, x2)->(x1.getAge()-x2.getAge()));
        printPersonList("asc order by age", personList);

        // iterate
        Iterator<Integer> listIter1 = strList.iterator();
        System.out.print("iterate: ");
        while(listIter1.hasNext()){
            System.out.print(listIter1.next()+" ");
        }
        System.out.println();
        ListIterator<Integer> listIter2 = strList.listIterator(strList.size()); // 从最后一个开始遍历
        System.out.print("iterate in reverse order: ");
        while(listIter2.hasPrevious()){
            System.out.print(listIter2.previous()+" ");
        }
        System.out.println();

        // search
        System.out.println("Does list contains 5? : " + strList.contains(5));
        System.out.println("indexOf 6: " + strList.contains(6));

        // remove
        strList.remove(0);
        printIntegerList("remove index 0", strList);
        strList.remove(new Integer(5));
        printIntegerList("remove integer 5", strList);
        // 删除满足predicate的元素
        strList.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer.equals(6);
            }
        });
        // 在遍历的时候删除元素（可以在迭代器遍历的时候使用迭代器的remove方法删除元素。不能在使用for each遍历的时候删除元素）
        Iterator<Integer> listIterToRemove = strList.iterator();
        while(listIterToRemove.hasNext()){
            if(listIterToRemove.next()%2 != 0){
                listIterToRemove.remove();
            }
        }
//        strList.removeIf(x->(x%2!=0)); // java8 的迭代删除方式，和上面那种方式是一样的
        printIntegerList("remove odd when iter", strList);
        // remove all elements
        strList.clear();
        printIntegerList("clear list", strList);

        // SynchronizedList（用于在多线程中删除同一个list中的元素）: https://stackoverflow.com/questions/11360401/java-synchronized-list
        // 但是更推荐使用CopyOnWriteArrayList哦
    }
}
