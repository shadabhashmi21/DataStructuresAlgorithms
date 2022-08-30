package tree;

import java.util.Stack;

public class BinaryTree {
    private TreeNode root;
    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private final int data;

        private TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
    }

    public void preOrderRecursive(TreeNode root){
        if (root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    public void preOrderIterative(TreeNode root){
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    public void inOrderRecursive(TreeNode root){
        if (root == null){
            return;
        }

        inOrderRecursive(root.left);
        System.out.print(root.data + " ");
        inOrderRecursive(root.right);
    }

    public void inOrderIterative(TreeNode root){
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null){
            if (temp != null){
                stack.push(temp);
                temp = temp.left;
            }else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    public void postOrderRecursive(TreeNode root){
        if (root == null){
            return;
        }

        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.data + " ");
    }

    public void postOrderIterative(TreeNode root){
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()){
            if (current != null){
                stack.push(current);
                current = current.left;
            }else {
                TreeNode temp = stack.peek().right;
                if (temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                }else {
                    current = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        //bt.preOrderRecursive(bt.root);
        //bt.preOrderIterative(bt.root);
        //bt.inOrderRecursive(bt.root);
        //bt.inOrderIterative(bt.root);
        //bt.postOrderRecursive(bt.root);
        bt.postOrderIterative(bt.root);
    }
}
