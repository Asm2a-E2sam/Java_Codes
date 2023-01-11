
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class mulicast {
    public static void main(String[] args) {
        System.out.println("Multicast Time Server ");
        DatagramSocket serveSocket = null ;

        try {
            serveSocket = new DatagramSocket();
            while (true){
                String dateText = new Date().toString();

                byte[] buffer = new byte[256];
                buffer = dateText.getBytes();
                InetAddress group = InetAddress.getByName("224.0.0.0");
                DatagramPacket packet = new DatagramPacket(buffer , buffer.length , group , 8888);
                serveSocket.send(packet);
                System.out.println("Time sent :" + dateText);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }

        }catch(IOException ex ){
            ex.printStackTrace();
            System.exit(1);
        }

    }
}
