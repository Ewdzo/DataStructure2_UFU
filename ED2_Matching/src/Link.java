public class Link {
    public int flow;
    Vertex destination;

    Link(Vertex destination, int flow) {
        this.destination = destination;
        this.flow = flow;
    }
}
