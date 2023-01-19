
/**
 * This is a TEST001 class and implements CreatingObjects interface to avoid creating objects multiple times.
 * @author Dariusz Jedrzejek 2012523
 */

public class Test001 implements CreatingObjects {

    public static void main(String[] args) {

        DVLA dvla = new DVLA();
        car1.addKeepers(keeper1);
        car1.addKeepers(keeper4);
        car2.addKeepers(keeper2);
        car3.addKeepers(keeper3);

        dvla.addRecords(plateNo1, car1);
        dvla.addRecords(plateNo2, car2);
        dvla.addRecords(plateNo3, car3);

        dvla.showALlCars();

    }
}





