package design.observer;

import java.util.ArrayList;
import java.util.List;

public class Youtube {

    public static void main(String[] args) {

        Channel javaBrains = new Channel("JavaBrains");
        List<Subscriber> subscribers = new ArrayList<>(List.of(
                new Subscriber("Teerna"),
                new Subscriber("Priyanka"),
                new Subscriber("Pragya")
        ));

        javaBrains.register(new Subscriber("Teerna"));
        javaBrains.register(new Subscriber("Priyanka"));
        javaBrains.register(new Subscriber("Pragya"));

        javaBrains.upload();
    }
}
