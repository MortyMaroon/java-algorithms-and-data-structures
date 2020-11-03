package Chap04;

public class Deque {
    private int maxSize;
    private long[] dequeArray;
    private int leftSide;
    private int rightSide;
    private int nElements;

    public Deque(int maxSize) {
        this.maxSize = maxSize;
        this.dequeArray = new long[maxSize];
        this.leftSide = 0;
        this.rightSide = -1;
        this.nElements = 0;
    }

    public void insertLeft(long value) {
        if (!isFull()) {
            if (leftSide == 0) {
                leftSide = maxSize;
            }
            dequeArray[--leftSide] = value;
            nElements++;
        } else {
            System.out.println("Deque is full");
        }
    }

    public void insertRight(long value) {
        if (!isFull()) {
            if (rightSide == maxSize - 1) {
                rightSide = -1;
            }
            dequeArray[++rightSide] = value;
            nElements++;
        } else {
            System.out.println("Deque is full");
        }
    }

    public long removeLeft() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque is empty");
        }
        long temp = dequeArray[leftSide++];
        if (leftSide == maxSize) {
            leftSide = 0;
        }
        nElements--;
        return temp;
    }

    public long removeRight() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque is empty");
        }
        long temp = dequeArray[rightSide--];
        if (rightSide == -1) {
            rightSide = maxSize - 1;
        }
        nElements--;
        return temp;
    }

    public long peekLeft() {
        return dequeArray[leftSide];
    }

    public long peekRight() {
        return dequeArray[rightSide];
    }

    public boolean isFull() {
        return (nElements == maxSize);
    }

    public boolean isEmpty() {
        return (nElements == 0);
    }
}
