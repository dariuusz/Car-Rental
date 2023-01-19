import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.time.Month;
import java.util.*;


/**
 * This is a Car class to create cars' objects and store Keepers' objects if more than one is signed into a car.
 * @author Dariusz Jedrzejek 2012523
 */

public class Car {

    private final String make;
    private final String model;
    private String colour;
    private List<Keeper>keepers = new LinkedList<>();
    private Month taxExpiresEndMonth;

    /**
     * The constructor used in Test005 class to return remaining and warning letters
     * @param make make
     * @param model model
     * @param colour colour
     * @param taxExpiresEndMonth taxExpiresEndMonth
     */
    public Car(String make, String model, String colour, Month taxExpiresEndMonth) {
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.taxExpiresEndMonth = taxExpiresEndMonth;
    }

    /**
     * The second constructor used since Test001 to Test004 class to create objects.
     * @param make make
     * @param model model
     * @param colour colour
     */
    public Car(String make, String model, String colour) {
        this.make = make;
        this.model = model;
        this.colour = colour;
    }


    /**
     * Method used to add keepers into the LinkedList
     * @param keeper keeper
     */
    public void addKeepers(Keeper keeper){
        keepers.add(keeper);
    }

    /**
     * Method used to remove keepers is an operator will want from the LinkedList.
     * @param keeper keeper
     */
    public void removeKeeper(Keeper keeper){
        if(keepers.isEmpty()){
            System.out.println("There is no record in the list.");
        }else{
            keepers.remove(keeper);
        }
    }

    /**
     *Method used to display content of the keeper list if more than one has been existed.
     * @return keeper as an String
     */
    public String showKeepers(){
        Iterator iterator = keepers.iterator();
        while (iterator.hasNext()){
            Keeper keeper = (Keeper) iterator.next();
            return String.valueOf(keeper); // return String instead an object to let DVLA methods display more keepers for one car.
        }
       return null;
    }

    /**
     * Getter for make
     * @return make
     */
    public String getMake() {
        return make;
    }

    /**
     * Getter for model
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * Getter for colour
     * @return colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * Set new colour after repairing
     * @param colour colour
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * Getter for tax when it will have expired.
     * @return taxExpiresEndMonth
     */
    public Month getTaxExpiresEndMonth() {
        return taxExpiresEndMonth;
    }

    /**
     * Set new tax date
     * @param taxExpiresEndMonth t
     */
    public void setTaxExpiresEndMonth(Month taxExpiresEndMonth) {
        this.taxExpiresEndMonth = taxExpiresEndMonth;
    }

    /**
     * Method used in Test001 class before adding more functionalities to display more users than one for a car.
     * @return keepers
     */
    public List<Keeper> getKeepers() {
        return keepers;
    }

    /**
     * Description of a Car class
     * @return description of a car.
     */
    @Override
    public String toString() {
        return "Car :" +
                "make =" + make +
                ", model = " + model +
                ", colour =" + colour  ;
    }

}
