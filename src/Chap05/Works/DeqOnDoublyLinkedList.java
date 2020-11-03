package Chap05.Works;

public class DeqOnDoublyLinkedList {
    private DoubleLinkList list = new DoubleLinkList();

    public void insertLeft(long value) {
        list.insertFirst(value);
    }

    public void insertRight(long value) {
        list.insertLast(value);
    }

    public long removeLeft() {
        return list.deleteFirst().getData();
    }

    public long removeRight() {
        return list.deleteLast().getData();
    }

    public long peekLeft() {
        return list.getFirst().getData();
    }

    public long peekRight() {
        return list.getLast().getData();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void displayForward() {
        list.displayForward();
    }

    public void displayBackward() {
        list.displayBackward();
    }

    public long deleteKey(long key) {
        return list.deleteKey(key).getData();
    }

    public void insertAfter(long key,long value) {
        if (!list.insertAfter(key,value)) {
            System.out.println("Can't insert after " + key);
        }
    }
}
