package misc;

public class GarbageCollection {

    static GarbageCollection t;
    static int count = 0;

    public static void main(String[] args) throws InterruptedException{

        GarbageCollection t = new GarbageCollection();

        t = null;
        System.gc();

        Thread.sleep(1000);

        t= null;
        System.gc();

        Thread.sleep(1000);

        System.out.println(count);
    }

    @Override
    protected void finalize() throws Throwable {
        count++;
        t=this;
    }
}
