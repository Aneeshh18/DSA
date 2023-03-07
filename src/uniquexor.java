public class uniquexor {
    public static void main( String[] args ) {
        int [] arr = {2,3,4,4,6,3,2};
        System.out.println(uniquexor.ans(arr));
    }

    private static int ans( int[] arr ) {
        int unique = 0;
        for(int n : arr){
            unique ^= n;            //xor property of a^a = 0   O(n)
        }
        return unique;
    }

}
