package impls;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Storage {

    //insert
    //remove
    //random

    private List<Integer> list;
    private Map<Integer, Integer> map;


    public Storage(){

        list = new ArrayList<>();
    }

    public void insert(int element){

        list.add(element);
        map.put(element, list.size()-1);
    }

    public void remove(int element){

        //2, 5, 9, 10 -> 2, 10, 9 -> 2,
        int temp = list.get(list.size()-1);

        if(map.containsKey(element)) {

            list.set(map.get(element), temp);
            map.put(temp, map.get(element));
            map.remove(element);
            list.remove(list.size() - 1);
        }else{
            System.out.println("Element not found");
        }

    }

    public int random(){

        Random random = new Random();
        int index = random.nextInt(list.size()-1);
        return list.get(index);

    }

}
