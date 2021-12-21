package agent;

import house.House;

public interface AgentJob {

    public String isHouseAvailable(House house, House customerRequirement);
}
