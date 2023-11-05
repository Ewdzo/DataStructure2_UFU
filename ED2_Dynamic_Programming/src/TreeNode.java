public class TreeNode {
    public char name;
    public TreeNode left;
    public TreeNode right;

    TreeNode(char name, TreeNode left, TreeNode right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    TreeNode(char name, TreeNode left) {
        this.name = name;
        this.left = left;
        this.right = null;
    }

    TreeNode(char name) {
        this.name = name;
        this.left = null;
        this.right = null;
    }
}
