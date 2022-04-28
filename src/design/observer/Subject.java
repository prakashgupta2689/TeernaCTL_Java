package design.observer;

public interface Subject {

    void register(Subscriber subscriber);
    void unregister(Subscriber subscriber);
    void upload();
    void notifySubscribers();
}
