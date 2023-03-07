package inheri.java;

public class Main {
    public static void main( String[] args ) {
       /* Box box1 = new Box();
        Box box2 = new Box(box1);
        System.out.println(box1.l + " " + box1.h);
        System.out.println(box2.l + " " + box2.h);
*/

        BoxWeight box3 = new BoxWeight();
        BoxWeight box4 = new BoxWeight(3, 2, 3, 2); 
        System.out.println(box3.w + " " + box3.h);
    }
}
