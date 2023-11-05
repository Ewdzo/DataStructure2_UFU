import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        //Linear Programming
        ArrayList<Vertex> vertexes = new ArrayList<>();

        Vertex A = new Vertex('A');
        Vertex B = new Vertex('B');
        Vertex C = new Vertex('C');
        Vertex D = new Vertex('D');
        Vertex E = new Vertex('E');
        Vertex F = new Vertex('F');
        Vertex G = new Vertex('G');
        Vertex H = new Vertex('H');
        Vertex I = new Vertex('I');
        Vertex J = new Vertex('J');
        Vertex K = new Vertex('K');
        Vertex L = new Vertex('L');

        A.addLink(B);   B.addLink(C);   C.addLink(D);   D.addLink(H);
        A.addLink(E);   B.addLink(F);   C.addLink(G);

        E.addLink(F);   F.addLink(G);   G.addLink(H);   H.addLink(L);
        E.addLink(I);   F.addLink(J);   G.addLink(K);

        I.addLink(J);   J.addLink(K);   K.addLink(L);
    
        vertexes.add(A);    vertexes.add(B);    vertexes.add(C);    vertexes.add(D);
        vertexes.add(E);    vertexes.add(F);    vertexes.add(G);    vertexes.add(H);
        vertexes.add(I);    vertexes.add(J);    vertexes.add(K);    vertexes.add(L);

        MaximumIndependentSet.greedyFind(vertexes);

        // Dynamic Programming

        TreeNode tH = new TreeNode('H');
        TreeNode tG = new TreeNode('G');
        TreeNode tF = new TreeNode('F');
        TreeNode tE = new TreeNode('E', tG, tH);
        TreeNode tD = new TreeNode('D');
        TreeNode tC = new TreeNode('C', tF);
        TreeNode tB = new TreeNode('B', tD, tE);
        TreeNode tA = new TreeNode('A', tB, tC);
        
        System.out.println("\nTamanho do CIM: " + MaximumIndependentSet.dynamicFind(tA));

    }
}
