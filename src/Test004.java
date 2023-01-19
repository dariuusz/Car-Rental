import java.time.Month;

/**
 * This is a TEST004 class. It implements CreatingObjects interface to avoid creating objects multiple times.
 * This class displays all the registration numbers, keepers and cars. It also displays users with remaining and overdue tax.
 * @author Dariusz Jedrzejek 2012523
 */

public class Test004 implements CreatingObjects{

    public static void main(String[] args) {

//        Car car1 = new Car("Toyota", "Yaris", "Black", Month.DECEMBER);
//        Car car2 = new Car("Ford", "Focus", "Silver",Month.JANUARY);
//        Car car3 = new Car("Audi", "Q7", "Blue", Month.JANUARY);
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
//        Keeper keeper3 = new Keeper("James", "Chan", address3);
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
        System.out.println("");
        dvla.reminderLetter();
        System.out.println("");
        dvla.warningLetter();


    }
}
