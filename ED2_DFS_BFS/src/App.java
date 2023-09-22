import java.util.Iterator;
import java.util.LinkedList;

class Graph {
	public int qtd;

	public LinkedList<Integer> adj[];

	Graph(int qtd) {
        this.qtd = qtd;
		adj = new LinkedList[qtd];
        
		for (int i = 0; i < qtd; ++i) {
			adj[i] = new LinkedList();
        }
	}

	void addEdge(int graph, int graph2) {
		adj[graph].add(graph2);
	}

	void DFSUtil(int graph, boolean visited[]) {
		visited[graph] = true;
		System.out.print(graph + " ");

		Iterator<Integer> i = adj[graph].listIterator();

		while (i.hasNext()) {
			int next = i.next();
			if (!visited[next]) {
				DFSUtil(next, visited);
            }
		}
	}

	void DFS(int graph) {
		boolean visited[] = new boolean[qtd];
		DFSUtil(graph, visited);
	}

    void BFS(int graph) {
        boolean visited[] = new boolean[qtd];
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        visited[graph] = true;
        queue.add(graph);
 
        while (queue.size() != 0) {
            graph = queue.poll();
            System.out.print(graph + " ");

            Iterator<Integer> i = adj[graph].listIterator(); 
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

	public static void main(String args[]) {
		Graph graphs = new Graph(4);

		graphs.addEdge(0, 1);
		graphs.addEdge(0, 2);
		graphs.addEdge(1, 2);
		graphs.addEdge(2, 0);
		graphs.addEdge(2, 3);
		graphs.addEdge(3, 3);

		System.out.print( "DFS: ");
		graphs.DFS(2);
        System.out.println("");

        System.out.print( "BFS: ");
        graphs.BFS(2);
	}
}
