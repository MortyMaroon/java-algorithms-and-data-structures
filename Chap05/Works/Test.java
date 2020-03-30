package Chap05.Works;

public class Test {
    public static void main(String[] args) {
        testPriorityQueueOnSortedLinkedList();
        testDeqOnDoublyLinkedList();
        TestCyclicList();
        TestStackOnCyclicList();
    }

    public static void testPriorityQueueOnSortedLinkedList() {
        System.out.println("Testing Queue");
        PriorityQueueOnSortedLinkedList queue = new PriorityQueueOnSortedLinkedList();
        queue.insert(40);
        queue.insert(22);
        queue.insert(12);
        queue.insert(88);
        queue.print();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.insert(99);
        queue.insert(54);
        queue.insert(33);
        queue.insert(9);
        queue.print();
        System.out.println(" ");
    }

    public static void testDeqOnDoublyLinkedList() {
        System.out.println("Testing Dequeue");
        DeqOnDoublyLinkedList dequeue = new DeqOnDoublyLinkedList();
        dequeue.insertLeft(10);
        dequeue.insertRight(20);
        dequeue.insertLeft(30);
        dequeue.insertRight(40);
        dequeue.insertLeft(50);
        dequeue.displayBackward();
        dequeue.displayForward();
        dequeue.removeLeft();
        dequeue.removeRight();
        System.out.println("Deleted first and last elements");
        System.out.println("First " + dequeue.peekLeft() + " and last " + dequeue.peekRight() + " element");
        dequeue.insertAfter(30,60);
        dequeue.deleteKey(30);
        System.out.println(" ");
    }

    public static void TestCyclicList() {
        System.out.println("Testing CyclicLink");
        CyclicList list = new CyclicList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.displayList();
        LinkItem temp = new LinkItem(5,5);
        list.delete(temp);
        list.displayList();
        list.deleteFirst();
        list.displayList();
        list.deleteFirst();
        list.displayList();
        list.deleteFirst();
        list.displayList();
        list.deleteFirst();
        list.displayList();
        list.deleteFirst();
        list.displayList();
        list.deleteFirst();
        list.displayList();
        list.deleteFirst();
        list.displayList();
        System.out.println();
    }

    public static void TestStackOnCyclicList() {
        System.out.println("Testing StackOnCyclicList");
        StackOnCyclicList stackOnCyclicList = new StackOnCyclicList();
        stackOnCyclicList.insert(10);
        stackOnCyclicList.insert(20);
        stackOnCyclicList.insert(30);
        System.out.println( stackOnCyclicList.peekFront());
        stackOnCyclicList.insert(40);
        stackOnCyclicList.insert(50);
        while (!stackOnCyclicList.isEmpty())
        {
            long value = stackOnCyclicList.remove();
            System.out.print(value + " ");
        }
        System.out.println(" ");
    }
}
