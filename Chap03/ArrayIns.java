package Chap03;

public class ArrayIns {
    private long[] array;
    private int nElements;

    public ArrayIns(int max) {
        this.array = new long[max];
        this.nElements = 0;
    }

    public void insert(long value) {
        array[nElements] = value;
        nElements++;
    }

    public void display() {
        for (int i = 0; i < nElements; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public void insertSort() {
        int in;
        for (int out = 1; out < nElements; out++) {
            long temp = array[out];
            in = out;
            while (in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
    }
}
