package practice;

public class BinarySearchTree {
    private TreeNode root;

    private static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private final int data;

        private TreeNode(int data) {
            this.data = data;
        }
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

    public void insert(int value){
        root = insert(root, value);
    }

    public void inOrder(TreeNode root){
        if (root == null) return;

        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
    }

    public TreeNode search(TreeNode root, int key){
        if (root == null || root.data == key)
            return root;

        if(key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    public TreeNode search(int key){
        return search(root, key);
    }
}
