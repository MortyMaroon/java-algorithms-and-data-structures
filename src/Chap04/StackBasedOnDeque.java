package Chap04;

public class StackBasedOnDeque {
    private Deque deque;

    public StackBasedOnDeque(int maxSize) {
        this.deque = new Deque(maxSize);
    }

    public void push(long value) {
        deque.insertRight(value);
    }

    public long pop() throws Exception {
        return deque.removeRight();
    }

    public long peek() {
        return deque.peekRight();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.isFull();
    }
}
