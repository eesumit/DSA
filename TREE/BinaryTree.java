class BinaryTree{
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class BinaryTreeBuilder{
        static int index=-1;
        public static Node buildTree(int[] arr){
            index++;
            if(arr[index]==-1){
                return null;
            }
            Node newNode = new Node(arr[index]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);

            return newNode;
        } 
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,-1,-1,4,-1,-1,5,-1,6,-1,-1};
        BinaryTreeBuilder newTree = new BinaryTreeBuilder();
        Node root = newTree.buildTree(arr);
        System.out.println(root.data+"  "+"root.left.data="+root.left.data+"root.right.data="+root.right.data);
    }
}