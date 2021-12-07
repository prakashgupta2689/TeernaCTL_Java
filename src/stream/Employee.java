package stream;

import java.util.List;

public class Employee {

    private int id;
    private String name;
    private List<String> phNo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhNo() {
        return phNo;
    }

    public void setPhNo(List<String> phNo) {
        this.phNo = phNo;
    }

    public Employee(int id, String name, List<String> phNo) {
        this.id = id;
        this.name = name;
        this.phNo = phNo;
    }

    public Employee(){
        super();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phNo=" + phNo +
                '}';
    }
}
