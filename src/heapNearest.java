import javax.xml.validation.TypeInfoProvider;
import java.util.PriorityQueue;

public class heapNearest {
    static class point implements Comparable<point>{

        int x, y , disSq, idx;

        public point (int x, int y, int disSq, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.disSq = disSq;
        }

        @Override
        public int compareTo(point p2){
            return this.disSq - p2.disSq;
        }
    }
    public static void main(String[] args){
        int pts[][] = {{3,3}, {-5,1}, {-2,4}};
        int k = 2;

        PriorityQueue<point> pq = new PriorityQueue<>();
        for (int i = 0; i< pts.length; i++){
            int disSq = pts[i] [0] *pts[i] [0] + pts[i] [1]*pts[i] [1];
            pq.add(new point(pts[i] [0], pts[i] [1], disSq, i ));
        }
        for (int i = 0; i<k; i++){
            System.out.println("C"+pq.remove().idx);
        }
    }
}
