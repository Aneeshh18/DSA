public class SetBit {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(Integer.toBinaryString(n));

        System.out.println(SetBit(n));
    }
    private static int SetBit(int n){
        int count = 0;

        while(n>0){
            count++;
            n-= (n & -n);
        }
        return count;
    }
}
