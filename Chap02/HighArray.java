package Chap02;

import java.util.Collections;

public class HighArray {
    private long[] array;
    private int nElements;

    public HighArray(int max) {
        this.array = new long[max];
        this.nElements = 0;
    }

    public boolean find(long searchKey) {
        int i;
        for (i = 0; i < nElements; i++) {
            if (array[i]  == searchKey) {
                break;
            }
        }
        if (i == nElements) {
            return false;
        } else {
            return true;
        }
    }

    public void insert(long value) {
        array[nElements] = value;
        nElements++;
    }

    public boolean delete(long value) {
        int i;
        for (i = 0; i < nElements; i++) {
            if (array[i]  == value) {
                break;
            }
        }
        if (i == nElements) {
            return false;
        } else {
            for(int j = i; j < nElements; j++) {
                array[j] = array[j + 1];
            }
            nElements--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < nElements; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public long getMax() {
        long max = array[0];
        if (nElements == 0) {
            return -1;
        } else {
            for (int i = 1; i < nElements; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
        }
        return max;
    }

    public long removeMax() {
        long max = array[0];
        int i;
        int  position = 0;
        if (nElements == 0) {
            return -1;
        } else {
            for (i = 1; i < nElements; i++) {
                if (array[i] > max) {
                    max = array[i];
                    position = i;
                }
            }
            for (int j = position; j < nElements; j++) {
                array[j] = array[j + 1];
            }
            nElements--;
            return max;
        }
    }

    public void noDups() {
        long[] newArray = new long[this.nElements];
        boolean flag = false;
        int nElements = 0;

        for (int i = 0; i < this.nElements; i++) {

            for (int j = 0; j < this.nElements; j++) {
                if (newArray[j] == array[i]) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                newArray[nElements] = array[i];
                nElements++;
                flag = false;
            }
        }
        array = newArray;
        this.nElements = nElements;
    }
}
