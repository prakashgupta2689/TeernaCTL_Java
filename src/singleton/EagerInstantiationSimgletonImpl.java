package singleton;

public class EagerInstantiationSimgletonImpl {

    private static EagerInstantiationSimgletonImpl obj = new EagerInstantiationSimgletonImpl();

    private EagerInstantiationSimgletonImpl(){}

    public static EagerInstantiationSimgletonImpl getInstance(){

        return obj;
    }
}
