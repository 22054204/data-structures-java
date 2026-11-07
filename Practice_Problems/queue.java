
package Practice_Problems;

import java.util.LinkedList;
import java.util.Queue;

public class queue {
    public static void main(String[] args) {

        // 1. Declaration
        // If we want to implement a Queue, we can use the Queue interface.
        // LinkedList or ArrayDeque can be used as its implementation.
        // Queue follows FIFO (First In, First Out).

        Queue<Integer> q = new LinkedList<>();


        // 2. Insertion
        // If we want to insert elements into a Queue:
        // offer(element) -> Inserts an element at the back.
        // add(element)   -> Also inserts at the back.

        q.offer(10);
        q.offer(20);
        q.offer(30);

        System.out.println(q); // [10, 20, 30]


        // 3. Accessing the Front Element
        // If we want to access the front element without removing it:
        // peek() -> Returns the front element, or null if empty.

        System.out.println(q.peek()); // 10


        // 4. Deletion
        // If we want to remove the front element:
        // poll()   -> Removes and returns the front element, or null if empty.
        // remove() -> Removes and returns the front element, throws exception if empty.

        System.out.println(q.poll()); // 10
        System.out.println(q);        // [20, 30]


        // 5. Size and Checking
        // If we want to check the Queue:
        // size()       -> Returns the number of elements.
        // isEmpty()    -> Checks whether the Queue is empty.
        // contains()   -> Checks whether an element exists.
        // clear()      -> Removes all elements.

        System.out.println(q.size());       // 2
        System.out.println(q.isEmpty());    // false
        System.out.println(q.contains(20)); // true

        q.clear();

        System.out.println(q); // []


        // 6. Iteration
        // If we want to traverse a Queue:
        // For-each loop -> Traverses from front to back.

        q.offer(10);
        q.offer(20);
        q.offer(30);

        for (int element : q) {
            System.out.print(element + " ");
        }
        // Output: 10 20 30
    }
}
