package Neetcode.neetcode150;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

public class InsertIntoABST {

    static void main() {
        // Root level
        TreeNode root = new TreeNode(5);

// Level 1
        root.left = new TreeNode(3);
        root.right = new TreeNode(9);

// Level 2
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        System.out.println(insertIntoBST(root,6));
    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        if(val > root.val){
           root.right =  insertIntoBST(root.right,val);
        }else if(val < root.val){
            root.left = insertIntoBST(root.left,val);
        }else{
            return root;
        }
        return root;
    }
}
