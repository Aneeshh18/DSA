import java.util.Scanner;
public class fibonacci {
    public static void main( String[] args ) {
  /*      Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int a =0;
        int b=1;
        int c;
        for(int i= 1; i<=n ; i++){
            c = a+b;
            a = b;
            b = c;
        }
        System.out.println(a);*/
        int ans = fact(5);                   //through recursion
        System.out.println(ans);
    }

    static int fact(int n ){
        if(n <= 1){
            return 1;
        }

        return n * fact(n-1);
    }


}
