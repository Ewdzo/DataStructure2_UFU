
import java.util.ArrayList;
import java.util.HashMap;

public class Vertex {
    public char name;
    public Vertex predecessor = this;
    public int distance = Integer.MAX_VALUE;

    public HashMap<Vertex, Integer> adjGraphs = new HashMap<>();
    public ArrayList<Vertex> shortestPath = new ArrayList<>();

    public void addAdjacentVertex(Vertex vertex, int distance) {
        adjGraphs.put(vertex, distance);
    }

    Vertex(char name){
        this.name = name;
    }

    Vertex(char name, int distance){
        this.name = name;
        this.distance = distance;
    }
}
