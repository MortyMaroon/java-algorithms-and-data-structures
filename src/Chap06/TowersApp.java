package Chap06;

public class TowersApp {
    static int nDisks = 3;

    public static void main(String[] args) {
        doTower(nDisks,'A','B','C');
    }

    public static void doTower(int topN,char from,char inter,char to) {
        if (topN == 1) {
            System.out.println("Disc 1 from " + from + " to " + to);
        } else {
            doTower(topN - 1, from, to, inter);
            System.out.println("Disc " + topN + " from " + from + " to " + to);
            doTower(topN - 1, inter , from , to);
        }
    }
}
