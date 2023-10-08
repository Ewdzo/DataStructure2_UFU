import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Vertex> vertexes = new ArrayList<>();

        Vertex A = new Vertex('A');
        Vertex B = new Vertex('B');
        Vertex C = new Vertex('C');
        Vertex D = new Vertex('D');
        Vertex E = new Vertex('E');
        Vertex F = new Vertex('F');

        A.addLink(B, 15);
        A.addLink(D, 12);

        B.addLink(C, 12);
        B.addLink(D, 10);
        B.addLink(E, 1);

        C.addLink(F, 25);

        D.addLink(E, 14);

        E.addLink(C, 10);
        E.addLink(F, 4);
    
        vertexes.add(A);
        vertexes.add(B);
        vertexes.add(C);
        vertexes.add(D);
        vertexes.add(E);
        vertexes.add(F);

        Link start = new Link(A, Integer.MAX_VALUE);
        Path emptyPath = new Path( new ArrayList<Link>());
        FordFulkerson fordFulkerson = new FordFulkerson();
        fordFulkerson.getAllPaths(start, F, emptyPath);
        fordFulkerson.paths.forEach(path -> path.printPath());
       
        fordFulkerson.getMaxFlow();
    }
}
