import java.util.Scanner;

public class prime {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        if (n<=1){
            System.out.println("composite number");
        }
        int c = 2;
        while (c*c <= n){
            if(n%c ==0){
                System.out.println("Not a Prime num");
                return;
            }
            c = c+1;
        }
        System.out.println(" Prime num");

        /*int c = 2;
        boolean isPrime = true;
        while (c*c <= n){
            if(n%c ==0){
                isPrime = false;
            }
            c = c+1;
        }
        if (isPrime == true) {
            System.out.println("Prime num");
        }else{
            System.out.println("Not a prime num");
        }*/
    }
}
