package cryptography;
import java.util.Scanner;

public class cipher {
    private static String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String shifted = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String msg;
        int key;
        System.out.println("Enter the message : ");
        msg = input.nextLine();
        System.out.println("Enter the key : ");
        key = input.nextInt();

        String en_msg = encrypt(msg, key);
        System.out.println(en_msg);

    }

    public static String encrypt(String msg, int key) {
        String encrypted_msg = "";
        for (int i = key; i != key - 1; ) {
            shifted += alphabets.charAt(i);
            i = (i + 1) % 26;
        }
        shifted += alphabets.charAt(key - 1);

        String upper_msg = msg.toUpperCase();
        System.out.println(upper_msg);
        for (int i = 0; i < upper_msg.length(); i++) {
            int index = msg.charAt(i);
            if(index >=65 && index < 91)
                encrypted_msg += (msg.charAt(i)+key)%65;
            else if(index >=97 && index < 91)
                encrypted_msg +=(msg.charAt(i));
        }

        return encrypted_msg;
    }


}

