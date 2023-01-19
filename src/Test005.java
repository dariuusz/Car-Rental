import java.time.Month;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * This is Test005 class that implements all functionalities regardles to warning and remaining letters. It also delete files and search for overdue and remaining tax.
 * It implements CreatingObjects interface to avoid creating objects multiple times.
 * @author Dariusz Jedrzejek 2012523
 */
public class Test005 implements CreatingObjects{

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Car car1 = new Car("Toyota", "Yaris", "Black", Month.DECEMBER);
        Car car2 = new Car("Ford", "Focus", "Silver",Month.JANUARY);
        Car car3 = new Car("Audi", "Q7", "Blue", Month.JANUARY);
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

        boolean quit = false;
        int choice =0;
        printInstructions();
        while(!quit) {

            System.out.println("\nEnter your choice : \t");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    dvla.reminderLetter();
                    break;
                case 2:
                    dvla.warningLetter();
                    break;
                case 3:
                    dvla.writeRemainingLetterData();
                    break;
                case 4:
                    dvla.writeWarningLetterData();
                    break;
                case 5:
                    dvla.readRemainingLetterData();
                    break;
                case 6:
                    dvla.readWarningLetterData();
                    break;
                case 7:
                    dvla.deleteRemainingFile();
                    break;
                case 8:
                    dvla.deleteWarningFile();
                    break;
                case 9:
                    quit = true;
                    scanner.close();
                    break;
            }
        }
    }

    public static void printInstructions(){
        System.out.println("\n1. Return all users whose tax will be expired at the end of the month: \n"
                + "2. Return all users whose tax has been expired : \n"
                + "3. Write file for all users whose tax will be expired at the end of the month: \n"
                + "4. Write file for all users whose tax has been expired : \n"
                + "5. Read a content of the remaining file : \n"
                + "6. Read a content of warning letter: \n"
                + "7. Delete remaining letter : \n"
                + "8. Delete warning letter: \n"
                + "9. Exit:" );
    }



}
