 private static void preordrerTraversal(Node root){
        if(root==null){
            System.out.print(-1+' ');
            return;
        }
        System.out.println(root.data+" ");
        preordrerTraversal(root.left);
        preordrerTraversal(root.right);
    }