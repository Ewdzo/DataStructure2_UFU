import java.util.ArrayList;

public class Path implements Comparable<Path> {
    Integer flow = Integer.MAX_VALUE;
    ArrayList<Link> route = new ArrayList<>();

    Path(ArrayList<Link> path) {
        this.route = path;
    }

    Path(Path path) {
        this.flow = path.flow;
        this.route = new ArrayList<Link>(path.route);
    }

    public void printPath(){
        String result = "Path: ";

        for(Link link : route) {
            result += link.destination.name;
        };

        result += " - Flow: " + flow;
        System.out.print("\n" + result);
    }

    public int compareTo(Path p){
        if (this.flow > p.flow) {
            return -1;
        }
        else if (this.flow < p.flow) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public void updateFlow() {
        Integer newFlow = Integer.MAX_VALUE;

        for( Link link : route ) {
            if(link.flow < newFlow) newFlow = link.flow;
        }

        this.flow = newFlow;
    }
}
