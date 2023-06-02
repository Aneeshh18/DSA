import java.util.Arrays;

public class DpCatalanNo {

    public static int catlanRec(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        int ans =0;
        for (int i = 0; i <= n-1; i++) {
            ans += catlanRec(i) * catlanRec(n-i-1);
        }
        return ans;
    }

    //memoization
    public static int catalanMemo(int n , int[] dp ){
        if(n == 0 || n == 1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i <n ; i++) {
            ans+= catalanMemo(i, dp) * catalanMemo(n-i-1, dp);
        }
        return ans;
    }


    public static int catTablulation(int n){
        int[] dp= new int[n+1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <=n ; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-j-1];   //Ci = Cj * Ci-j-1
            }
        }
        return dp[n];
    }

    public static void main( String[] args ) {
        int n = 4;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(catalanMemo(n , dp));
        System.out.println(catTablulation(4));
    }
}
