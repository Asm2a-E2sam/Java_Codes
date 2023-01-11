package section2_NP_TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPEchoServer {
    private static ServerSocket serverSocket;
    private static final int port = 1234;

    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Open port Successfully");
        } catch (IOException ex) {
            System.out.println(ex);
            System.exit(1);
        }

        do {
            handleConnection();
        } while (true);
    }
    private static void handleConnection(){
        Socket link = null ;
        try{
            link = serverSocket.accept();
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter out = new PrintWriter(link.getOutputStream() , true);

            int num_msg = 0 ;
            String msg = input.nextLine();
            while (!msg.equals("***CLOSE***")){
                System.out.println("Message Received ^_^ ");
                num_msg++;
                out.println("Message "+ num_msg + " : "+ msg);
                msg = input.nextLine();
            }
            out.println(num_msg + " Received ");
        }catch(IOException ex){
            System.out.println("Failed to receive a connection !!!! ");
            //System.exit(1);
        }finally {
            try {
                link.close();
            } catch (IOException ec) {
                System.out.println(ec);
                System.exit(1);
            }
        }
    }
}
