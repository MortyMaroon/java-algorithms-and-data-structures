package Chap05.Works;

public class PriorityQueueOnSortedLinkedList {
    private SortedLinkedList list = new SortedLinkedList();
    private int counter = 0;

    public void insert(long value) {
        list.insert(counter++,value);
    }

    public long remove() {
        return list.deleteFirst().getData();
    }

    private boolean isEmpty() {
        return list.isEmpty();
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("PriorityQueueOnSortedLinkedList is empty");
        } else {
            LinkItem current = list.getFirst();
            while (current != null) {
                current.displayLink();
                current = current.getNext();
            }
            System.out.println();
        }
    }
}
