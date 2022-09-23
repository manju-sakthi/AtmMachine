package atmmachine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Log {

    public void login() throws IOException {
        File file = new File("C://Users/sakth/Documents/javaproject/atmlog.txt");
        String text = "Transaction begins here";
        try {
            FileWriter fwrtr = new FileWriter(file, true);
            fwrtr.write(text);
            fwrtr.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void loginFail(){
        File file = new File("C://Users/sakth/Documents/javaproject/atmlog.txt");
        String text = "login failed.";
        try {
            FileWriter fwrtr = new FileWriter(file, true);
            fwrtr.write(text);
            fwrtr.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void logout(){
        File file = new File("C://Users/sakth/Documents/javaproject/atmlog.txt");
        String text = "Transaction Ends";
        try {
            FileWriter fwrtr = new FileWriter(file, true);
            fwrtr.write(text);
            fwrtr.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}