/**
 * This is an Address class which describes Keeper's address
 * @author Dariusz Jedrzejek 2012523
 */

public class Address {

    private String street;
    private String town;
    private String postcode;

    /**
     * Constructor with 3 parameters to describe an object
     * @param street street
     * @param town town
     * @param postcode postcode
     */
    public Address(String street, String town, String postcode) {
        this.street = street;
        this.town = town;
        this.postcode = postcode;
    }

    /**
     * Getter for street parameter
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter to change the street
     * @param street street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Getter for town parameter
     * @return town
     */
    public String getTown() {
        return town;
    }

    /**
     * Setter to change the town
     * @param town town
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * Getter for postcode parameter
     * @return postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Setter to change the postcode
     * @param postcode postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * Description of an Address's object
     * @return an object's description
     */
    @Override
    public String toString() {
        return " street = " + street +
                ", town = " + town +
                ", postcode = " + postcode;
    }
}
