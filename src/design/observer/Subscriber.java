package design.observer;

public class Subscriber implements Observer{

    private String name;
    private Channel channel = new Channel();

    public Subscriber(String name){
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("Hey "+ name + " a new video: "+ channel.getTitle() + " has been uploaded!");
    }

    @Override
    public void subscribeChannel(Channel ch) {
        this.channel = ch;
    }
}
