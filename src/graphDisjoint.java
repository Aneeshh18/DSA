import java.util.*;
import java.util.LinkedList;

public class graphDisjoint {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge( int s, int d, int w ) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }


    public static void bfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                bfsUtil(graph, vis);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[]vis){  //O(n)
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()){
            int curr =  q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println("");
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                dfsUtil(graph, i, vis);
            }
        }
    }

    public static void dfsUtil( ArrayList<Edge>[] graph, int curr, boolean []vis){
        //vist curr
        System.out.print(curr+" ");
        vis[curr]= true;
        for (int i = 0; i < graph[curr].size() ; i++) {
            Edge e = graph[curr].get(i);
            if(!vis[ e.dest ]){
                dfsUtil(graph, e.dest, vis);
            }
        }
    }
    public static void main( String[] args ) {

    }
}
