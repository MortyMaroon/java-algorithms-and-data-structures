package Chap03;

public class ArraySel {
    private long[] array;
    private int nElement;

    public ArraySel(int max) {
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

    public void selectionSort() {
        int min;
        for (int out = 0; out < nElement - 1; out++) {
            min = out;
            for (int in = out + 1; in < nElement; in++) {
                if (array[in] < array[min]) {
                    min = in;
                }
            }
            sort(out,min);
        }
    }

    public void sort(int one, int two) {
        long temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }
}
