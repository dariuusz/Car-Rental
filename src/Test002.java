import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * This is a TEST002 class. It implements CreatingObjects interface to avoid creating objects multiple times.
 * This class displays all the registration numbers, keepers and cars and also transfer HashMap's content into TreeMap
 * @author Dariusz Jedrzejek 2012523
 */

public class Test002 implements CreatingObjects {

    private static Map<RegNo,Car> information = new HashMap<RegNo, Car>(); // HasMap created for this class purpose to convert into treeMap


    public static void main(String[] args) {


//        Car car1 = new Car("Toyota", "Yaris", "Black");
//        Car car2 = new Car("Ford", "Focus", "Silver");
//        Car car3 = new Car("Audi", "Q7", "Blue");
//
//
//        RegNo plateNo1 = new RegNo("DGH123A");
//        RegNo plateNo2 = new RegNo("TT67HJS");
//        RegNo plateNo3 = new RegNo("ASG12MK");
//
//
//        Address address1 = new Address("12 Casablanca", "London", "WA12HJ");
//        Address address2 = new Address("43 Wilson Pattern", " Liverpool", "HJ87JK");
//        Address address3 = new Address("123 Jamaica", "Manchester", "DF67DG");
//
//        Keeper keeper1 = new Keeper("David", "Jackson", address1);
//        Keeper keeper2 = new Keeper("Jack", "Hoggan", address2);
//        Keeper keeper3 = new Keeper("Steve", "Maradona", address3);
//        Keeper keeper4 = new Keeper("Steveee", "Maradona", address3);


        car1.addKeepers(keeper1);
        car2.addKeepers(keeper2);
        car3.addKeepers(keeper3);
        car1.addKeepers(keeper4);

        DVLA dvla = new DVLA();

        dvla.addRecords2(keeper1,plateNo1,car1);
        dvla.addRecords2(keeper2,plateNo2,car2);
        dvla.addRecords2(keeper3,plateNo3,car3);
        dvla.addRecords2(keeper4,plateNo2,car2);

        dvla.showALlCars2();
        System.out.println("======================================================================================================================================");
        information.put(plateNo1,car1);
        information.put(plateNo2,car2);
        information.put(plateNo3,car3);

        // Creating TreeMap list to transfer all objects from HashMap into TreeMap
        Map<RegNo,Car> treemap = new TreeMap<>();
        treemap.putAll(information);// putting all objects from HashMap at once

        System.out.println("Result for hasMap: ");
        System.out.println("HasMap " + information);

        System.out.println("\nResult for treeMap: ");
        System.out.println("treeMap " + treemap);


    }
}
