package Chap03;

public class ArrayBub {
    private long[] array;
    private int nElement;

    public ArrayBub(int max) {
        this.array = new long[max];
        this.nElement = 0;
    }

    public void insert(long value) {
        array[nElement] = value;
        nElement++;
    }

    public void display() {
        for (int i = 0; i < nElement; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public void bubbleSort() {
        for (int out = nElement - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    swap(in,in + 1);
                }
            }
        }
    }

    public void swap(int one, int two) {
        long temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }
}
