
import java.util.ArrayList;

public class Vertex {
    public char name;
    public boolean visited;
    public boolean marked = false;
    public ArrayList<Link> linksToAdj = new ArrayList<>();

    public void addLink(Vertex vertex) {
        linksToAdj.add(new Link(vertex));
        vertex.linksToAdj.add(new Link(this));
    }

    Vertex(char name) {
        this.name = name;
    }
}
