import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyCoin {

    public static void main(String[] args){
        Integer[] coins = {1,2,5,10,20,50,100,500,2000};

        Arrays.sort(coins, Comparator.reverseOrder());

        int count =0;
        int amt =590;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i =0; i< coins.length; i++){
            if(coins[i] <= amt){
                while (coins[i] <= amt){
                    count++;
                    ans.add(coins[i]);
                    amt -= coins[i];
                }
            }
        }
        System.out.println("Total count used =" + count);

        for (int i=0 ; i<ans.size(); i++){
            System.out.println(ans.get(i)+ " ");
        }
    }
}
