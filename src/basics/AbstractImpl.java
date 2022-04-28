package basics;

public class AbstractImpl extends AbstractExample{

    AbstractImpl(){
       printFromAbstract();
    }

    @Override
    void printFromAbstract() {
        System.out.println("Hey There!");
    }
}
