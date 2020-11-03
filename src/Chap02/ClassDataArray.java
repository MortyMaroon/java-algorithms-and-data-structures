package Chap02;

public class ClassDataArray {
    private Person[] array;
    private int nElements;

    public ClassDataArray(int maxSize) {
        this.array = new Person[maxSize];
        this.nElements = 0;
    }

    public Person find(String searchName) {
        int i;
        for (i = 0; i < nElements; i++) {
            if (array[i].getLast().equals(searchName)) {
                break;
            }
        }
        if (i == nElements) {
            return null;
        } else {
            return array[i];
        }
    }

    public void insert(String last, String first, int age) {
        array[nElements] = new Person(last,first,age);
        nElements++;
    }

    public boolean delete (String searchName) {
        int i;
        for (i = 0; i < nElements; i++) {
            if (array[i].getLast().equals(searchName)){
                break;
            }
        }
        if (i == nElements) {
            return false;
        } else {
            for (int j = i; j < nElements; j++) {
                array[j] = array[j + 1];
            }
            nElements--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < nElements; i++) {
            array[i].displayPerson();
        }
    }
}
