package Chap13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private final int MAX_VERTS = 20;
    private  Vertex[] vertexList;
    private  Stack<Integer> theStack;
    private  Queue<Integer> theQueue;
    private int[][] adjMat;
    private int nVerts;
    private char sortedArray[];

    public Graph() {
        this.vertexList = new Vertex[MAX_VERTS];
        this.adjMat = new int[MAX_VERTS][MAX_VERTS];
        this.theStack = new Stack<>();
        this.theQueue = new LinkedList< >();
        this.nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        sortedArray = new char[MAX_VERTS];
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void addTopoEdge(int start, int end) {
        adjMat[start][end] = 1;
    }

    public void topo() {
        int orig_nVert = nVerts;
        while (nVerts > 0) {
            int currentVertex = noSuccessor();
            if (currentVertex == -1) {
                System.out.println("ERROR: Graph has cycles");
                return;
            }
            sortedArray[nVerts - 1] = vertexList[currentVertex].label;
            deleteVertex(currentVertex);
        }
        System.out.print("Topologically sorted order: ");
        for (int i = 0; i < orig_nVert; i++) {
            System.out.print(sortedArray[i]);
        }
        System.out.println();
    }

    private int noSuccessor() {
        boolean isEdge;
        for (int row = 0; row < nVerts; row++) {
            isEdge = false;
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0) {
                    isEdge = true;
                    break;
                }
            }
            if (!isEdge) {
                return row;
            }
        }
        return - 1;
    }

    private void deleteVertex(int delVert) {
        if (delVert != nVerts - 1) {
            for (int i = delVert; i < nVerts - 1; i++) {
                vertexList[i] = vertexList[i + 1];
            }
            for (int row = delVert; row < nVerts - 1; row++) {
                moveRowUp(row,nVerts - 1);
            }
            for (int col = delVert; col < nVerts - 1; col++) {
                moveColLeft(col,nVerts - 1);
            }
        }
        nVerts--;
    }

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }

    private int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i ++) {
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    public void mst() {
        vertexList[0].wasVisited = true;
        theStack.push(0);
        while (!theStack.isEmpty()) {
            int currentVertex = theStack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                theStack.push(v);
                displayVertex(currentVertex);
                displayVertex(v);
            }
        }
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void bfsmst() {
        vertexList[0].wasVisited = true;
        theQueue.add(0);
        while (!theQueue.isEmpty()) {
            int currentVertex = theQueue.peek();
            int v1 = currentVertex;
            int v2;
            while ((v2 = getAdjUnvisitedVertex(currentVertex)) != -1) {
                vertexList[v2].wasVisited = true;
                theQueue.add(v2);
                displayVertex(v1);
                displayVertex(v2);
                System.out.print(" ");
                v1 = v2;
            }
        }
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.add(0);
        int v2;
        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.add(v2);
            }
        }
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }
}