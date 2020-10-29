package Chap13;

import java.util.LinkedList;

public class test {

    public static void main(String[] args) {
//        BFSApp();
//        DFSApp();
//        MSTApp();
//        TopoApp();
//        BFSMSTApp();
        DFSListApp();
    }

    public static void MSTApp() {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addEdge(0,1);
        theGraph.addEdge(0,2);
        theGraph.addEdge(0,3);
        theGraph.addEdge(0,4);
        theGraph.addEdge(1,2);
        theGraph.addEdge(1,3);
        theGraph.addEdge(1,4);
        theGraph.addEdge(2,3);
        theGraph.addEdge(2,4);
        theGraph.addEdge(3,4);
        System.out.print("Minimum spanning tree: ");
        theGraph.mst();
        System.out.println();
    }

    public static void DFSApp() {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addEdge(0,1);
        theGraph.addEdge(1,2);
        theGraph.addEdge(0,3);
        theGraph.addEdge(3,4);
        System.out.print("Visits: ");
        theGraph.dfs();
        System.out.println();
    }

    public static void BFSApp() {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addEdge(0,1);
        theGraph.addEdge(1,2);
        theGraph.addEdge(0,3);
        theGraph.addEdge(3,4);
        System.out.print("Visits: ");
        theGraph.bfs();
        System.out.println();
    }

    public static void TopoApp() {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');
        theGraph.addVertex('G');
        theGraph.addVertex('H');
        theGraph.addTopoEdge(0,3);
        theGraph.addTopoEdge(0,4);
        theGraph.addTopoEdge(1,4);
        theGraph.addTopoEdge(2,5);
        theGraph.addTopoEdge(3,6);
        theGraph.addTopoEdge(4,6);
        theGraph.addTopoEdge(5,7);
        theGraph.addTopoEdge(6,7);
        theGraph.topo();
    }

    public static void BFSMSTApp() {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');
        theGraph.addVertex('G');
        theGraph.addVertex('H');
        theGraph.addVertex('I');
        theGraph.addEdge(0,1);
        theGraph.addEdge(0,2);
        theGraph.addEdge(0,3);
        theGraph.addEdge(1,5);
        theGraph.addEdge(1,6);
        theGraph.addEdge(2,7);
        theGraph.addEdge(3,4);
        theGraph.addEdge(3,7);
        theGraph.addEdge(4,5);
        theGraph.addEdge(5,8);
        theGraph.addEdge(6,8);
        theGraph.addEdge(7,8);
        System.out.print("Minimum spanning tree: ");
        theGraph.bfsmst();
        System.out.println();
    }

    public static void DFSListApp() {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addEdgIbList(0,1);
        theGraph.addEdgIbList(1,2);
        theGraph.addEdgIbList(0,3);
        theGraph.addEdgIbList(3,4);
        System.out.print("Visits: ");
        theGraph.dfsList();
        System.out.println();
    }
}
