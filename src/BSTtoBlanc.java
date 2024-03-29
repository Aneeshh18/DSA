import java.util.ArrayList;

public class BSTtoBlanc {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node( int data ) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preorder( Node root ) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void getInorder( Node root, ArrayList<Integer> inorder ) {
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST( ArrayList<Integer> inoder, int st, int end ) {

        if (st > end) {
            return null;
        }
        int mid = ( st + end ) / 2;
        Node root = new Node(inoder.get(mid));
        root.left = createBST(inoder, st, mid - 1);
        root.right = createBST(inoder, mid + 1, end);
        return root;
    }

    public static Node balancedBST( Node root ) {
        //inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        //sorted inorder -> balancebst
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;
    }

    //Q2-> BST with largest size


    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;
    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0 , Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size +1;
        int min = Math.min(root.data,
                (Math.min(leftInfo.min, rightInfo.min)));
        int max = Math.max(root.data,(Math.max(leftInfo.max, rightInfo.max)));

        if(leftInfo.max >= root.data || rightInfo.min <= root.data){
            return new Info(false, size, min , max);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min ,max);
    }
    public static void main( String[] args ) {
       /* //Q1
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        root= balancedBST(root);
        preorder(root);*/

        //Q2
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);


        Info info = largestBST(root);
        System.out.println("largest BST size =" + maxBST);
    }
}
