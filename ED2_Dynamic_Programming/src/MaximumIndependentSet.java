import java.util.ArrayList;

public class MaximumIndependentSet {
    
    public static void greedyFind(ArrayList<Vertex> vertexes) {
        ArrayList<Vertex> MaximumIndependentSet = new ArrayList<>();

        for (Vertex vertex : vertexes) {
            ArrayList<Vertex> independentSet = new ArrayList<>();
            greedyFindHelper(vertex);

            for (Vertex visitedVertex : vertexes) {
                if(visitedVertex.marked) independentSet.add(visitedVertex);

                visitedVertex.visited = false;
                visitedVertex.marked = false;
            }

            if (independentSet.size() > MaximumIndependentSet.size()) MaximumIndependentSet = independentSet;
        }

        for (Vertex vertex : MaximumIndependentSet) {
            System.out.print(vertex.name + " - ");
        }
    }

    public static void greedyFindHelper(Vertex vertex) {
        vertex.visited = true;
        vertex.marked = true;
        
        for (Link link : vertex.linksToAdj) { 
           Vertex nextVertex = link.destination;
           
           if(nextVertex.marked) vertex.marked = false;
           if(!nextVertex.visited) greedyFindHelper(nextVertex);
        }
    }

    public static int dynamicFind(TreeNode root) {
        if (root == null) return 0;
 
        // Calculate size excluding the current node
        int size_excl = dynamicFind(root.left) + dynamicFind(root.right);
 
        // Calculate size including the current node
        int size_incl = 1;
        if(root.left != null) {
            int size = dynamicFind(root.left.left) + dynamicFind(root.left.right);
            size_incl += size;  
        } 

        if (root.right != null){
            int size = dynamicFind(root.right.left) + dynamicFind(root.right.right);
            size_incl += size;
        }
 
        // Return the maximum of two sizes
        return Math.max(size_incl, size_excl);
    };

}
