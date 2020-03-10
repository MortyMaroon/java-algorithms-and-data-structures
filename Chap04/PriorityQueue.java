package Chap04;

public class PriorityQueue {
    private int maxSize;
    private long[] queArray;
    private int nElements;

    public PriorityQueue(int Size) {
        this.maxSize = Size;
        this.queArray = new long[maxSize];
        this.nElements = 0;
    }

    public void insert(long value) {
        if (!isFull()) {
            queArray[nElements++] = value;
        } else {
            System.out.println("Deque is full");
        }
    }

    public long remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque is empty");
        }
        long temp = peek();
        int in;
        for (in = 0; in < nElements; in++) {
            if (temp == queArray[in]) {
                break;
            }
        }
        for (int j = in; j < nElements; j++) {
            queArray[j] = queArray[j + 1];
        }
        nElements--;
        return temp;

    }

    public long peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque is empty");
        }
        long temp = queArray[0];
        for (int i = 0; i < nElements; i++) {
            if (queArray[i] < temp) {
                temp = queArray[i];
            }
        }
        return temp;
    }

    public boolean isEmpty() {
        return (nElements == 0);
    }

    public boolean isFull() {
        return (nElements == maxSize);
    }

    public void print() throws Exception {
        long temp;
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            while (!isEmpty()) {
                temp = remove();
                System.out.print(temp + " ");
            }
            System.out.println();
        }
    }
}