package stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExamplesWithStringList {

    public static void main(String[] args) {

       State state1 = new State("A10C0","Jharkhand",
               List.of(new City("Dhanbad","12345"),new City("Ranchi" ,"10000")));

        State state2 = new State("B10A2","West Bengal",
                List.of(new City("Kolkata","3241"),new City("Durgapur" ,"2345")));

        State state3 = new State("A10F3","Karnataka",
                List.of(new City("Bangalore","123450"),new City("Manipal" ,"2745")));

        State state4 = new State("D10R4","Bihar",
                List.of(new City("Patna","5678"),new City("Bhagalpur" ,"6789")));


        List<State> stateList = new ArrayList<>(List.of(state1,state2,state3,state4));

        //Given a String, find the first non-repeated character in it using Stream functions
        String inputString = "I love Java!";
        Character result = inputString.chars()
                .mapToObj(p -> Character.toLowerCase((char) p))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();

        System.out.println(" ");
        System.out.println("First non-repeated character is: "+result);

        //Given a list of state objects, print the state codes

        System.out.print("State codes for each state: ");
        stateList.stream()
                .forEach(p -> System.out.print(p.getCode() + " "));

        //Given a list of state objects, print the state codes that begin with misc.A
        System.out.println(" ");
        System.out.print("Given a list of state objects, print the state codes that begin with misc.A: ");

        stateList.stream()
                .filter(p -> p.getCode().startsWith("misc.A"))
                .forEach(p -> System.out.print(p.getCode() + " "));

        //Given a list of state objects, modify names to upper case, and print names whose codes begin with misc.A.
        System.out.println(" ");
        System.out.print("Modify names to upper case, and print names whose codes begin with misc.A: ");

        stateList.stream()
                .filter(p -> p.getCode().startsWith("misc.A"))
                .map(p -> p.getName().toUpperCase())
                .forEach(p -> System.out.print(p + " "));

        //Given a list of state objects, modify names to upper case, and print names whose codes begin with misc.A and sorted in alphabetical order

        System.out.println(" ");
        System.out.print("Modify names to upper case, and print names whose codes begin with misc.A and sorted in alphabetical order: ");

        stateList.stream()
                .filter(p -> p.getCode().startsWith("misc.A"))
                .map(p -> p.getName().toUpperCase())
                .sorted((p1,p2) -> p2.compareTo(p1))
                .forEach(p -> System.out.print(p + " "));

        //Given a list of state objects, create a map with code as key and name as value.

        System.out.println(" ");
        System.out.println("Given a list of state objects, create a map with code as key and name as value: ");

        Map<String, String> map = stateList.stream()
                .collect(Collectors.toMap(e -> e.getCode(), f -> f.getName()));
        System.out.println(map);


        //Given a list of state objects, print the list of cities in each state.

        System.out.println(" ");
        System.out.println("Given a list of state objects, print the list of cities in each state: ");

        stateList.stream()
                .flatMap(p -> p.getCities().stream())
                .forEach(p -> System.out.println(p.getName()));

        //Sort a map on the keys using lambdas
        System.out.println(" ");
        System.out.println("Sorted Map based on keys using using Collections.sort(): ");

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Five", 5);
        hashMap.put("Two",2);
        hashMap.put("Six", 6);

        //first convert the map to an entrySet list
        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(hashMap.entrySet());

        Collections.sort(entryList,(p1,p2) -> p1.getKey().compareTo(p2.getKey()));

        for(Map.Entry<String, Integer> entry: entryList){
         System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println(" ");
        System.out.println("Sorted Map based on keys using using streams: ");

        hashMap.entrySet().stream()
                .sorted((p1, p2) -> p1.getKey().compareTo(p2.getKey()))
                .forEach(p -> System.out.println(p.getKey() + " " + p.getValue()));

        //sort a Map having custom object as key and integer value

        Map<Employee, Integer> employeeMap = new HashMap<>();
        employeeMap.put(new Employee(1, "Manoj",List.of("1234","4567")),200);
        employeeMap.put(new Employee(2, "Rakesh",List.of("1234","4567")),201);
        employeeMap.put(new Employee(3, "Mohan",List.of("1234","4567")),202);
        employeeMap.put(new Employee(4, "Aman",List.of("1234","4567")),203);
        employeeMap.put(new Employee(5, "Dheeraj",List.of("1234","4567")),204);

        System.out.println(" ");
        System.out.println("sort a Map having custom object as key and integer value using Collections.sort(): ");
        List<Map.Entry<Employee, Integer>> empList = new ArrayList<>(employeeMap.entrySet());

        Collections.sort(empList, (p1, p2) -> p1.getKey().getName().compareTo(p2.getKey().getName()));

        for(Map.Entry<Employee, Integer> entry : empList){
         System.out.println(entry.getKey() + " " + entry.getValue());
       }

        System.out.println(" ");
        System.out.println("sort a Map having custom object as key and integer value using streams: ");

        employeeMap.entrySet().stream()
                .sorted((p1, p2) -> p1.getKey().getName().compareTo(p2.getKey().getName()))
                .forEach(p -> System.out.println(p.getKey() + " " + p.getValue()));


        //Evaluate longest string from a list of string

        System.out.println(" ");
        System.out.println("Evaluate longest string from a list of string: ");

        List<String> namesList = new ArrayList<>(List.of("Ram", "Mohan", "Manoj", "Ravi"));

        namesList.stream()
                .reduce((p1, p2) -> p1.length() > p2.length() ? p1 : p2)
                .ifPresent(System.out::println);
    }
}
