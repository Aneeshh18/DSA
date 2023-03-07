import java.util.Arrays;

public class selection {
    public static void main( String[] args ) {
        int []arr ={5,4,6,2,1,};
        selection2(arr);
        System.out.println(Arrays.toString(arr));
    }

/*    static void selection(int []arr){
        for(int i= 0; i<arr.length; i++){
            int last = arr.length -i - 1;
            int maxIndex=getMaxIndex(arr, 0 , last);
            swap(arr, maxIndex, last);
        }
    }

    static void swap( int[] arr, int max, int last ){
        int temp = arr[max];
         arr[max] = arr[last];
         arr[last] = temp;

    }

    static int getMaxIndex( int[] arr, int start, int end ){
        int max = start;
        for(int i = start; i <= end ; i++){
            if (arr[max]< arr[i])
                max = i;
        }
        return max;
    }*/

    static void selection2(int []arr ){
        for (int i =0; i< arr.length-1; i++){
            int min = arr[i];
            int minIndex = i;
            for (int j = i+1; j< arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIndex= j;
                }
            }
            if (arr[minIndex]!= arr[i]) {
                arr[ minIndex ] = arr[ i ];
                arr[ i ] = min;
            }
        }
    }
}
