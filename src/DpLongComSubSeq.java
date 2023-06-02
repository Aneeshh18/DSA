public class DpLongComSubSeq {

    public static int lcs(String str1, String str2, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return lcs(str1, str2, n-1, m-1) + 1;
        } else {
            int ans1 = lcs(str1, str2, n-1, m);
            int ans2 = lcs(str1,str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }


    public static int lcsMem(String str1, String str2){
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        for (int i = 0; i < str1.length()+1; i++) {
            for (int j = 0; j < str2.length()+1; j++) {
                dp[i][j] = -1;
            }
        }
        return lcsMem(str1,str2,dp);
    }
    private static int lcsMem(String str1, String str2, int[][] dp){
        int n = str1.length();
        int m = str2.length();

        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(n == 0 || m ==0 ){
            return dp[n][m] = 0;
        }
        if(str1.charAt(0) == str2.charAt(0)){
            return dp[n][m]  = 1+lcsMem(str1.substring(1), str2.substring(1), dp);
        } else {
            int ans1 = lcsMem(str1, str2.substring(1), dp);
            int ans2 = lcsMem(str1.substring(1), str2, dp);
            dp[n][m] = Math.max(ans1,ans2);
        }
        return dp[n][m];
    }
    public static void main( String[] args ) {
        String str1 = "abcdge";
        String str2 = "abedg";  //lcs = "abdg" len =4
        //System.out.println(lcs(str1, str2, str1.length(), str2.length()));
        System.out.println(lcsMem(str1,str2));
    }
}
