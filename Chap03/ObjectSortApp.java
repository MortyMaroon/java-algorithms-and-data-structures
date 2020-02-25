package Chap03;

public class ObjectSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayInOb array = new ArrayInOb(maxSize);

        array.insert("Evans","Patty",24);
        array.insert("Smith","Lorraine",37);
        array.insert("Yee","Tom",43);
        array.insert("Adams","Henry",63);
        array.insert("Hashimoto","Sato",21);
        array.insert("Stimson","Henry",29);
        array.insert("Velasquez","Jose",72);
        array.insert("Lamarque","Henry",54);
        array.insert("Vang","Minh",22);
        array.insert("Creswell","Lucinda",18);

        System.out.println("Before sorting:");
        array.display();
        array.insertSort();
        System.out.println("After sorting:");
        array.display();
    }
}
