public class pattern {
    public static void main( String[] args ) {
        pattern4(5);
    }


    static void pattern7(int n){    //inverted mirror star pat
        for (int i = 1; i<= n; i++){
            for (int j = 1 ; j<=n-i ; j++)
            {
                System.out.print(" ");
            }
            for (int j=1 ; j<=i ; j++){
                System.out.print(j+i-1);
            }
            System.out.println(" ");
        }
    }

    static void pattern6(int n){        //number and related pattern
        for(int i = 1; i <=n ; i++){
            for (int j = 1 ; j <n ; j++){
                System.out.print (n-j);
            }
            System.out.println(" ");
        }
    }


    static void pattern5( int n ) {  //diamond
        for (int row = 1; row <= n; row++) {
            for (int space = 0; space < n - row; space++) {
                System.out.print(" ");
            }
            int col;
            for (col = row; col >= 1; col--) {
                System.out.print(col);
            }
            for (col = 2; col <= row; col++) {
                System.out.print(col);
            }
            System.out.println(" ");
        }
    }




    static void pattern4( int n ){  //diamond
        for (int row = 0; row < n*2 ; row++) {
            int c = row > n ? 2*n - row -1 : row;
            int space = n - c;
            for (int s = 0 ;  s < space; s++)
                System.out.print(" ");
            for (int col = 0; col <c ; col++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }




    static void pattern3( int n ){  //doubly inverted star
        for (int row = 0; row < n*2 ; row++) {

            int c = row > n ? 2*n - row -1 : row;
            for (int col = 0; col <c ; col++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }



    static void pattern2( int n ){  //numbers 1-5
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+i-1);
            }
            System.out.println(" ");
        }
    }



    static void pattern1( int n ){  //inverted star
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }


}
