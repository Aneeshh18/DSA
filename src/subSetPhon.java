import java.util.ArrayList;

public class subSetPhon {
    public static void main( String[] args ) {
        System.out.println(pholet("", "23"));
    }

    static ArrayList<String> pholet(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0' ;
        ArrayList<String> list = new ArrayList<>();

        for (int i = (digit - 1 )* 3; i <(digit * 3); i++){
            char ch = (char)('a' + i);
            list.addAll(pholet(p+ch, up.substring(1)));
        }
        return list;
    }
}
