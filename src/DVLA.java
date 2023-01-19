import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.Month;
import java.time.Year;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.io.*;


/**
 * This is a DVLA class which is used to search any users which remaining and warning letters whose tas will be expired or has already expired.
 * Moreover, this class is used to write, read and delete files from C or M drive. In my case, I used C drive.
 * I had to use my C driver location to write files, therefore I do not have access to M drive remotely.
 * @author Dariusz Jedrzejek 2012523
 */

public class DVLA  {

    private Map<RegNo,Car> information = new HashMap<RegNo, Car>();
    private Map<Keeper, HashMap.Entry<RegNo,Car>> info = new HashMap<Keeper, Map.Entry<RegNo,Car>>(); // Embedded HasMap with RegNo and Car as an entry's key.

    /**
     * // Method used in the very first Test001 class to display content of the list where HashMap contains RegNo and Car objects
     */
    public void showALlCars() {

        Iterator<Map.Entry<RegNo, Car>> iterator = information.entrySet().iterator();
        RegNo keyNumber;
        Car car;
        Map.Entry<RegNo, Car> entry; // defining entry as RegNo and Car key
        while (iterator.hasNext()) {
            entry = (Map.Entry<RegNo, Car>) iterator.next();
            keyNumber = entry.getKey();
            car = entry.getValue();
            String keeper = car.showKeepers(); // keeper variable to invoke all keepers of a car who are registered to a registration number.
            if (keyNumber != null  ) {
                System.out.println(keyNumber + "" + car + "" + car.showKeepers());
            }
        }
    }

    /**
     * Method used since Test002 classes to return content of the HashMap.
     * The list contains three objects RegNo, Keeper anc Car. This method is being used Iterator and does operation on embedded HashMap.
     */
    public void showALlCars2() {

        Iterator<Map.Entry<Keeper, Map.Entry<RegNo, Car>>> iterator = info.entrySet().iterator();

        Keeper keeper;
        RegNo plateNo;
        Car car;
        Map.Entry<Keeper,Map.Entry<RegNo,Car>> entry; // defining Keeper as the first entry

        while (iterator.hasNext()){

            entry = (Map.Entry<Keeper,Map.Entry<RegNo,Car>>)iterator.next();
            keeper = entry.getKey();
            plateNo = entry.getValue().getKey(); // this variable is also used getkey() method after getValue() method as the second entry key because it is embedded
            car = entry.getValue().getValue(); // this variable has to use two getValue() methods to display content because it is embedded
            System.out.println(plateNo + "" + car + "" + keeper );
        }
    }

    /**
     * Method used to add RegNo and Car objects into HasMap used in Test001 class
     * @param plateNo plateNo
     * @param car car
     */
    public void addRecords(RegNo plateNo, Car car){
        information.put(plateNo,car);
    }

    /**
     * Method used to add Keeper, RegNo and Car objects into HasMap used since Test002 class and up
     * @param keeper keeper
     * @param plateNo plateNo
     * @param car car
     */
    public void addRecords2(Keeper keeper, RegNo plateNo, Car car){
        info.put(keeper,new SimpleEntry(plateNo,car) );
    }

    /**
     * Method used to display users with remaining tax. it being used iterator as previous one .
     */
    public void reminderLetter(){
        Iterator<Map.Entry<Keeper, Map.Entry<RegNo, Car>>> iterator = info.entrySet().iterator();

        Keeper keeper;
        RegNo plateNo;
        Car car;
        Map.Entry<Keeper,Map.Entry<RegNo,Car>> entry;
        Month expiredDate = Month.JANUARY; // variable which is being used Month class
        System.out.println("Tax is about to expire at the end of " + expiredDate + " for :");
        while (iterator.hasNext()){

            entry = (Map.Entry<Keeper,Map.Entry<RegNo,Car>>)iterator.next();
            keeper = entry.getKey();
            plateNo = entry.getValue().getKey();
            car = entry.getValue().getValue();
            if(car.getTaxExpiresEndMonth() == expiredDate ){
                System.out.println(plateNo + "" + car + "" + keeper);
            }
        }
    }

    /**
     *   Method used to display users with overdue tax. it being used iterator as previous one .
     */
    public void warningLetter(){
        Iterator<Map.Entry<Keeper, Map.Entry<RegNo, Car>>> iterator = info.entrySet().iterator();

        Keeper keeper;
        RegNo plateNo;
        Car car;
        Map.Entry<Keeper,Map.Entry<RegNo,Car>> entry;
        Month expiredDate = Month.DECEMBER;
        System.out.println("Tax has been expired on " + expiredDate + " for :");
        while (iterator.hasNext()){

            entry = (Map.Entry<Keeper,Map.Entry<RegNo,Car>>)iterator.next();
            keeper = entry.getKey();
            plateNo = entry.getValue().getKey();
            car = entry.getValue().getValue();

            if(car.getTaxExpiresEndMonth() == expiredDate ){
                System.out.println(plateNo + "" + car + "" + keeper);
            }
        }
    }


