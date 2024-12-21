import java.util.LinkedList;
import java.util.Queue;

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

        public static void preordrerTraversal(Node root){
            if(root==null){
                System.out.print(-1+" ");
                return;
            }
            System.out.print(root.data+" ");
            preordrerTraversal(root.left);
            preordrerTraversal(root.right);
        }

        public static void levelorderTrsversal(Node root){
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currentNode = q.remove();
                if(currentNode==null){
                    System.out.println();
                    if(q.isEmpty()) break;
                    else q.add(null);
                }else{
                    System.out.println(currentNode.data);
                    if(currentNode.left!=null) q.add(currentNode.left);
                    if(currentNode.right!=null) q.add(currentNode.right);
                }
            }
        }
    }
     
        public static void main(String[] args) {
        int[] arr = {1,2,3,-1,-1,4,-1,-1,5,-1,6,-1,-1};
        BinaryTreeBuilder newTree = new BinaryTreeBuilder();
        Node root = newTree.buildTree(arr);
        System.out.println(root.data+"  "+"root.left.data="+root.left.data+"root.right.data="+root.right.data);
        newTree.preordrerTraversal(root);
        newTree.levelorderTrsversal(root);

    }
}