
package Practice_Problems;

import java.util.PriorityQueue;
import java.util.Collections;

public class Heap_Min_Max {
    public static void main(String[] args) {

        // 1. Min Heap Declaration
        // If we want to implement a Min Heap, use PriorityQueue.
        // By default, PriorityQueue follows Min Heap.
        // The smallest element always stays at the top.

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        // 2. Insertion (Min Heap)
        // If we want to insert elements into a Heap:
        // offer(element) -> Inserts an element into the Heap.
        // add(element)   -> Also inserts an element.

        minHeap.offer(30);
        minHeap.offer(10);
        minHeap.offer(20);

        System.out.println(minHeap); // Heap representation, not sorted order.


        // 3. Accessing the Top Element (Min Heap)
        // If we want to access the smallest element:
        // peek() -> Returns the smallest element without removing it.

        System.out.println(minHeap.peek()); // 10


        // 4. Deletion (Min Heap)
        // If we want to remove the smallest element:
        // poll() -> Removes and returns the smallest element.

        System.out.println(minHeap.poll()); // 10
        System.out.println(minHeap.peek()); // 20


        // 5. Min Heap Iteration
        // If we want to process elements in ascending order:
        // Keep calling poll() until the Heap becomes empty.
        // Direct iteration does NOT guarantee sorted order.

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        // Output: 20 30

        System.out.println();


        // 6. Max Heap Declaration
        // If we want to implement a Max Heap:
        // Use Collections.reverseOrder() as the comparator.
        // The largest element always stays at the top.

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());


        // 7. Insertion (Max Heap)
        // offer(element) -> Inserts an element into the Heap.

        maxHeap.offer(30);
        maxHeap.offer(10);
        maxHeap.offer(20);

        System.out.println(maxHeap); // Heap representation, not sorted order.


        // 8. Accessing the Top Element (Max Heap)
        // peek() -> Returns the largest element without removing it.

        System.out.println(maxHeap.peek()); // 30


        // 9. Deletion (Max Heap)
        // poll() -> Removes and returns the largest element.

        System.out.println(maxHeap.poll()); // 30
        System.out.println(maxHeap.peek()); // 20


        // 10. Max Heap Iteration
        // If we want to process elements in descending order:
        // Keep calling poll() until the Heap becomes empty.

        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        // Output: 20 10
    }
}
