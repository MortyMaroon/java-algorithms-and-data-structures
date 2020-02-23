package Chap02;

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
}
