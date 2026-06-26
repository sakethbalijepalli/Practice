package Neetcode.neetcode150.trees;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxDepthOfATree {
    static void main() {
        // Root Level
        TreeNode root = new TreeNode(1);

// Level 1: 2 is the left child, 3 is the right child
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

// Level 2:
// 2's children are null, so we skip them.
// 3's left child is 4, 3's right child is null.
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        System.out.println(maxDepth(root));
        System.out.println(maxDepthDfs(root));
    }

    public static int maxDepth(TreeNode root) {
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        if(root != null){
            treeNodeDeque.add(root);
        }
        int count = 0;
        while (!treeNodeDeque.isEmpty()){
            int length = treeNodeDeque.size();
            for(int i = 0;i < length;i++){
                TreeNode node = treeNodeDeque.removeFirst();
                if(node.left != null){
                    treeNodeDeque.add(node.left);
                }
                if(node.right != null){
                    treeNodeDeque.add(node.right);
                }
            }
            count++;
        }
        return count;
    }

    public static int maxDepthDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepthDfs(root.left), maxDepthDfs(root.right));
    }
}
