package Neetcode.neetcode150.trees;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

public class DeleteFromABST {

    static void main() {
        // Root level
        TreeNode root = new TreeNode(5);

// Level 1
        root.left = new TreeNode(3);
        root.right = new TreeNode(9);

// Level 2
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        System.out.println(deleteNode(root,3));
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        if(key > root.val){
            root.right = deleteNode(root.right,key);
        }else if(key < root.val){
            root.left = deleteNode(root.left,key);
        }else{
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = minValueNode(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }

    public static TreeNode minValueNode(TreeNode node){
        TreeNode curr = node;
        while (curr != null && curr.left != null){
            curr = curr.left;
        }
        return curr;
    }
}
