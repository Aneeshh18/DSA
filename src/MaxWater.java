import java.util.*;
public class MaxWater {
    public static void main( String[] args ) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(sotreWater2(height));
    }

    public static int storeWater(ArrayList<Integer> height){                // O(n^2) -brute force approach
        int maxWater = 0;
        for (int i = 0; i < height.size(); i++){
            for (int j = i+1 ; j < height.size(); j++ ){
                int ht = Math.min(height.get(i), height.get(j) );
                int width = j - i;
                int curentWater = ht * width;
                maxWater = Math.max(maxWater, curentWater);
            }
        }
        return maxWater;
    }


    /*Optimize approach - 2 pointer approach*/
    public static int sotreWater2(ArrayList<Integer> height){              //O(n)
        int maxWater = 0;
        int lp = 0;
        int rp = height.size()-1;

        while( lp < rp){
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp -lp;
            int currentWater = width * ht;
            maxWater = Math.max(maxWater, currentWater);

            if(height.get(lp) < height.get(rp)){
                lp ++;
            } else {
                rp --;
            }
        }
        return maxWater;
    }

}
