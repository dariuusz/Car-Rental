import java.util.Iterator;
import java.util.LinkedList;

/**
 * This is a Keeper class
 * @author Dariusz Jedrzejek 2012523
 */

public class Keeper {

    private String forename;
    private String surname;
    private Address address;
    private LinkedList<Car> cars = new LinkedList<>();

    public Keeper(String forename, String surname, Address address) {
        this.forename = forename;
        this.surname = surname;
        this.address = address;
    }

    /**
     *
     * @param car
     */
    public void addCars(Car car){
        cars.add(car);
    }

    /**
     *
     * @param car
     */
    public void removeCars(Car car){
        if(cars.isEmpty()){
            System.out.println("There is no record in the list.");
        }else{
            cars.remove(car);
        }
    }

    /**
     *
     */
    public void showCars(){
        Iterator iterator = cars.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\n\tKeeper :" +
                " forename = " + forename  +
                ", surname = " + surname+
                ", address = " + address + '\t';
    }
}
