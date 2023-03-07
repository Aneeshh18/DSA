import java.util.Arrays;

public class equilibriumIndex {
    public static void main( String[] args ) {
        int[] arr = {1, 3, 4, 2, 2, 5, 4, 1};
        int ans = equilibrium(arr);
        System.out.println(ans);

    }

    public static int equilibrium( int[] arr ){
        int totalsum =0;
        int index = 0;

        while (index < arr.length){
            totalsum += arr[index];
            index += 1;
        }
        int leftsum =0; int rightsum =0; int i =0;

        while (i< arr.length){
            rightsum = totalsum - leftsum - arr[i];
            if ( rightsum == leftsum) {
                return arr[i];
            }
            leftsum = leftsum + arr[i];
            i +=1;
        }
        return -1;
    }
}
