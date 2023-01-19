import java.util.Objects;

/**
 * This is a RegNo class to add a plate number to a Car's object
 * @author Dariusz Jedrzejek 2012523
 */

public class RegNo implements Comparable <RegNo> {

    private final String regNo;


    /**
     * The constructor with 1 parameter
     * @param regNo regNo
     */
    public RegNo(String regNo) {
        this.regNo = regNo;
    }

    /**
     * Getter for plate number to use in DVLA class
     * @return regNo
     */
    public String getRegNo() {
        return regNo;
    }

//    public int getInc() {
//        return inc;
//    }

    /**
     * Ovveriden equal method which is used after hashCode's method. When the hasCode is existed in the list collection HashMap will invoke equal method to double check if they are the same.Reg
     * @param o Object
     * @return 0 if they are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegNo regNo1 = (RegNo) o;
        return regNo.equals(regNo1.regNo);
    }

    /**
     * Overriden method to sort the list by its plate' numbers
     * @param n RegNo
     * @return 0 if they are the same
     */
    @Override
    public int compareTo(RegNo n){
        if(n == null){
            return -1;
        }else{
            return regNo.compareTo(n.regNo);
        }
    }

    /**
     * Overriden method which is used to check if similar object has already existed in the list while is being added to it. If the hash code is not existed the HashMap sets up
     * as new object and locates it in new place(container) inside th list.
     * @return hasCode
     */
    @Override
    public int hashCode() {
        if(regNo == null) return 0;

        else return regNo.hashCode();
    }

    /**
     * Overriden method used to describe a RegNo object
     * @return description of regNo
     */
    @Override
    public String toString() {
        return "Registration number : " +
                     regNo + '\t' ;
    }
}
