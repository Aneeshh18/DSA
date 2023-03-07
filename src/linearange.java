import java.util.Arrays;

public class linearange {
    public static void main(String[] args) {
        int[] arr ={7,46,575,75,22,4,-2};
        int target = 22;
        System.out.println(search(arr, target, 1,5));
    }
    static int search(int[] arr, int target, int start, int end) {
        if (arr.length == 0) {
            return -1;
        }

        for (int index=start; index<= end; index++) {
            int element = arr[index];
            if(target == element) {
                return index;
            }
        }
        return -1;
    }
}