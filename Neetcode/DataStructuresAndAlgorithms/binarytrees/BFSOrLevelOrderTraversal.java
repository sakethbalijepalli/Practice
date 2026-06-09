package Neetcode.DataStructuresAndAlgorithms.binarytrees;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BFSOrLevelOrderTraversal {
    static void main() {
        TreeNode root = new TreeNode(4);

        // Level 2
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        // Level 3
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        bfs(root);

    }

    public static void bfs(TreeNode node){
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();

        if(node != null){
            treeNodeDeque.offer(node);
        }

        int level = 0;
        while (!treeNodeDeque.isEmpty()){
            System.out.print("Level " + level + ": ");
            int len = treeNodeDeque.size();
            for(int i = 0;i < len;i++){
                TreeNode curr = treeNodeDeque.removeFirst();
                System.out.print(curr.val + " ");
                if(curr.left != null){
                    treeNodeDeque.add(curr.left);
                }
                if(curr.right != null){
                    treeNodeDeque.add(curr.right);
                }
            }
            level++;
            System.out.println();
        }
    }
}
