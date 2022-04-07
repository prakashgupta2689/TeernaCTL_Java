package misc;

import java.util.HashSet;

public class WrappedString {

    private String s;

    public WrappedString(String s) {
        this.s = s;
    }

    public static void main(String[] args) {

        HashSet<Object> hs = new HashSet<>();
        WrappedString ws1 = new WrappedString("abc");
        WrappedString ws2 = new WrappedString("abc");

        String s1 = new String("abc");
        String s2 = new String("abc");

        hs.add(ws1);
        hs.add(ws2);
        hs.add(s1);
        hs.add(s2);

        System.out.println(hs.size());

        for (Object o: hs){
            System.out.println(o);
        }

    }
}
