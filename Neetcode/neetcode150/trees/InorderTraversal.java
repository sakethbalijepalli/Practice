package Neetcode.neetcode150.trees;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    private static List<Integer> res;

    static void main() {

        TreeNode root = new TreeNode(1);

        // Level 1
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // Level 2
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(inorderTraversal(root));;
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        inorder(root);
        return res;
    }

    private static void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        res.add(node.val);
        inorder(node.right);
    }
}
