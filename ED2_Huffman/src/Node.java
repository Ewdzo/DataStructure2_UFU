class Node implements Comparable<Node> {
   public char letter;
   public int frequency;
   public Node left, right;
   public int index;

   Node(char letter, int frequency, Node left, Node right) {
       this.letter = letter;
       this.frequency = frequency;
       this.left = left;
       this.right = right;
    }
    Node(char letter, int frequency, Node left, Node right, int index) {
        this(letter, frequency, left, right);
        this.index = index;
    }
    
    public boolean isLeaf() { 
        return left == null && right == null; 
    }

    public int compareTo(Node node) { 
        return this.frequency - node.frequency; 
    }
}