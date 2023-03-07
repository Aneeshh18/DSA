//google split array - maximized or minimized sum

public class SplitArray {
    public static void main(String[] ags){
        int [] nums = {7,2,5,10,8};
        int m =2 ;
        System.out.println(splitarray(nums, m));
    }
    public static int splitarray(int[] nums , int m){
        int start =0;
        int end =0;

        for (int i =0; i< nums.length; i ++){
            start = Math.max(start, nums[i]); //max item in the array
            end = end + nums[i];
        }

        while(start< end){

            int mid = start + (end - start)/2;

            int sum =0;
            int pieces = 1;
            for (int num : nums ){
                if(sum + num >  mid){
                    sum = num;
                    pieces ++;
                }else{
                    sum += num;
                }
            }
            if( pieces > m){
                start = mid + 1;
            }else {
                end = mid ;
            }
        }
        return end; //start or end both are equal
    }
}
