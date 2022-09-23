package atmmachine;

import java.io.IOException;

public class AtmMachine {
    public static void main(String[] args) throws IOException {
        AtmManagement atm=new AtmManagement();
        atm.pinVerification();
        atm.selectOptions();
    }
}
