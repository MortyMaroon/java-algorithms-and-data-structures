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
}
