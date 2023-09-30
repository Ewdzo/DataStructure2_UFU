import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Vertex> vertexes = new ArrayList<>();
        Vertex A = new Vertex('A', 0);
        Vertex B = new Vertex('B');
        Vertex C = new Vertex('C');
        Vertex D = new Vertex('D');
        Vertex E = new Vertex('E');
        Vertex F = new Vertex('F');

        A.addAdjacentVertex(B, 2);
        A.addAdjacentVertex(C, 4);

        B.addAdjacentVertex(C, 3);
        B.addAdjacentVertex(D, 1);
        B.addAdjacentVertex(E, 5);

        C.addAdjacentVertex(D, 2);

        D.addAdjacentVertex(E, 1);
        D.addAdjacentVertex(F, 4);

        E.addAdjacentVertex(F, 2);

        vertexes.add(A);
        vertexes.add(B);
        vertexes.add(C);
        vertexes.add(D);
        vertexes.add(E);
        vertexes.add(F);

        Dijkstra.findShortestPath(vertexes, A, D).printPath();
    }
}
