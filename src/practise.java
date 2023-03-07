import java.util.Scanner;
public class practise {
    public static void main( String[] args ) {

        int[] num ={2,7,11,15};
        int m = 9;
        System.out.println(twoSum(num , m));
    }

        public static int[] twoSum( int[] nums, int target ){
            for(int i=0;i<nums.length-1;i++) {
                for(int j=i+1;j<nums.length;j++) {
                    if(nums[i]+nums[j] == target)
                        return new int[]{i,j};
                }
            }
            return new int[0];
        }





/*      Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int prev = sc.nextInt();                         //dec or incresing
        int count = 2;
        boolean isdec = true;
        while (count <=n ) {
            int curr = sc.nextInt();
            count++;
            if (curr == prev) {
                System.out.println(false);
                return;
            }
            if (curr < prev) {
                if (!isdec) {
                    System.out.println("false");
                    return;
                }
            } else {
                if (isdec) {
                    isdec = false;
                }
            }
            prev = curr;
        }
        System.out.println("true");*/



       /* int binary =0 ; int pw =1;                            //3  dec to binary
        while (n>0){
            int last = n%2;
            binary += last *pw;
            pw *=10;
            n = n/2;
        }
        System.out.println(binary);*/



     /*   int count =1; int current = 1;            //2  ap series
        while (count <= n){
            int num = 3* current + 2;
            if(num % 4 !=0){
                System.out.print(num + " ");
                count ++;
            }
            current ++;
        }*/



      /*  System.out.println("Enter a num");               //1 sum of even dig and odd separately
        int n = sc.nextInt();
        int even = 0; int odd =0;
        while(n >0){
            int last = n % 10;
            if(last % 2 == 0){
                even +=  last;
            }else{
                odd += last;
            }
            n = n /10;
        }
        System.out.println( even + " " + odd );*/
    //}
}
