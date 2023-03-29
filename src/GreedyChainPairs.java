import java.util.Arrays;
import java.util.Comparator;

public class GreedyChainPairs { //O(nlogn)

    public static void main(String[] args){
        int[][] pairs = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}};


        Arrays.sort(pairs, Comparator.comparingDouble(o-> o[1]));
        int chainlg = 1;
        int pairend = pairs[0][1]; //last selec end or chain end
        for (int i = 1; i< pairs.length; i++){
            if(pairs[i][0] > pairend){
                chainlg++;
                pairend = pairs[i][1];
            }
        }
        System.out.println("Max length = " + chainlg);
    }
}