    /**
     * Method used to write data into a file for all users with remaining tax which is to the end of the month. It is being used iterator as an entry.
     */
    public void writeRemainingLetterData() {

        Iterator<Map.Entry<Keeper, Map.Entry<RegNo, Car>>> iterator = info.entrySet().iterator();

        Keeper keeper;
        RegNo plateNo;
        Car car;
        Map.Entry<Keeper, Map.Entry<RegNo, Car>> entry;
        Month expiredDate = Month.JANUARY;
        int count =0; // variable used to count objects
        while (iterator.hasNext()) {

            entry = (Map.Entry<Keeper, Map.Entry<RegNo, Car>>) iterator.next();
            keeper = entry.getKey();
            plateNo = entry.getValue().getKey();
            car = entry.getValue().getValue();

            if (car.getTaxExpiresEndMonth() == expiredDate) {
                count ++; // incrementation
                try {
                    String file1 = plateNo + "" + car + "" + keeper; // casting content of the objects to String in order to write into a file
                    FileOutputStream fos = new FileOutputStream("D:\\\\JavaProjects\\\\SWE4102\\\\DSAworkspace\\\\File\\\\remainderLetter.txt");// I used my C drive, you can change your location
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(file1);
                    oos.close();
                    System.out.println(count + " object has been written int a file.");

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * Method used to write data into a file for all users with overdue tax which is to the end of the month. It is being used iterator as an entry.
     */
    public void writeWarningLetterData() {

        Iterator<Map.Entry<Keeper, Map.Entry<RegNo, Car>>> iterator = info.entrySet().iterator();

        Keeper keeper;
        RegNo plateNo;
        Car car;
        Map.Entry<Keeper, Map.Entry<RegNo, Car>> entry;
        Month expiredDate = Month.DECEMBER;
        int count = 0; // variable to count objects
        while (iterator.hasNext()) {

            entry = (Map.Entry<Keeper, Map.Entry<RegNo, Car>>) iterator.next();
            keeper = entry.getKey();
            plateNo = entry.getValue().getKey();
            car = entry.getValue().getValue();

            if (car.getTaxExpiresEndMonth() == expiredDate) {
                count ++; // incrementation
                if (car.getTaxExpiresEndMonth() == expiredDate) {
                    try {
                        String file1 = plateNo + "" + car + "" + keeper; // casting content of the objects to String in order to write into a file
                        FileOutputStream fos = new FileOutputStream("D:\\\\JavaProjects\\\\SWE4102\\\\DSAworkspace\\\\File\\\\warningLetter.txt");// I used my C drive, you can change your location
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(file1);
                        oos.close();
                        System.out.println(count + " object has been written into a file.");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    /**
     * Method used to read data from a file for all users with remaining tax which is to the end of the month. It is being used iterator as an entry.
     */
    public void readRemainingLetterData()  {

        Iterator<Map.Entry<Keeper, Map.Entry<RegNo, Car>>> iterator = info.entrySet().iterator();

        Keeper keeper;
        RegNo plateNo;
        Car car;
        Map.Entry<Keeper,Map.Entry<RegNo,Car>> entry;
        Month expiredDate = Month.JANUARY;
        while (iterator.hasNext()){

            entry = (Map.Entry<Keeper,Map.Entry<RegNo,Car>>)iterator.next();
            keeper = entry.getKey();
            plateNo = entry.getValue().getKey();
            car = entry.getValue().getValue();

            if(car.getTaxExpiresEndMonth() == expiredDate ){
                try {
                    FileInputStream fis = new FileInputStream("D:\\JavaProjects\\SWE4102\\DSAworkspace\\File\\remainderLetter.txt");// Choose your own path and file.
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    String f1 = (String) ois.readObject(); // cast content of a file into String
                    ois.close();
                    System.out.println(f1);// File overrides toString
                } catch (Exception FileNotFoundException) { // FileNotFoundException in case if a file would be deleted before it will have read.
                    System.out.println("No such a file.");
                }
            }
        }

    }

    /**
     * Method used to read data from a file for all users with overdue tax which is to the end of the month. It is being used iterator as an entry.
     */
    public void readWarningLetterData()  {

        Iterator<Map.Entry<Keeper, Map.Entry<RegNo, Car>>> iterator = info.entrySet().iterator();

        Keeper keeper;
        RegNo plateNo;
        Car car;
        Map.Entry<Keeper,Map.Entry<RegNo,Car>> entry;
        Month expiredDate = Month.DECEMBER;
        while (iterator.hasNext()){

            entry = (Map.Entry<Keeper,Map.Entry<RegNo,Car>>)iterator.next();
            keeper = entry.getKey();
            plateNo = entry.getValue().getKey();
            car = entry.getValue().getValue();

            if(car.getTaxExpiresEndMonth() == expiredDate ){
                try {
                    FileInputStream fis = new FileInputStream("D:\\JavaProjects\\SWE4102\\DSAworkspace\\File\\warningLetter.txt");// Choose your own path and file.
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    String f1 = (String) ois.readObject();// cast content of a file into String
                    ois.close();

                    System.out.println( f1);// File overrides toString
                } catch (Exception FileNotFoundException) { // FileNotFoundException in case if a file would be deleted before it will have read.
                    System.out.println("No such a file.");
                }
            }
        }
    }

    /**
     * Method used to delete a file from the C or M drive
     */
    public void deleteRemainingFile(){
        File remainderLetter = new File("D:\\JavaProjects\\SWE4102\\DSAworkspace\\File\\remainderLetter.txt");//location of your file
        if(remainderLetter.delete()){
            System.out.println(remainderLetter + " has been deleted");
        }else{
            System.out.println(remainderLetter + " could not be deleted.");
        }
    }

    /**
     * Method used to delete a file from the C or M drive
     */
    public void deleteWarningFile(){
        File warningLetter = new File("D:\\JavaProjects\\SWE4102\\DSAworkspace\\File\\warningLetter.txt");//location of your file
        if(warningLetter.delete()){
            System.out.println(warningLetter + " has been deleted");
        }else{
            System.out.println(warningLetter + " could not be deleted.");
        }
    }
}
