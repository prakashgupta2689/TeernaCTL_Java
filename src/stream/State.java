package stream;

import java.util.List;

public class State {

    private String code;
    private String name;
    private List<City> cities;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public State(String code, String name, List<City> cities) {
        this.code = code;
        this.name = name;
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "State{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", cities=" + cities +
                '}';
    }
}
