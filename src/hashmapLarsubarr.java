import java.util.HashMap;

public class hashmapLarsubarr {

    public static void main( String[] args ) {

   /*     //Largest subarray with 0 sum
        int arr[] = {1,-2,2,-8,1,7,10,2};
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int len = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[ j ];
            if(map.containsKey(sum)){
                len =Math.max(len, j-map.get(sum));
            } else {
                map.put(sum, j);
            }
        }
        System.out.println("largest subarray =" + len);*/



        //subarray with sum equal to K
        int[] arr = {10,2,-2,-20,10};
        int k = -10;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int sum = 0;
        int ans = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        System.out.println("subarray sum eqaul k =" + ans);

    }
}
