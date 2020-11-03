package Chap03;

public class ArrayInOb {
    private Person[] array;
    private int nElements;

    public ArrayInOb(int max) {
        this.array = new Person[max];
        this.nElements = 0;
    }

    public void insert(String last, String first, int age) {
        array[nElements] = new Person(last,first,age);
        nElements++;
    }

    public void display() {
        for (int i = 0; i < nElements; i++) {
            array[i].displayPerson();
        }
        System.out.println("");
    }

    public void insertSort() {
        int in;
        for (int out = 1; out < nElements; out++) {
            Person temp = array[out];
            in = out;
            while (in > 0 && array[in - 1].getLast().compareTo(temp.getLast())  > 0) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
    }
}
