package Chap05;

public class Test {
    public static void main(String[] args) {
//        LinkListApp();
//        LinkList2App();
//        FirstListApp();
//        LinkStackApp();
        LinkQueueApp();
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
        theList.insertFirst(22, 0);
        theList.insertFirst(44, 0);
        theList.insertFirst(66, 0);
        theList.insertLast(11,0);
        theList.insertLast(33,0);
        theList.insertLast(55,0);
        theList.displayList();
        theList.deleteFirst();
        theList.deleteFirst();
        theList.displayList();
    }

    public static void LinkStackApp() {
        LinkStack theStack = new LinkStack();
        theStack.push(20,0);
        theStack.push(40,0);
        theStack.displayStack();
        theStack.push(60,0);
        theStack.push(80,0);
        theStack.displayStack();
        theStack.pop();
        theStack.pop();
        theStack.displayStack();
    }

    public static void LinkQueueApp() {
        LinkQueue theQueue = new LinkQueue();
        theQueue.insert(20,0);
        theQueue.insert(40,0);
        theQueue.displayQueue();
        theQueue.insert(60,0);
        theQueue.insert(80,0);
        theQueue.displayQueue();
        theQueue.remove();
        theQueue.remove();
        theQueue.displayQueue();
    }
}
