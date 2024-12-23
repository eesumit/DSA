class BinarySearchTree{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    private static Node insertInBinarySearchTree(Node root,int data){
        if(root==null) return new Node(data);
        else if(root.data>data) root.left = insertInBinarySearchTree(root.left,data);
        else root.right = insertInBinarySearchTree(root.right, data);
        return root;
    }
    private static void inorderPrint(Node root){
        if(root==null) return;
        inorderPrint(root.left);
        System.out.println(root.data);
        inorderPrint(root.right);
    }
    private static boolean searchInBinaryTree(Node root, int key) {
        if (root == null) return false; // If root is null, key is not present
        if (root.data == key) return true; // Key found
        if (key < root.data) return searchInBinaryTree(root.left, key); // Key may be in the left subtree
        return searchInBinaryTree(root.right, key); // Key may be in the right subtree
    }
    
    public static void main(String[] args) {
        int []arr = {5,1,3,4,2,7};
        Node root = null;
        for(int i:arr) root = insertInBinarySearchTree(root, i);
        inorderPrint(root);
        boolean kyaMila = searchInBinaryTree(root, 7);
        System.out.println(kyaMila);
        kyaMila = searchInBinaryTree(root, 8);
        System.out.println(kyaMila);
        kyaMila = searchInBinaryTree(root, 1);
        System.out.println(kyaMila);
        

    }
}