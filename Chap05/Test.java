package Chap05;

public class Test {
    public static void main(String[] args) {
//        LinkListApp();
//        LinkList2App();
        FirstListApp();
    }

    public static void LinkListApp() {
        LinkList theList = new LinkList();
        theList.insertFirst(22,2.99);
        theList.insertFirst(44,4.99);
        theList.insertFirst(66,6.99);
        theList.insertFirst(88,8.99);

        theList.displayList();

        while (!theList.isEmpty()) {
            Link aLink = theList.deleteFirst();
            System.out.print("deleted ");
            aLink.displayLink();
            System.out.println();
        }
        theList.displayList();
    }

    public static void LinkList2App() {
        LinkList theList = new LinkList();
        theList.insertFirst(22,2.99);
        theList.insertFirst(44,4.99);
        theList.insertFirst(66,6.99);
        theList.insertFirst(88,8.99);

        theList.displayList();

        Link f = theList.find(44);
        if (f != null) {
            System.out.println("Found link with key " + f.iData);
        } else {
            System.out.println("Can't find link");
        }
        Link d = theList.delete(66);
        if (f != null) {
            System.out.println("Deleted link with key " + d.iData);
        } else {
            System.out.println("Can't deleted link");
        }
        theList.displayList();
    }

    public static void FirstListApp() {
        FirstLastList theList = new FirstLastList();
        theList.insertFirst(22, 00);
        theList.insertFirst(44, 00);
        theList.insertFirst(66, 00);
        theList.insertLast(11,00);
        theList.insertLast(33,00);
        theList.insertLast(55,00);
        theList.displayList();
        theList.deleteFirst();
        theList.deleteFirst();
        theList.displayList();
    }
}
