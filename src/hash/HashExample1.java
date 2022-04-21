package hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashExample1 {

    public static void main(String[] args) {

        //add employees in the hashmap and employees having the same id should
        //not be added in the map and should throw error while adding in the map


        Map<Employee, Integer> map = new HashMap<>();
        map.put(new Employee(2, "Emp1"), 2);
        map.put(new Employee(2, "Emp2"), 3);
        map.put(new Employee(4, "Emp3"), 4);

        System.out.println(map.size());
        System.out.println(map);
    }
}
