import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTShort {

    static class Node{
        int data;
        Node left, right;

       public Node(int data){
            this.data =data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int count(Node root) {
        if (root == null) {
            return 0;
        }

        int lcount = count(root.left);
        int rcount = count(root.right);
        return lcount + rcount + 1;
    }

    public static int Sum(Node root) {
        if (root == null) {
            return 0;
        }
        int lSum = Sum(root.left);
        int rSum = Sum(root.right);
        return lSum + rSum + root.data;
    }

    public static int diameter2(Node root) {  //O(n^2)
        if (root == null) {
            return 0;
        }
        int ldia = diameter2(root.left);
        int lh = height(root.left);
        int rdia = diameter2(root.right);
        int rh = height(root.right);
        int SelfDia = lh + rh + 1;
        return Math.max(SelfDia, Math.max(ldia, rdia));
    }

    static class info {
        int dia;
        int ht;

        public info (int dia, int ht){
            this.dia = dia;
            this.ht = ht;
        }
    }
    public static info diameter(Node root) {  //O(n^2)
        if(root == null){
            return new info(0,0 );
        }

        info leftinfo = diameter(root.left);
        info rightinfo = diameter(root.right);

        int dia = Math.max(Math.max(leftinfo.dia, rightinfo.dia), leftinfo.ht+ rightinfo.ht +1 );
        int ht = Math.max(leftinfo.ht, rightinfo.ht) +1 ;

        return new info(dia, ht);
    }

    public static boolean isIdentical(Node node, Node subRoot){
        if(node == null && subRoot == null){
            return true;
        } else if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root, Node subRoot){
        if(root == null) {
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot)|| isSubtree(root.right, subRoot);
    }


    static class Infos {
        Node node;
        int hd;
        public Infos( Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void TopView(Node root) {
        //level order
        Queue<Infos> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Infos(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Infos curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Infos(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Infos(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }
        for(int i = min ; i<= max; i++){
            System.out.print(map.get(i).data+ " ");
        }
    }



    public static void main(String [] args){

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subRoot = new Node(2);
        subRoot.left =new Node(4);
        subRoot.right = new Node(5);


       /* System.out.println(height(root));
        System.out.println(diameter(root).dia);*/

       /* System.out.println(isSubtree(root, subRoot));*/

        TopView(root);
    }
}
