package Chap14;

public class Graph {
    private final int MAX_VERTEX = 20;
    private final int INFINITY = 1000000;
    private Vertex vertexList[];
    private int adjMAt[][];
    private int nVerts;
    private int currentVert;
    private PriorityQ thePQ;
    private int nTree;

    public Graph() {
        this.vertexList = new Vertex[MAX_VERTEX];
        this.adjMAt = new int[MAX_VERTEX][MAX_VERTEX];
        this.nVerts = 0;
        for (int i = 0; i < MAX_VERTEX; i++) {
            for (int j = 0; j < MAX_VERTEX; j++) {
                adjMAt[i][j] = INFINITY;
            }
        }
        this.thePQ = new PriorityQ();
    }

    public void addVert(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end, int weight) {
        adjMAt[start][end] = weight;
        adjMAt[end][start] = weight;
    }

    public void displayVert(int v) {
        System.out.print(vertexList[v].label);
    }

    public void mstw() {
        currentVert = 0;
        while (nTree < nVerts - 1) {
            vertexList[currentVert].isInTree = true;
            nTree++;
            for (int i = 0; i < nVerts; i++) {
                if (i == currentVert) {
                    continue;
                }
                if (vertexList[i].isInTree) {
                    continue;
                }
                int distance = adjMAt[currentVert][i];
                if (distance == INFINITY) {
                    continue;
                }
                putInPQ(i, distance);
            }
            if (thePQ.size() == 0) {
                System.out.println(" Graph not connected");
                return;
            }
            Edge theEdge = thePQ.removeMin();
            int sourceVert = theEdge.srcVert;
            currentVert = theEdge.destVert;
            System.out.print(vertexList[sourceVert].label);
            System.out.print(vertexList[currentVert].label);
            System.out.print(" ");
        }
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].isInTree = false;
        }
    }

    public void putInPQ(int newVert, int newDist) {
        int queueIndex = thePQ.find(newVert);
        if (queueIndex != -1) {
            Edge tempEdge = thePQ.peekN(queueIndex);
            int oldIDist = tempEdge.distance;
            if (oldIDist > newDist) {
                thePQ.removeN(queueIndex);
                Edge theEdge = new Edge(currentVert,newVert,newDist);
                thePQ.insert(theEdge);
            }
        } else {
            Edge theEdge = new Edge(currentVert, newVert, newDist);
            thePQ.insert(theEdge);
        }
    }
}
