
package Practice_Problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Double_Ended_Queue_AKA_DEQUE {
    public static void main(String[] args) {

        // 1. Declaration
        // If we want to use a Deque, we can use the Deque interface
        // with ArrayDeque as its implementation.

        Deque<Integer> dq = new ArrayDeque<>();


        // 2. Insertion
        // If we want to insert elements:
        // addFirst(element) -> Inserts at the front.
        // addLast(element)  -> Inserts at the back.
        // add(element)      -> Same as addLast().

        dq.addFirst(10);
        dq.addLast(20);
        dq.add(30);

        System.out.println(dq); // [10, 20, 30]


        // 3. Accessing Elements
        // If we want to access elements without removing them:
        // peekFirst() -> Returns the front element.
        // peekLast()  -> Returns the last element.
        // peek()      -> Same as peekFirst().

        System.out.println(dq.peekFirst()); // 10
        System.out.println(dq.peekLast());  // 30
        System.out.println(dq.peek());      // 10


        // 4. Deletion
        // If we want to remove elements:
        // removeFirst() -> Removes and returns the front element.
        // removeLast()  -> Removes and returns the last element.
        // pollFirst()   -> Removes the front element, returns null if empty.
        // pollLast()    -> Removes the last element, returns null if empty.
        // poll()        -> Same as pollFirst().

        System.out.println(dq.removeFirst()); // 10
        System.out.println(dq.removeLast());  // 30
        System.out.println(dq);               // [20]


        // 5. Size and Checking
        // If we want to check the Deque:
        // size()       -> Returns the number of elements.
        // isEmpty()    -> Checks whether the Deque is empty.
        // contains()   -> Checks whether an element exists.

        System.out.println(dq.size());        // 1
        System.out.println(dq.isEmpty());     // false
        System.out.println(dq.contains(20));  // true


        // 6. Iteration
        // If we want to traverse a Deque:
        // For-each loop -> Traverses from front to back.

        for (int element : dq) {
            System.out.print(element + " ");
        }
        // Output: 20


        // 7. stack Operations (LIFO)
        // If we want to use Deque as a stack:
        // push(element) -> Inserts at the front.
        // pop()         -> Removes and returns the front element.
        // peek()        -> Returns the front element.

        dq.clear();

        dq.push(10);
        dq.push(20);
        dq.push(30);

        System.out.println(dq);       // [30, 20, 10]
        System.out.println(dq.peek()); // 30
        System.out.println(dq.pop());  // 30


        // 8. Queue Operations (FIFO)
        // If we want to use Deque as a Queue:
        // offer(element) -> Inserts at the back.
        // poll()         -> Removes from the front.
        // peek()         -> Returns the front element.

        dq.clear();

        dq.offer(10);
        dq.offer(20);
        dq.offer(30);

        System.out.println(dq);        // [10, 20, 30]
        System.out.println(dq.poll()); // 10
        System.out.println(dq.peek()); // 20
    }
}
