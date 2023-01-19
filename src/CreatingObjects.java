/**
 * CreatingObjects interface is used to reduce typing code for TestClasses.
 * @author Dariusz Jedrzejek 2012523
 */

interface CreatingObjects {

    Car car1 = new Car("Toyota", "Yaris", "Black");
    Car car2 = new Car("Ford", "Focus", "Silver");
    Car car3 = new Car("Audi", "Q7", "Blue");

    RegNo plateNo1 = new RegNo("DGH123A");
    RegNo plateNo2 = new RegNo("TT67HJS");
    RegNo plateNo3 = new RegNo("ASG12MK");

    Address address1 = new Address("12 Casablanca", "London", "WA12HJ");
    Address address2 = new Address("43 Wilson Pattern", " Liverpool", "HJ87JK");
    Address address3 = new Address("123 Jamaica", "Manchester", "DF67DG");

    Keeper keeper1 = new Keeper("David", "Jackson", address1);
    Keeper keeper2 = new Keeper("Jack", "Hoggan", address2);
    Keeper keeper3 = new Keeper("Steve", "Maradona", address3);
    Keeper keeper4 = new Keeper("Steveee", "Maradona", address3);


}
