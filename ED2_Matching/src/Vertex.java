
import java.util.ArrayList;

public class Vertex {
    public char name;
    public boolean visited;
    public ArrayList<Link> linksToAdj = new ArrayList<>();

    public void addLink(Vertex vertex, int flow) {
        linksToAdj.add(new Link(vertex, flow));
    }

    Vertex(char name) {
        this.name = name;
    }
}
