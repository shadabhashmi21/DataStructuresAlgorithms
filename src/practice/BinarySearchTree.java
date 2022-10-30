package practice;

public class BinarySearchTree {
    private TreeNode root;
    private static class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private final int data;

        private TreeNode(int data) {
            this.data = data;
        }
    }

    public void insert(int value){
        root = insert(root, value);
    }

    public TreeNode insert(TreeNode root, int value) {
        if (root == null){
            root = new TreeNode(value);
            return root;
        }

        if (value < root.data)
            root = insert(root.left, value);
        else
            root = insert(root.right, value);

        return root;
    }

    public void inOrder(TreeNode root){
        if (root == null) return;

        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
    }

    public void search(int key){
        root = search(root, key);
    }

    public TreeNode search(TreeNode root, int key){
        if (root == null || root.data == key) return root;

        if (key < root.data)
            root = search(root.left, key);
        else
            root = search(root.right, key);

        return root;
    }
}
