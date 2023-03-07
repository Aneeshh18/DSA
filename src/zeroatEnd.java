import java.util.Arrays;

public class zeroatEnd {
    public static void main( String[] args ) {
        int []arr ={1, 2, 0, 4, 3, 0, 5, 0};
        pushzero(arr);
    }
    public static void pushzero(int []arr){
        int nonzero =0;
        for (int i = 0; i< arr.length; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[nonzero];
                arr[nonzero] = temp;
                nonzero ++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[ i ] + " ");
        }
    }
}
