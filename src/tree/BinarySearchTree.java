package tree;

public class BinarySearchTree {
    private TreeNode root;

    private static class TreeNode{
        private final int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }
}
