import java.util.ArrayList;

public class HeapImp {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add( int data ) {  //O(log n)
            arr.add(data);

            int x = arr.size() - 1; //child index
            int par = ( x - 1 ) / 2; //par index

            while (arr.get(x) < arr.get(par)) {  //O(log n)
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
            }
        }

        public int peek() {
            return arr.get(0);
        }
    }

    public void main( String[] args ) {

    }
}
