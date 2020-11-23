
package conveniencecard;

public class Card {

    private String firstName;
    private String lastName;
    private int memberID;
    private double points = 0;
    private double balance = 0;

    public Card() {
        
    }

    public Card(String firstName, String lastName, int memberID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberID = memberID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMemberID() {
        return memberID;
    }

    public double getBalance() {
        return balance;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public double getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Card{" + "firstName=" + firstName + ", lastName=" + lastName + ", memberID=" + memberID + ", points=" + points + ", balance=" + balance + '}';
    }


}

