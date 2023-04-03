import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinaryTKlvl {

    static class Node{
        int data;
        BinaryTKlvl.Node left, right;

        public Node(int data){
            this.data =data;
            this.left = null;
            this.right = null;
        }
    }

    public static void KLevel(Node root, int level, int K){
        if(root == null){
            return;
        }
        if(level == K){
            System.out.print(root.data + " ");
            return;
        }
        KLevel(root.left, level +1, K);
        KLevel(root.right, level +1, K);
    }


    public static boolean getpath(Node root, int n, ArrayList<Node> path){
        if (root == null) {
            return false;
        }

        path.add(root);

        if(root.data == n){
            return true;
        }

        boolean foundLeft = getpath(root.left, n , path);
        boolean foundRight = getpath(root.right, n , path);

        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node LowestCommonAncestor(Node root, int n1, int n2){       //O(n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getpath(root, n1, path1);
        getpath(root, n2, path2);

        //LCA
        int i =0;
        for(; i<path1.size() && i< path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
            Node lca = path1.get(i-1);
            return lca;
    }

    public static Node lca2(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2 ){
            return root;
        }
        Node Leftlca = lca2(root.left, n1, n2);
        Node Rightlca = lca2(root.right, n1, n2);

        if(Rightlca == null){
            return Leftlca;
        }
        if(Leftlca == null){
            return Rightlca;
        }
        return root;
    }


    public static int lcaDis(Node root, int n){
        if (root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDis = lcaDis(root.left, n);
        int rightDis = lcaDis(root.right, n);

        if(leftDis == -1 && rightDis == -1){
            return -1;
        } else if(leftDis == -1){
            return rightDis +1;
        } else return leftDis +1;
    }
    public static int minDis(Node root, int n1, int n2){
        Node lca = lca2(root, n1, n2);
        int dis1 = lcaDis(lca, n1 );
        int dis2 =lcaDis(lca, n2);

        return  dis1 + dis2;
    }




    public static void main(String[] args) {

        BinaryTKlvl.Node root = new BinaryTKlvl.Node(1);
        root.left = new BinaryTKlvl.Node(2);
        root.right = new BinaryTKlvl.Node(3);
        root.left.left = new BinaryTKlvl.Node(4);
        root.left.right = new BinaryTKlvl.Node(5);
        root.right.left = new BinaryTKlvl.Node(6);
        root.right.right = new BinaryTKlvl.Node(7);


        int k = 3;
        KLevel(root, 1, k);
        System.out.println(" ");


        int n1 = 4, n2 = 6;
        System.out.println(LowestCommonAncestor(root, n1, n2).data);

        System.out.println(lca2(root, n1, n2).data);
        System.out.println(minDis(root, n1, n2));
    }
}
