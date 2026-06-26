package Neetcode.neetcode150.trees;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

public class SameTree {
    void main() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(isSameTree(node,root));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return  true;

        if(p != null && q != null){
            if(p.val != q.val){
                return false;
            }
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}
