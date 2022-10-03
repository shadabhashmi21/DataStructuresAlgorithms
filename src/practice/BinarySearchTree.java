package practice;

public class BinarySearchTree {
    private TreeNode root;

    private static class TreeNode{
        private final int data;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(int data) {
            this.data = data;
        }
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    public TreeNode insert(TreeNode root, int value) {
        if (root == null){
            root = new TreeNode(value);
            return root;
        }

        if (value < root.data)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    public void inOrder(TreeNode root){
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public TreeNode search(int key){
        return search(root, key);
    }

    public TreeNode search(TreeNode root, int key){
        if (root == null  || root.data == key)
            return root;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }
}
