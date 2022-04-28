package basicCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {

    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> integerList = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8));

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            list.add(3, 10);
            it.next();
        }

        Iterator<Integer> it1 =integerList.iterator();
        while (it1.hasNext()){
            integerList.add(2, 20);
            it1.next();
        }
        System.out.println(list);
        System.out.println(integerList);
    }
}
