package conveniencecard;

import java.util.Scanner;

public class TestView {

    public static void main(String[] args) {
        CardManager cm = new CardManager();
//        Card c = new Card();
        Scanner input = new Scanner(System.in);
        int choices;
        int id;
        double points;

        do {
            System.out.print(
                    "-- Main Manu --\n"
                    + "Please Input Number \n"        
                    + "1. Register Now \n"
                    + "2. Top Up Money \n"
                    + "3. Payment \n"
                    + "4. Change Point To Money \n"        
                    + "0. Exit \n "        
                    + "Enter Your Menu [1-4]:");
            choices = input.nextInt();
            switch (choices) {
                case 0: break;
                case 1:
                    System.out.print("Input Member Firstname :");
                    String firstname = input.next();
                    System.out.print("Input Member Lastname :");
                    String lastname = input.next();
                    System.out.print("Input Member ID :");
                    int ID = input.nextInt();
                    if (!cm.registCard(firstname, lastname, ID)){
                        System.out.println("Register Unsuccesfully!!");
                        System.out.println("Card is full.");
                        break;
                    }
                    System.out.println("Register Finish!");
                    System.out.println(cm.getMember()[cm.getCount()-1].getFirstName());
                    System.out.println(cm.getMember()[cm.getCount()-1].getLastName());
                    System.out.println(cm.getMember()[cm.getCount()-1].getMemberID());break;
                case 2:
                    System.out.println("Input Member ID :");
                    id = input.nextInt();
                    cm.checkID(id);
                    System.out.println("Amount to Top Up : ");
                    double money = input.nextDouble();
                    cm.topUpMoney(id,money);
                    System.out.println("New Balance : " + cm.getCardBalance(id));
                    break;
                case 3:
                    System.out.println("Input Member ID :");
                    id = input.nextInt();
                    cm.checkID(id);
                    System.out.println("Past Balance : " + cm.getCardBalance(id));
                    System.out.println("Input Price : ");
                    double price = input.nextDouble();
                    cm.payWith(id,price);
                    System.out.println("New Balance : " + cm.getCardBalance(id));
//                    System.out.println("Past Points: " + cm.getCardPoints(id) - points);                    
                    System.out.println("New Points: " + cm.getCardPoints(id));
                    break;
                case 4:
                    System.out.println("Input Member ID :");
                    id = input.nextInt();
                    cm.checkID(id);
                    System.out.println("Member Points :" + cm.getCardPoints(id));
                    System.out.println("Amount to Exchange : ");
                    points = input.nextDouble();
                    cm.pointToMoney(id,points);                   
                    System.out.println("Past Points : " + (cm.getCardPoints(id) + points));                    
                    System.out.println("New Points : " + cm.getCardPoints(id));                    
                    System.out.println("New Balance : " + cm.getCardBalance(id));
                    break;
            }
            

        } while (choices != 0);
    }

}
