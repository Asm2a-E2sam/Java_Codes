
import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;
import java.util.Scanner;

public class URL_Connection {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter URL : ");
        String url = input.nextLine();
        accessWebsite(url);

    }
    private static void accessWebsite(String url){
        BufferedReader br = null;
        try {

            URL my_url = new URL(url);
            URLConnection urlConnection = my_url.openConnection();
            InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
            br = new BufferedReader(isr);

            String line ;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

        }catch( IOException ex){
            System.out.println("Can't access URL ");
            System.exit(1);

        }finally {
            System.out.println("Closing connection ");
            try {
                br.close();
                System.exit(1);

            }catch (IOException e ){
                e.printStackTrace();
            }
        }

    }
}
