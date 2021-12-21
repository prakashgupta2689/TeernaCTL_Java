package findHouse;

import agent.Agent;
import house.Address;
import house.House;

public class FindHouse {

    public static void main(String[] args) {

        House house = new House("Dhanbad", "House1", true, "20,000");
        Agent agent = new Agent("Agent1", "987654321", "2000");

        House customerRequirement1 = new House("Dhanbad", "House1", true, "20,000");
        System.out.println(agent.isHouseAvailable(house, customerRequirement1));

        System.out.println(agent.isHouseAvailable(house, customerRequirement1));

    }
}
