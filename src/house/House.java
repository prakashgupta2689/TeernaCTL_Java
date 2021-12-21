package house;

public class House {

    private String address;
    private String houseName;
    private boolean isAvailable;
    private String houseCost;

    public House(String address, String houseName, boolean isAvailable, String houseCost) {
        this.address = address;
        this.houseName = houseName;
        this.isAvailable = isAvailable;
        this.houseCost = houseCost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getHouseCost() {
        return houseCost;
    }

    public void setHouseCost(String houseCost) {
        this.houseCost = houseCost;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null
                || this.getClass() != obj.getClass())
            return false;

        House h1 = (House) obj;

        return this.houseName.equals(h1.houseName)
                && this.houseCost.equals(h1.houseCost)
                && this.address.equals(h1.address)
                && this.isAvailable == h1.isAvailable;
    }
}
