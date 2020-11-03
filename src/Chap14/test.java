package Chap14;

public class test {

    public static void main(String[] args) {
        MSTWApp();
    }

    public static void MSTWApp() {
        Graph theGraph = new Graph();
        theGraph.addVert('A');
        theGraph.addVert('B');
        theGraph.addVert('C');
        theGraph.addVert('D');
        theGraph.addVert('E');
        theGraph.addVert('F');
        theGraph.addEdge(0,1,6);
        theGraph.addEdge(0,3,4);
        theGraph.addEdge(1,2,10);
        theGraph.addEdge(1,3,7);
        theGraph.addEdge(1,4,7);
        theGraph.addEdge(2,3,8);
        theGraph.addEdge(2,4,5);
        theGraph.addEdge(2,5,6);
        theGraph.addEdge(3,4,12);
        theGraph.addEdge(4,5,7);
        System.out.print("Minimum spanning tree: ");
        theGraph.mstw();
        System.out.println();
    }
}
