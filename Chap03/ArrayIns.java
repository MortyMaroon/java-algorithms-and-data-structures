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
        long comparisons = 0;
        long copies = 0;
        int in , out;
        for (out = 1; out < nElements; out++) {
            long temp = array[out];
            copies++;
            in = out;
            comparisons++;
            while (in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                copies++;
                --in;
                comparisons++;
            }
            array[in] = temp;
            copies++;
        }
        System.out.printf("Copies %s comparisons %s \n", copies, comparisons);
    }

    public long median() {
        insertSort();
        if (array.length % 2 != 0)
        {
            return array[array.length / 2];
        }
        else
        {
            return (array[((array.length - 1) / 2)] + array[(array.length / 2)]) / 2;
        }
    }

    public void noDups() {
        insertSort();
        long[] newArray = new long[nElements];
        int i,j;
        for (i = 0, j = 0; i < nElements; i++) {
            if (j != 0) {
                if (newArray[j - 1] != array[i]) {
                    newArray[j] = array[i];
                    j++;
                }
            } else {
                newArray[j] = array[i];
                j++;
            }
        }
        array = newArray;
        nElements = j;
    }

    public void insertSortWithDups() {
        int in , out;
        int count = 0;
        for (out = 1; out < nElements; out++) {
            long temp = array[out];
            in = out;
            while (in >= count && array[in - 1] >= temp) {
                if (array[in - 1] == temp) {
                    temp = -1;
                    count++;
                }
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
        for (int i = 0; i < nElements; i++) {
            array[i] = array[i + count];
        }
        nElements -= count;
    }

}
