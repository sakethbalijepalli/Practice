package Neetcode.neetcode150.trees;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

public class ValidBinarySearchTree {

    void main() {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);

        System.out.println(isValidBST(treeNode));
    }

//         4
//       /   \
//      3      6
//     /      / \
//    2      5   7
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean valid(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }

        if (!(left < node.val && node.val < right)) {
            return false;
        }
        return valid(node.left, left, node.val) &&
                valid(node.right, node.val, right);
    }
}
