
package Practice_Problems;

import java.util.Stack;

public class stack {
    public static void main(String[] args) {

        // 1. Declaration
        // If we want to implement a stack, we can use the stack class.
        // stack follows LIFO (Last In, First Out).

        Stack<Integer> st = new Stack<>();


        // 2. Insertion
        // If we want to insert elements into a stack:
        // push(element) -> Inserts an element at the top.

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println(st); // [10, 20, 30]


        // 3. Accessing the Top Element
        // If we want to access the top element without removing it:
        // peek() -> Returns the top element.

        System.out.println(st.peek()); // 30


        // 4. Deletion
        // If we want to remove the top element:
        // pop() -> Removes and returns the top element.

        System.out.println(st.pop()); // 30
        System.out.println(st);       // [10, 20]


        // 5. Searching
        // If we want to search for an element:
        // search(element) -> Returns its 1-based position from the top.
        // Returns -1 if the element does not exist.

        System.out.println(st.search(20)); // 1
        System.out.println(st.search(10)); // 2
        System.out.println(st.search(50)); // -1


        // 6. Size and Checking
        // If we want to check the stack:
        // size()       -> Returns the number of elements.
        // isEmpty()    -> Checks whether the stack is empty.
        // contains()   -> Checks whether an element exists.
        // clear()      -> Removes all elements.

        System.out.println(st.size());       // 2
        System.out.println(st.isEmpty());    // false
        System.out.println(st.contains(10)); // true

        st.clear();

        System.out.println(st); // []


        // 7. Iteration
        // If we want to traverse a stack:
        // For-each loop -> Traverses from bottom to top.

        st.push(10);
        st.push(20);
        st.push(30);

        for (int element : st) {
            System.out.print(element + " ");
        }
        // Output: 10 20 30
    }
}
