import java.util.*;
public class stackNextGrt {           //O(n)

    public static void main( String[] args ) {
        int[] arr = {6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int[] nxtGrt = new int[arr.length];


        for (int i = arr.length - 1; i >=0; i -- ){
            while (!s.isEmpty() &&  arr[s.peek()] < arr[ i ] ){     //arr[s.peek] as index is stored at top of stack
                s.pop();
            }
            if(s.isEmpty()){
                nxtGrt[i] = -1;
            } else {
                nxtGrt[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for (int j : nxtGrt) {
            System.out.print(j + " ");
        }
    }
}
