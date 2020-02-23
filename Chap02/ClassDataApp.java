package Chap02;

public class ClassDataApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ClassDataArray array = new ClassDataArray(maxSize);
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
        array.display();
        String searchKey = "Stimson";
        Person found = array.find(searchKey);
        if (found != null) {
            System.out.print("Found ");
            found.displayPerson();
        } else {
            System.out.println("Can't find " + searchKey);
        }
        System.out.println("Deleting Smith, Yee, and Creswell");
        array.delete("Smith");
        array.delete("Yee");
        array.delete("Creswell");
        array.display();
    }
}