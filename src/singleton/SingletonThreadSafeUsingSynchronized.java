package singleton;

public class SingletonThreadSafeUsingSynchronized {

    private static SingletonThreadSafeUsingSynchronized  obj;

    private SingletonThreadSafeUsingSynchronized(){}

    public static synchronized SingletonThreadSafeUsingSynchronized getInstance(){

        if(obj == null)
            obj = new SingletonThreadSafeUsingSynchronized();

        return obj;
    }
}
