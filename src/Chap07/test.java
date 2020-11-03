package Chap07;

public class test {
    public static void main(String[] args) {
//        ShellSorted();
//        PartitionApp();
//        QuickSortApp();
        QuickSortApp2();
    }

    public static void ShellSorted(){
        int maxSize = 10;
        ArraySh arr = new ArraySh(maxSize);
        for (int i = 0; i < maxSize; i++) {
            long n = (int) (Math.random() * 99);
            arr.insert(n);
        }
        arr.display();
        arr.shellSort();
        arr.display();
    }

    public static void PartitionApp(){
        int maxSize = 16;
        ArrayPar arr = new ArrayPar(maxSize);
        for (int i = 0; i < maxSize; i++) {
            long n = (int) (Math.random() * 199);
            arr.insert(n);
        }
        arr.display();
        long pivot = 99;
        System.out.print("Pivot is " + pivot);
        int size = arr.size();
        int partDex = arr.partitionIt(0, size - 1, pivot);
        System.out.println (", Partition is at index " + partDex);
        arr.display();
    }

    public static void QuickSortApp(){
        int maxSize = 16;
        ArrayIns arr = new ArrayIns(maxSize);
        for (int i = 0; i < maxSize; i++) {
            long n = (int) (Math.random() * 99);
            arr.insert(n);
        }
        arr.display();
        arr.quickSort();
        arr.display();
    }

    public static void QuickSortApp2(){
        int maxSize = 16;
        ArrayIns2 arr = new ArrayIns2(maxSize);
        for (int i = 0; i < maxSize; i++) {
            long n = (int) (Math.random() * 99);
            arr.insert(n);
        }
        arr.display();
        arr.quickSort();
        arr.display();
    }
}