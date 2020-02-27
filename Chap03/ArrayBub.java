package Chap03;

import java.util.Calendar;

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
        Long startTime = Calendar.getInstance().getTime().getTime();

        for (int out = nElement - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    swap(in,in + 1);
                }
            }
        }

        Long endTime = Calendar.getInstance().getTime().getTime();
        System.out.println(String.format("Alternative bubble sorting %s items took %s seconds", nElement, endTime - startTime));
    }

    public void swap(int one, int two) {
        long temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }

    public void alternativeSort()
    {
        Long startTime = Calendar.getInstance().getTime().getTime();

        int inner, rightOuter, leftOuter;
        for (rightOuter = nElement - 1, leftOuter = 0; rightOuter > 1; rightOuter--, leftOuter++)
        {
            for (inner = 0; inner < rightOuter; inner++)
            {
                if (array[inner] > array[inner + 1])
                {
                    long temp = array[inner];
                    array[inner] = array[inner + 1];
                    array[inner + 1] = temp;
                }
            }
            for (inner = rightOuter; inner > 0; inner--)
            {
                if (array[inner] < array[inner - 1])
                {
                    long temp = array[inner];
                    array[inner] = array[inner - 1];
                    array[inner - 1] = temp;
                }
            }
        }

        Long endTime = Calendar.getInstance().getTime().getTime();
        System.out.println(String.format("Alternative bubble sorting %s items took %s seconds", nElement, endTime - startTime));
    }

    public void oddEvenSort() {
        Long startTime = Calendar.getInstance().getTime().getTime();
        for (int i = 0; i < nElement; i++) {
            for (int j = i % 2; j < nElement - 1; j+=2) {
                if (array[j] > array[j + 1]) {
                    long temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        Long endTime = Calendar.getInstance().getTime().getTime();
        System.out.println(String.format("Alternative bubble sorting %s items took %s seconds", nElement, endTime - startTime));
    }
}
