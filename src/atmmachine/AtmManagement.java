package atmmachine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AtmManagement {
    Log log =new Log();
    int pin = 2332;
    int p;
    int count;
    int op;
    double wd;
    double depo;
    String yn;
    UserAccount uact=new UserAccount(897658943,50000);
    Scanner sc = new Scanner(System.in);

    public void pinVerification() throws IOException {
        System.out.println("Enter Your Four Digit PIN:");
        p = sc.nextInt();

            if (pin == p) {
                log.login();
                System.out.println("PIN Verified.");
                System.out.println();
                System.out.println("Welcome..");
                System.out.println();
            } else {
                log.loginFail();
                System.out.println("PIN Incorrect.Try Again!");
                count++;
                if (count == 3) {
                    System.out.println("PIN limit Maximum");
                } else {
                    System.exit(0);
                }
            }

    }
    public void selectOptions() throws IOException {
        System.out.println(" Options:");
        System.out.println();
        System.out.println("Press 1 For Withdraw.");
        System.out.println();
        System.out.println("Press 2 For Deposit.");
        System.out.println();
        System.out.println("Press 3 For Balance.");
        System.out.println();
        System.out.println("Press 4 For Exit.");
        System.out.println();
        System.out.println("Please Select an Option:");
         op = sc.nextInt();
        if (op == 1) {
            forWithdraw();
        } else if (op==2) {
            forDeposit();
        } else if (op==3) {
            forBalance();
        }else if (op==4){
            log.logout();
            System.out.println("Transaction cancelled..");
            System.exit(0);
        }else {
            System.out.println("Invalid Option");
            System.out.println();
            selectOptions();
        }
    }
    public void forWithdraw() throws IOException {
        System.out.println("Enter the amount to Withdraw:");
        System.out.println();
         wd = sc.nextDouble();
        if (wd <= uact.balance){
            uact.balance=uact.balance-wd;
            System.out.println("Your current balance is "+uact.balance);
            withdrawLog();
            System.out.println();
            message();
        }else {
            System.out.println("Insufficiant Fund.");
            System.out.println();
            message();
        }
    }
    public void withdrawLog(){
        File file = new File("C://Users/sakth/Documents/javaproject/atmlog.txt");
        double oldbalance=uact.balance+ wd;
        String text = "Existing balance "+oldbalance+" Available balance "+uact.balance;
        try {
            FileWriter fwrtr = new FileWriter(file, true);
            fwrtr.write(text);
            fwrtr.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void forDeposit() throws IOException {
        System.out.println("Enter the amount to deposit:");
        System.out.println();
        depo = sc.nextDouble();
        uact.balance=uact.balance+depo;
        System.out.println();
        System.out.println("Your current balance: "+uact.balance);
        depositLog();
        System.out.println();
        message();
    }
    public void depositLog(){
        File file = new File("C://Users/sakth/Documents/javaproject/atmlog.txt");
        double oldbalance= uact.balance- depo;
        String text = "Existing balance "+oldbalance+" Available balance "+uact.balance;
        try {
            FileWriter fwrtr = new FileWriter(file, true);
            fwrtr.write(text);
            fwrtr.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public void forBalance() throws IOException {
        System.out.println("Your current Balance:");
        System.out.println();
        System.out.println(uact.balance);
        System.out.println();
        message();
    }
    public void message() throws IOException {
        System.out.println("Do you like another transaction:");
        System.out.println();
        System.out.println("press y for yes");
        System.out.println();
        System.out.println("press N for no");
        yn = sc.next();
        if (yn.equalsIgnoreCase("y")){
            selectOptions();
        }else {
            log.logout();
            System.out.println("Your Transaction cancelled..");
            System.out.println();
            System.out.println("Thankyou..");
        }
    }
}
