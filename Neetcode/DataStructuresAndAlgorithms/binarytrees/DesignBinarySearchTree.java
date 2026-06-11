package Neetcode.DataStructuresAndAlgorithms.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class DesignBinarySearchTree {
    TreeNodes root;
    void main() {
        DesignBinarySearchTree designBinarySearchTree = new DesignBinarySearchTree();
        designBinarySearchTree.insert(1,2);
        designBinarySearchTree.insert(4,2);
        designBinarySearchTree.insert(3,7);
        designBinarySearchTree.insert(2,1);
        System.out.println(designBinarySearchTree.getInorderKeys());
        designBinarySearchTree.remove(1);
        System.out.println(designBinarySearchTree.getInorderKeys());
    }

    public DesignBinarySearchTree() {
        root = null;
    }

    public void insert(int key, int val) {
        TreeNodes newNode = new TreeNodes(key,val);
        if(root == null){
            root = newNode;
            return;
        }

        TreeNodes curr = root;
        while (true){
            if(key < curr.key){
                if(curr.left == null){
                    curr.left = newNode;
                    return;
                }
                curr = curr.left;
            }
            else if(key > curr.key){
                if(curr.right == null){
                    curr.right = newNode;
                    return;
                }
                curr = curr.right;
            }else{
                curr.val = val;
                return;
            }
        }
    }

    public int get(int key) {
        TreeNodes curr = root;
        while (curr != null){
            if(key < curr.key){
                curr = curr.left;
            }else if(key > curr.key){
                curr = curr.right;
            }else{
                return curr.val;
            }
        }
        return -1;
    }

    public int getMin() {
        TreeNodes current = findMin(this.root);
        return (current != null) ? current.val : -1;
    }

    private TreeNodes findMin(TreeNodes node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int getMax() {
        TreeNodes curr = findMax(this.root);
        return (curr != null) ? curr.val : -1;
    }

    private TreeNodes findMax(TreeNodes node) {
        while (node != null && node.right != null) {
            node = node.right;
        }
        return node;
    }

    public void remove(int key) {
        TreeNodes curr = root;
        TreeNodes parent = null;

        while (curr != null && curr.key != key){
            parent = curr;
            if(key < curr.key){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        if(curr == null) return;

        if (curr.left == null || curr.right == null) {
            // 1. Find out who the surviving child is (it might be a node, or it might be null if it's a leaf)
            TreeNodes child = (curr.left != null) ? curr.left : curr.right;

            // 2. Handle the root edgecase
            if (parent == null) {
                root = child;
            } else {
                // 3. Figure out if 'curr' was the left or right child of 'parent',
                // and link 'parent' directly to 'child'
                if(parent.left == curr){
                    parent.left = child;
                } else if (parent.right == curr) {
                    parent.right = child;
                }
            }
        }
// Case 3: Node with TWO children
        else {
            // Track the parent of the successor
            TreeNodes successorParent = curr;
            TreeNodes successor = curr.right;

            // Slide all the way to the left to find the absolute minimum
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // 1. Copy the successor's key to the current node
            curr.key = successor.key;

            // 2. Disconnect the successor from its parent
            // If we never moved left, successor is still curr.right
            if (successorParent == curr) {
                successorParent.right = successor.right;
            } else {
                // If we moved left, successor is a left child
                successorParent.left = successor.right;
            }
        }
    }



    public List<Integer> getInorderKeys() {
        List<Integer> keyList = new ArrayList<>();
        inOrder(root,keyList);
        return keyList;
    }

    private void inOrder(TreeNodes root, List<Integer> keyList){
        if(root == null) return;
        inOrder(root.left,keyList);
        if(root.key != 0){
            keyList.add(root.key);
        }
        inOrder(root.right,keyList);
    }

    static class TreeNodes {
        int key;
        int val;
        TreeNodes left;
        TreeNodes right;

        public TreeNodes(int key, int val) {
            this.key = key;
            this.val = val;
        }
        @Override
        public String toString() {
            return "TreeNodes{" +
                    "key=" + key +
                    ", val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}

