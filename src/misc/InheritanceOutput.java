package misc;

import misc.B;
import misc.C;

public class InheritanceOutput {

    public static void main(String[] args) {

        B b = new B();
        System.out.println(b instanceof B && (!(b instanceof C)));
    }
}
