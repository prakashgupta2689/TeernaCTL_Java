package design.singleton;

public class ClassicSingletonImpl {

    private static ClassicSingletonImpl obj;

    //private constructor
    private ClassicSingletonImpl(){}

    //getter
    //do the obj creation in the getter
    public static ClassicSingletonImpl getInstance(){

        if(obj == null)
            obj = new ClassicSingletonImpl();
        return obj;
    }
}
