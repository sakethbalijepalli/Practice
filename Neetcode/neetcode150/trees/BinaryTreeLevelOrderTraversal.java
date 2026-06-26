package Neetcode.neetcode150.trees;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    static void main() {
        TreeNode root = new TreeNode(4);

        // Level 2
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        // Level 3
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();

        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        if(root != null){
            treeNodeDeque.add(root);
        }

        while (!treeNodeDeque.isEmpty()){
            int len = treeNodeDeque.size();
            List<Integer> res = new ArrayList<>();
            for(int i = 0;i < len;i++){
                TreeNode curr = treeNodeDeque.removeFirst();
                res.add(curr.val);
                if(curr.left != null){
                    treeNodeDeque.add(curr.left);
                }
                if(curr.right != null){
                    treeNodeDeque.add(curr.right);
                }
            }
            resList.add(res);
        }
        return resList;
    }
}
