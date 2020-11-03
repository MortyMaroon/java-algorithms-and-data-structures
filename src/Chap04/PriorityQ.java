package Chap04;

public class PriorityQ {
    private int maxSize;
    private long[] queArray;
    private int nElements;

    public PriorityQ(int Size) {
        this.maxSize = Size;
        this.queArray = new long[maxSize];
        this.nElements = 0;
    }

    public void insert(long value) {
        int i;
        if (nElements == 0) {
            queArray[nElements++] = value;
        } else {
            for (i = nElements -1; i >= 0; i--) {
                if (value > queArray[i]) {
                    queArray[i + 1] = queArray[i];
                } else {
                    break;
                }
            }
            queArray[i + 1] = value;
            nElements++;
        }
    }

    public long remove() {
        return queArray[--nElements];
    }

    public long peekMin() {
        return queArray[nElements - 1];
    }

    public boolean isEmpty() {
        return (nElements == 0);
    }

    public boolean isFull() {
        return (nElements == maxSize);
    }
}
