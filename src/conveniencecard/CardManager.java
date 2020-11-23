package conveniencecard;

public class CardManager {

//    Scanner input = new Scanner(System.in);
    Card member[] = new Card[100];
    int count = 0;

    public boolean registCard(String firstname, String lastname, int ID) {
        if (isFull()) {
            return false;
        }
        
        this.member[count++] = new Card(firstname, lastname, ID);
        return true;
    }

    public double getCardBalance(int id) {
        for (int i = 0; i < count; i++) {
            if (checkID(id) != -1 && checkID(id) == member[i].getMemberID()) {

                return member[i].getBalance();
            }
        }
        return 0;
    }

    public double getCardPoints(int id) {
        for (int i = 0; i < count; i++) {
            if (checkID(id) != -1 && checkID(id) == member[i].getMemberID()) {
                return member[i].getPoints();
            }
        }
        return 0;
    }

    public int getCount() {
        return count;
    }

    public Card[] getMember() {
        return member;
    }

    public boolean isFull() {
        return count == member.length;
    }

    public int checkID(int id) {
//        int id = input.nextInt();
        for (int i = 0; i <= count; i++) {
            if (id == member[i].getMemberID()) {
                return id;
            }
        }
        return -1;
    }

    //Can't be nagative
    public boolean topUpMoney(int id, double money) {

        for (int i = 0; i <= count; i++) {
            if (checkID(id) != -1 && checkID(id) == member[i].getMemberID()) {
                if (money > 0) {
                    double newMoney = member[i].getBalance() + money;
                    member[i].setBalance(newMoney);
                    return true;
                }

            }
        }
        return false;
    }

    public boolean payWith(int id, double price) {
        for (int i = 0; i < count; i++) {
            if (checkID(id) != -1 && checkID(id) == member[i].getMemberID()) {
                if (price > 0 && member[i].getBalance() > 0 && price <= member[i].getBalance()) {
                    double newMoney = member[i].getBalance() - price;
                    member[i].setBalance(newMoney);
                    addPoint(member[i], price);
               }
            }

        }
        return false;
    }

    public void addPoint(Card c, double price) {

        double calPoints = Math.floor(price / 50);
        double newPoints = calPoints + c.getPoints();
        c.setPoints(newPoints);

    }

    public boolean pointToMoney(int id, double points) {
        for (int i = 0; i <= count; i++) {
            if (checkID(id) != -1 && checkID(id) == member[i].getMemberID()) {
                if (member[i].getPoints() >= points) {
                    double remainPoints = member[i].getPoints() - points;
                    member[i].setPoints(remainPoints);
                    member[i].setBalance(points + member[i].getBalance());
                    return true;
                }

            }
        }
        return false;
    }
}
