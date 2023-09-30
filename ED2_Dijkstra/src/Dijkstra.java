import java.util.ArrayList;

public class Dijkstra {
    public static Path findShortestPath(ArrayList<Vertex> vertexes, Vertex Initial, Vertex Final) {
        Vertex current = Final;

        for(Vertex vertex : vertexes) {
            vertex.adjGraphs.forEach((key, value) -> {
                int distanceBetweenVertexes = vertex.adjGraphs.get(key);
                int finalDistance = (vertex.distance + distanceBetweenVertexes);
                
                if((vertex.distance + distanceBetweenVertexes) < key.distance){ 
                    key.predecessor = vertex;
                    key.distance = finalDistance;
                }
            });
        }

        for(Vertex vertex : vertexes) {
            System.out.println(vertex.name + ": " + vertex.predecessor.name + " - " + vertex.distance); 
        }

        Path finalPath = new Path(0, "");

        finalPath.path += current.name;

        while(current != Initial && current.distance < Integer.MAX_VALUE) {
            finalPath.distance += current.distance;
            current = current.predecessor;

            finalPath.path += current.name; 
        };

        return finalPath;
    }
}