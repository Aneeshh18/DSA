import java.util.*;
public class validParenthesis {


    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();

        for (int i = 0; i <str.length(); i++){
            char ch = str.charAt(i);

            if(ch== '(' || ch== '{' || ch== '['){
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                if((s.peek() == '(' && ch == ')') ||  (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        } else {
            return false;
        }
    }


    public static boolean isDuplicate(String str2) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);

            //closing
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true; //duplicate
                } else {
                    s.pop();
                }
            } else {
                //opening operator operand
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str ="({})[]";
        String str2 ="((a+b)+(c+d))";
        //System.out.println(isValid(str));
        System.out.println(isDuplicate(str2));
    }
}
