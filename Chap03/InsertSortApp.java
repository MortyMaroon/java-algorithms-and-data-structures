package Chap03;

public class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayIns array = new ArrayIns(maxSize);

//        array.insert(77);
//        array.insert(99);
//        array.insert(44);
//        array.insert(55);
//        array.insert(22);
//        array.insert(88);
//        array.insert(11);
//        array.insert(00);
//        array.insert(66);
//        array.insert(33);

        array.insert(77);
        array.insert(77);
        array.insert(22);
        array.insert(11);
        array.insert(11);
        array.insert(99);
        array.insert(44);
        array.insert(88);
        array.insert(55);
        array.insert(55);

        array.display();
        array.insertSortWithDups();
        array.display();
    }

}
