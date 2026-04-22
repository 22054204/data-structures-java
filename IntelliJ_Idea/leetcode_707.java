package IntelliJ_Idea;

public class leetcode_707 {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addAtHead(10);
        list.addAtHead(20);
        list.addAtTail(30);
        list.addAtIndex(1, 15);   // insert at index 1

        System.out.println("Value at index 0: " + list.get(0));
        System.out.println("Value at index 1: " + list.get(1));
        System.out.println("Value at index 2: " + list.get(2));
        System.out.println("Value at index 3: " + list.get(3));

        list.deleteAtIndex(2);    // delete element at index 2

        System.out.println("\nAfter deletion:");
        printList(list);
    }
    // helper function to print list
    public static void printList(MyLinkedList list) {
        MyLinkedList.Node temp = list.head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    static class MyLinkedList {

        static class Node{
            int data;
            Node next;

            Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        Node head;

        public MyLinkedList() {
            head = null;
        }

        public int get(int index) {

            Node temp = head;
            int i = 0;

            while(temp != null){
                if(i == index){
                    return temp.data;
                }
                temp = temp.next;
                i++;
            }
            return -1;
        }

        public void addAtHead(int val) {

            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
        }

        public void addAtTail(int val) {

            Node newNode = new Node(val);

            if(head == null){
                head = newNode;
                return;
            }

            Node temp = head;

            while(temp.next != null){
                temp = temp.next;
            }

            temp.next = newNode;
        }

        public void addAtIndex(int index, int val) {

            if(index == 0){
                addAtHead(val);
                return;
            }

            Node temp = head;
            int i = 0;

            while(temp != null && i < index-1){
                temp = temp.next;
                i++;
            }

            if(temp == null) return;

            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
        }

        public void deleteAtIndex(int index) {

            if(head == null) return;

            if(index == 0){
                head = head.next;
                return;
            }

            Node temp = head;
            int i = 0;

            while(temp.next != null && i < index-1){
                temp = temp.next;
                i++;
            }

            if(temp.next == null) return;

            temp.next = temp.next.next;
        }
    }
}
