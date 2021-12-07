package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamplesWithIntegerList {

    public static void main(String[] args) {

        Employee employee1 = new Employee(1,"Anand",List.of("9876543210","9876765432"));
        Employee employee2 = new Employee(2,"Manoj",List.of("9876563210","9886765432"));
        Employee employee3 = new Employee(3,"Ram",List.of("9876543310","9976765432"));
        Employee employee4 = new Employee(4,"Mohan",List.of("9877543210","9876365432"));
        Employee employee5 = new Employee(5,"Vipin",List.of("9879543210","9876465432"));


        HashMap<Integer, Integer> hm = new HashMap<>();
        //sorting Using Collections.sort()

        List<Employee> employeeList = new ArrayList<>(List.of(employee1,employee2,employee3,employee4,employee5));
        Collections.sort(employeeList,(emp1,emp2) -> emp1.getName().compareTo(emp2.getName()));
        System.out.println("employeeList sorted by name using Collections.sort(): "+employeeList);
        
        //sorting Using streams

        List<Employee> empList = employeeList.stream()
                                .sorted((emp1,emp2) -> emp1.getName().compareTo(emp2.getName()))
                                .collect(Collectors.toList());

        System.out.println("employeeList sorted by name using streams: "+ empList);

        //Given a list of integers, find out all the even numbers exist in the list using Stream functions

        List<Integer> integerList = new ArrayList<>(List.of(12,45,76,43,87,90,1,3,46,45,87));

        System.out.print("Even numbers in integerList using streams: ");
        integerList.stream()
                .filter(p -> p % 2 == 0)
                .forEach((i) -> System.out.print(i + " "));

        System.out.println(" ");
        System.out.print("Odd numbers in integerList using streams: ");
        integerList.stream()
                .filter((p) -> p % 2 != 0)
                .forEach((p) -> System.out.print( p + " "));

        //Given a list of integers, find out all the numbers starting with 1 using Stream functions

        System.out.println(" ");
        System.out.print("List of integers which start with 1 using streams: ");
        integerList.stream()
                .filter(p -> p.toString().startsWith("1"))
                .forEach(p -> System.out.print(p + " "));

        //How to print duplicate elements in a given integers list in java using Stream functions

        System.out.println(" ");
        System.out.print("List of duplicate elements in a list using streams: ");
        HashSet<Integer> integerHashSet = new HashSet<>();
        integerList.stream()
                .filter(p -> !integerHashSet.add(p))
                .forEach(p -> System.out.print(p + " "));

        //Given the list of integers, find the first element of the list using Stream functions
        System.out.println(" ");
        System.out.print("Find the first element of the list using streams: ");
        integerList.stream()
                .findFirst()
                .ifPresent(p -> System.out.print(p));

        //Given a list of integers, find the total number of elements present in the list using Stream functions

        System.out.println(" ");
        long listSize = integerList.stream()
                .count();
        System.out.println("Total elements present in the integerList using streams: "+ listSize);

        //Given a list of integers, find the maximum value element present in it using Stream functions
        //Using stream max()

        int maxElement = integerList.stream()
                .max((p1, p2) -> p1 - p2)
                .get();

        System.out.println("Maximum element present in the stream using max(): "+ maxElement);

        //Given a list of integers, find the maximum value element present in it using Stream functions
        //Using stream reduce()

        Integer maxUsingReduce = integerList.stream()
                .reduce(0, (p1,p2) -> p1 > p2 ? p1: p2);
        System.out.println("Maximum element present in the stream using reduce(): "+ maxUsingReduce);


    }
}
