package misc;

import hash.HashExample1;

import java.util.HashMap;
import java.util.Map;

public class Person {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        return 13;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Person p1 = new Person("firstName1", "LastName1");
        Person p2 = new Person("firstName2", "LastName2");

        Map<Person, String> map = new HashMap<>();

        map.put(p1, "This is first person object");
        map.put(p2, "This is second person object");

        map.put(new Person("firstName1", "LastName1"), "Overriding First Person Object");

        System.out.println(map.size());
        System.out.println(map.get(new Person("firstName1", "LastName1")));

    }

    public void method(){

        MyAdd<Number> myAdd = new MyAdd<>();
        myAdd.add(10);
        myAdd.add(12.0);
    }

    class MyAdd<T>{

        void add(T t){

        }
    }
}
