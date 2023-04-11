import java.util.*;

public class HeapImp {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add( int data ) {  //O(log n)
            arr.add(data);

            int x = arr.size() - 1; //child index
            int par = (x - 1) / 2; //par index


            while (arr.get(x) < arr.get(par)) {  //O(log n)
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = ( x - 1 ) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }


        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;
            if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }
            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }
        }
        public int remove(){
            int data = arr.get(0);

            //step 1 swap
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step 2
            arr.remove(arr.size()-1);
            //step 3
            heapify(0);
            return data;
        }
    }

    public static void main( String[] args ) {

        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}
