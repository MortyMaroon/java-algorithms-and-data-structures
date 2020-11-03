package Chap14;

public class PriorityQ {
    private final int SIZE = 20;
    private Edge[] queArray;
    private int size;

    public PriorityQ() {
        queArray = new Edge[SIZE];
        size = 0;
    }

    public void insert(Edge item) {
        int i;
        for (i = 0; i < size; i++) {
            if (item.distance >= queArray[i].distance) {
                break;
            }
        }
        for (int j = size - 1; j >= i; j--) {
            queArray[j+1] = queArray[j];
        }
        queArray[i] = item;
        size++;
    }

    public Edge removeMin() {
        return queArray[--size];
    }

    public void removeN(int n) {
        for (int i = n; i < size - 1; i++) {
            queArray[i] = queArray[i+1];
        }
        size--;
    }

    public Edge peekMin() {
        return queArray[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Edge peekN(int n) {
        return queArray[n];
    }

    public int find(int findIndex) {
        for (int i = 0; i < size; i++) {
            if (queArray[i].destVert == findIndex) {
                return i;
            }
        }
        return  -1;
    }
}
