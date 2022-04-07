package misc;

import misc.Animal;
import misc.Bird;

public class Duck extends Bird implements Animal {

    boolean swim;

    public void poop(){
        System.out.println("I am a duck. I poop!");
    }

}
