package Neetcode.neetcode150.trees;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

import java.util.HashMap;

public class BuildBinaryTreeUsingPreAndInOrder {
    static void main() {
        System.out.println(buildTree(new int[]{1,2,3,4},new int[]{2,1,3,4}));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inOrderMap = new HashMap<>();
        for(int i = 0;i < inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1,inOrderMap);
    }

    private static TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd,HashMap<Integer,Integer> inOrderMap) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode node = new TreeNode(preorder[preStart]);

        int rootIndex = inOrderMap.get(node.val);
        int leftSubtreeSize = rootIndex - inStart;
        node.left = build(preorder,preStart + 1, preStart + leftSubtreeSize,inorder,
                inStart, rootIndex - 1,inOrderMap);

        node.right = build(preorder,preStart + leftSubtreeSize + 1, preEnd,inorder,
                rootIndex + 1, inEnd,inOrderMap);
        return node;
    }
}
