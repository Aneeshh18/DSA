public class DpCounTre {

    public static int countBst(int n ){
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <=n ; i++) {
            for (int j = 0; j < i; j++) {
                int left = dp[j]; //way left subtree can be arranged
                int right = dp[i-j-1];
                dp[i] += left * right ;   //Ci = Cj * Ci-j-1
            }
        }
        return dp[n];
    }

    public static void main( String[] args ) {
        int n = 3;
        System.out.println(countBst(5));
    }
}
