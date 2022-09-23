package atmmachine;

public class AtmMachine {
    public static void main(String[] args) {
        AtmManagement atm=new AtmManagement();
        atm.pinVerification();
        atm.selectOptions();
    }
}
