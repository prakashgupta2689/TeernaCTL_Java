package design.singleton;

public class DoubleCheckedLockingSingletonImpl {

    //We have declared the obj volatile which ensures that multiple threads offer the obj variable correctly when it is being initialized to Singleton instance.
    // This method drastically reduces the overhead of calling the synchronized method every time.
    private static volatile DoubleCheckedLockingSingletonImpl obj = null;

    private DoubleCheckedLockingSingletonImpl(){}

    public static DoubleCheckedLockingSingletonImpl getInstance(){

        if(obj == null){

            synchronized (DoubleCheckedLockingSingletonImpl.class){

                if(obj == null)
                    obj = new DoubleCheckedLockingSingletonImpl();
            }
        }
        return obj;
    }
}
