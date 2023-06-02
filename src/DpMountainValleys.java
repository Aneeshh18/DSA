public class DpMountainValleys {
    //O(n^2)
    public static int mountainRanges(int n){
        int[] dp  = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <=n ; i++) {
            //n pairs -> mountain ranges => Ci
            for (int j = 0; j < i; j++) {
                int inside = dp[j]; //way left subtree can be arranged
                int outside = dp[i-j-1];
                dp[i] += inside * outside ;   //Ci = Cj * Ci-j-1
            }
        }
        return dp[n];
    }
    public static void main( String[] args ) {
        int n = 4;
        System.out.println(mountainRanges(n));
    }
}
