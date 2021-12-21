package agent;

import house.House;

public class Agent implements AgentJob{

    private String agentName;
    private String agentContactNumber;
    private String agentFees;

    public Agent(String agentName, String agentContactNumber, String agentFees) {
        this.agentName = agentName;
        this.agentContactNumber = agentContactNumber;
        this.agentFees = agentFees;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentContactNumber() {
        return agentContactNumber;
    }

    public void setAgentContactNumber(String agentContactNumber) {
        this.agentContactNumber = agentContactNumber;
    }

    public String getAgentFees() {
        return agentFees;
    }

    public void setAgentFees(String agentFees) {
        this.agentFees = agentFees;
    }


    @Override
    public String isHouseAvailable(House house, House customerRequirement) {

        if(!customerRequirement.equals(house)){
            return "house not available";
        }else {
            house.setAvailable(false);
            return "house available";
        }
    }

}
