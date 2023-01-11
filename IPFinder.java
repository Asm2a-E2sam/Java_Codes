import java.net.*;
import java.util.*;

public class IPFinder
{
    /*public static void main (String[] args) throws UnknownHostException {
        String host ="www.facebook.com";
        InetAddress address = InetAddress.getByName(host);
        System.out.println("IP Address : "+ address.toString());
    }*/
    public static void main (String[] args){
        try{
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("IP Address : "+address.toString());
        }catch(UnknownHostException ex){
            ex.printStackTrace();
        }
    }
}
