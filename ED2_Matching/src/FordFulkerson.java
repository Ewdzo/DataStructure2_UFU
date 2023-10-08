import java.util.ArrayList;
import java.util.Collections;

public class FordFulkerson {
    public ArrayList<Path> paths = new ArrayList<>();

    public void getMaxFlow() {
        Collections.sort(paths);
        int maxFlow = 0;

        for(Path path : paths) {
            path.updateFlow();
            maxFlow += path.flow;
            for(Link link : path.route) {
                link.flow -= path.flow; 
            }
        }

        System.out.println("\n\nMax Flow: " + maxFlow);
    }

    public void getAllPaths(Link link, Vertex end, Path path) {
        Vertex current = link.destination;
        if(current.equals(end)) {
            path.route.add(link);
            if(path.flow > link.flow) path.flow = link.flow;
            
            paths.add(new Path(path));
            path.route.remove(link);
            return;
        };

        int aux = path.flow;
        if(path.flow > link.flow) path.flow = link.flow;
        current.visited = true;

        current.linksToAdj.forEach(linkToAdj -> {
            path.route.add(link);
            getAllPaths(linkToAdj, end, path);

            path.route.remove(link);
        });
        current.visited = false;
        path.flow = aux;
    }
}
