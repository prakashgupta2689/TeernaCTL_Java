package design.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject{

    private String title;
    private List<Subscriber> subs;

    Channel(String title){
        this.title = title;
        subs = new ArrayList<>();
    }

    Channel(){

    }

    public String getTitle() {
        return title;
    }

    @Override
    public void register(Subscriber subscriber) {
        subs.add(subscriber);
    }

    @Override
    public void unregister(Subscriber subscriber) {

        subs.remove(subscriber);
    }

    @Override
    public void upload() {
        notifySubscribers();
    }

    @Override
    public void notifySubscribers() {

        for (Subscriber sub: subs){
            sub.update();
        }
    }
}
