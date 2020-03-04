package Chap04;

public class QueueWithoutCounter {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;

    public QueueWithoutCounter(int maxSize) {
        this.maxSize = maxSize + 1;
        this.queArray = new long[maxSize];
        this.front = 0;
        this.rear = -1;
    }

    public void insert(long value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = value;
    }

    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        return temp;
    }

    public long peek() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (rear + 1 == front || front + maxSize - 1 == rear);
    }

    public boolean isFull() {
        return (rear + 2 == front || front + maxSize - 2 == rear);
    }

    public int size() {
        if (rear >= front) {
            return rear - front - 1;
        } else {
            return maxSize - front + rear + 1;
        }
    }
}
