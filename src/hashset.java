import java.util.*;

public class hashset {
    public static void main(String[] args){
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Lucknow");
        cities.add("Pune");
        cities.add("Mumbai");
        System.out.println(cities);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Lucknow");
        lhs.add("Pune");
        lhs.add("Mumbai");
        System.out.println(lhs);
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Lucknow");
        ts.add("Pune");
        ts.add("Mumbai");
        System.out.println(ts);
    }
}
