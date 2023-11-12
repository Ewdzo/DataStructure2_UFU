import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    private int V;
    private List<List<Integer>> graph;


    Graph(int vertices) {
        V = vertices;
        graph = new ArrayList<>();
    }

    void addEdge(int start, int end, int weight) {
        graph.add(Arrays.asList(start, end, weight));
    }

    private int find(List<Integer> parent, int i) {
        if (parent.get(i) == i) {
        return i;
        }
        return find(parent, parent.get(i));
    }

    private void unionSet(List<Integer> parent, List<Integer> rank, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);

        if (rank.get(xroot) < rank.get(yroot)) parent.set(xroot, yroot);
        else if (rank.get(xroot) > rank.get(yroot)) parent.set(yroot, xroot);
        else {
            parent.set(yroot, xroot);
            rank.set(xroot, rank.get(xroot) + 1);
        }
    }

    void boruvkaMST() {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();
        List<List<Integer> > cheapest = new ArrayList<>();
        int numTrees = V;
        int MSTweight = 0;

        for (int node = 0; node < V; node++) {
            parent.add(node);
            rank.add(0);
            cheapest.add(Arrays.asList(-1, -1, -1));
        }

        while (numTrees > 1) {
            for (List<Integer> edge : graph) {
                int u = edge.get(0), v = edge.get(1),
                w = edge.get(2);
                int set1 = find(parent, u),
                set2 = find(parent, v);

                if (set1 != set2) {
                    if (cheapest.get(set1).get(2) == -1 || cheapest.get(set1).get(2) > w) cheapest.set(set1, Arrays.asList(u, v, w));
                    if (cheapest.get(set2).get(2) == -1 || cheapest.get(set2).get(2) > w) cheapest.set(set2, Arrays.asList(u, v, w));
                }
            }

            for (int node = 0; node < V; node++) {
                if (cheapest.get(node).get(2) != -1) {
                    int u = cheapest.get(node).get(0),
                    v = cheapest.get(node).get(1),
                    w = cheapest.get(node).get(2);
                    int set1 = find(parent, u),
                    set2 = find(parent, v);

                    if (set1 != set2) {
                        MSTweight += w;
                        unionSet(parent, rank, set1, set2);
                        System.out.printf( "Edge %d-%d with weight %d included in MST\n", u, v, w);
                        numTrees--;
                    }
                }
            }

            for (List<Integer> list : cheapest) { list.set(2, -1); }
        }

        System.out.printf("Weight of MST is %d\n", MSTweight);
    }
}