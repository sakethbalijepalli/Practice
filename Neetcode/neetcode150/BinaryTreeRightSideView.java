package Neetcode.neetcode150;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeRightSideView {

    static void main() {
        // Level 0
        TreeNode root = new TreeNode(1);

// Level 1: 2 is left, 3 is right
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

// Level 2: 2 has no left child, 4 is its right child.
// 3 has no left child, 5 is its right child.
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

//        System.out.println(rightSideView(root));
        System.out.println(rightSideViewUsingDFS(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
//        We want the right side view nodes only.
//        1          <-- Level 0
//      /   \
//     2     3       <-- Level 1
//    / \   / \
//   4  N  N   N     <-- Level 2
//  /
// 5                 <-- Level 3
//        In the above example we see 4 and 5 because 2 doesnt have any children or 4 doesnt have children or
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        if(root != null){
            treeNodeDeque.add(root);
        }
        while (!treeNodeDeque.isEmpty()){
            int len = treeNodeDeque.size();
            for (int i = 0;i < len;i++){
                TreeNode curr = treeNodeDeque.removeFirst();
                if(curr.left != null){
                    treeNodeDeque.add(curr.left);
                }
                if(curr.right != null){
                    treeNodeDeque.add(curr.right);
                }
                if(i == len - 1){
                resList.add(curr.val);
                }
            }
        }
        return resList;
    }

    public static List<Integer> rightSideViewUsingDFS(TreeNode root) {
//        We want the right side view nodes only.
//        1          <-- Level 0
//      /   \
//     2     3       <-- Level 1
//    / \   / \
//   4  N  N   N     <-- Level 2
//  /
// 5                 <-- Level 3
//        In the above example we see 4 and 5 because 2 doesnt have any children or 4 doesnt have children or
        List<Integer> resList = new ArrayList<>();
        dfs(root,0,resList);
        return resList;
    }

    private static void dfs(TreeNode node,int depth,List<Integer> res){
        if(node == null) return;
// InOrder - left root right
// Pre order - root left right
// Post order - right left root

        if (depth == res.size()) {
            res.add(node.val);
        }

        // Recursive calls: Explore Right first, then Left
        dfs(node.right, depth + 1, res);
        dfs(node.left, depth + 1, res);
    }
}
