import java.util.ArrayList;
import java.util.List;

class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    private static Node insertInBinarySearchTree(Node root, int data) {
        if (root == null)
            return new Node(data);
        else if (root.data > data)
            root.left = insertInBinarySearchTree(root.left, data);
        else
            root.right = insertInBinarySearchTree(root.right, data);
        return root;
    }

    private static void inorderPrint(Node root) {
        if (root == null)
            return;
        inorderPrint(root.left);
        System.out.print(root.data+" ");
        inorderPrint(root.right);
    }

    private static boolean searchInBinaryTree(Node root, int key) {
        if (root == null)
            return false; // If root is null, key is not present
        if (root.data == key)
            return true; // Key found
        if (key < root.data)
            return searchInBinaryTree(root.left, key); // Key may be in the left subtree
        return searchInBinaryTree(root.right, key); // Key may be in the right subtree
    }

    private static Node deleteNode(Node root,int key){
        if(root==null) return null;
        else if(root.data<key) root.right = deleteNode(root.right, key);
        else if(root.data>key) root.left = deleteNode(root.left, key);
        else {
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            Node successor = findSuccessor(root);
            root.data = successor.data;
            root.right = deleteNode(root.right, successor.data);
        }
        return root;
    }
    private static Node findSuccessor(Node root){
        while(root.left!=null) root=root.left;
        return root;
    }
    private static void printPath(ArrayList<Integer> path){
        System.out.println();
        for(int i:path) 
        if(i==path.get(path.size()-1)) System.out.print(i);
        else System.out.print(i+"->");
    }
    // printing every path in the binary search tree.
    private static void printAllPaths(Node root,ArrayList<Integer>path){
        if(root==null) return;
        path.add(root.data);
        if(root.left==null && root.right==null){
            printPath(path);
        }
        else{
        printAllPaths(root.left, path);
        printAllPaths(root.right, path);
        }
        path.remove(path.size()-1);
        
    }
    public static void main(String[] args) {
        int[] arr = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for (int i : arr)
            root = insertInBinarySearchTree(root, i);
        inorderPrint(root);
        boolean kyaMila = searchInBinaryTree(root, 7);
        System.out.println(kyaMila);
        kyaMila = searchInBinaryTree(root, 8);
        System.out.println(kyaMila);
        kyaMila = searchInBinaryTree(root, 1);
        System.out.println(kyaMila);
        // root = deleteNode(root, 4);
        // root = deleteNode(root, 10);
        // root = deleteNode(root, 5);
        inorderPrint(root);
        printAllPaths(root, new ArrayList<>());
    }
}