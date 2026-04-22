//leetcode-23
//Merge K sorted Lists
//https://leetcode.com/problems/merge-k-sorted-lists/description/
package problems_solved_on_intellij;
import java.util.*;
public class leetcode_23 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        leetcode_23 obj = new leetcode_23();

        // Create sample lists:
        // [1->4->5], [1->3->4], [2->6]

        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {l1, l2, l3};

        ListNode result = obj.mergeKLists(lists);

        printList(result);
    }
    // helper function
    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public ListNode mergeKLists(ListNode[] lists) {

        ArrayList<Integer> nums = new ArrayList<>();
        int i = 0;
        while(i<lists.length){
            ListNode curr = lists[i];
            while(curr!=null){
                nums.add(curr.val);
                curr = curr.next;
            }
            i++;
        }
        if(nums.size() == 0) return null;

        Collections.sort(nums);

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        i = 0;
        while(i<nums.size()){
            temp.next = new ListNode(nums.get(i));
            i++;
            temp = temp.next;
        }
        return dummy.next;
    }
}
