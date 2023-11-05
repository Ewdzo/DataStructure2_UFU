import java.util.ArrayList;

public class Path {
    ArrayList<Link> route = new ArrayList<>();

    Path(ArrayList<Link> path) {
        this.route = path;
    }

    Path(Path path) {
        this.route = new ArrayList<Link>(path.route);
    }

    public void printPath(){
        String result = "Path: ";

        for(Link link : route) {
            result += link.destination.name;
        };

        System.out.print("\n" + result);
    }

}
