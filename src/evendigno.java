import java.util.Arrays;

//LeetCode - Find numvber with even number of digit.
public class evendigno {
    public static void main(String[] args) {
        int[] nums = {12, 45, 444, 5456, 454};
        System.out.println(findNumbers(nums));
    }
    static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (even(num)){
                count++;
        }
    }
        return count;
    }
    static boolean even(int num){
        int numberOfDigit= digit(num);
        return numberOfDigit % 2 == 0;
    }
    static int digit(int num){
        if(num<0){
            num = num * -1;
        }
        return (int)(Math.log10(num))+1;
    }
}
