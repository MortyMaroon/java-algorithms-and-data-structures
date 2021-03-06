package Chap02;

public class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray array = new HighArray(maxSize);
        array.insert(77);
        array.insert(99);
        array.insert(77);
        array.insert(44);

        array.insert(55);
        array.insert(22);
        array.insert(88);
        array.insert(11);
        array.insert(22);
        array.insert(66);
        array.insert(33);

        array.display();
        array.noDups();
        array.display();

        int searchKey = 35;
        if (array.find(searchKey)) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't found " + searchKey);
        }

        array.delete(00);
        array.delete(55);
        array.delete(99);
        array.display();

        long removeMax = array.removeMax();
        if (removeMax == -1) {
            System.out.println("Array is is empty");
        } else {
            System.out.println("Max element " + removeMax);
        }


        HighArray newArray = new HighArray(maxSize);
        for (int i = 0; i < maxSize; i++) {
            long max = array.removeMax();
            if (max == -1)
                break;
            newArray.insert(max);
        }
        newArray.display();

        array.display();
    }
}