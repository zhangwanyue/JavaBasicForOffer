package container.normalCollection.stack;

import java.util.*;
import java.util.Stack;

public class StackDemo {
    // stack也可以用LinkedList实现
    public static void main(String[] args){
        Stack<String> stackOfPlates = new Stack<>();
        Collections.addAll(stackOfPlates, "Plate 1", "Plate 2", "Plate 3", "Plate 4", "Plate 5");

        // push item to the top
        stackOfPlates.push("Plate 6");
        String plateAtTop = stackOfPlates.pop();
        System.out.println("pop plateAtTop: " + plateAtTop);

        plateAtTop = stackOfPlates.peek();
        System.out.println("plateAtTop: " + plateAtTop);

    }
}
