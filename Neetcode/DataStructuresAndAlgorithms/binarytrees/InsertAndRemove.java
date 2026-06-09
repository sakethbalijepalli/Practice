package Neetcode.DataStructuresAndAlgorithms.binarytrees;

public class InsertAndRemove {

    public TreeNode insert(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }

        if(val > root.val){
            root.right =  insert(root.right,val);
        }else if(val < root.val){
            root.left = insert(root.left,val);
        }else{
            return root;
        }
        return root;
    }
}
