package section2_NP_TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPEchoClient {
    private static InetAddress host;
    private static final int port = 1234;

    public static void main(String[] args) {
        try{
            host = InetAddress.getLocalHost();

        }catch(IOException ex){
            System.out.println("Host ID not found !!!");
            System.exit(1);
        }
        accessServer();
    }

    private static void accessServer() {
        Socket link = null;

        try{
            link = new Socket(host, port);
            Scanner input = new Scanner(link.getInputStream());
            // printWriter takes two parameters
            PrintWriter out = new PrintWriter(link.getOutputStream() , true);

            Scanner userInput = new Scanner(System.in);
            String msg , respond ;

            do {
                System.out.println("Enter Message : ");
                msg = userInput.nextLine();
                out.println(msg);
                respond = input.nextLine();
                System.out.println("SERVER > " + respond);

            }while(!msg.equals("***CLOSE***"));
        }catch(IOException ex){
            System.out.println(ex);
            //System.exit(1);
        }finally {
            try {
                System.out.println("CLOSING CONNECTION ...");
                link.close();
            } catch (IOException ec) {
                System.out.println("Unable to disconnect ");
                System.exit(1);
            }
        }
    }

}
