import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 6 };
        int target = 7;
        System.out.println(search(arr, target));
    }
    public static int search(int[] arr, int target) {

        int i=0;
        for(i=0;i<arr.length;i++){
            if(arr[i]==target || arr[i]>target)return i;
        }
        return i;

    }
}
