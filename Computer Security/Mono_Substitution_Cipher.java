package ComputerSecurity;

import java.util.Scanner;

public class Mono_Substitution_Cipher {

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
            int index = upper_msg.charAt(i)-65;
            if(index >=0 && index <26)
                encrypted_msg += shifted.charAt(index);
            else
                encrypted_msg +=upper_msg.charAt(i);
        }

        return encrypted_msg;
    }

    public static String encrypt(String msg, char key) {
        String encrypted_msg = "";
        for (int i = key-65; i != key - 66; ) {
            shifted += alphabets.charAt(i);
            i = (i + 1) % 26;
        }
        shifted += alphabets.charAt(key - 66);

        String upper_msg = msg.toUpperCase();
        System.out.println(upper_msg);
        for (int i = 0; i < upper_msg.length(); i++) {
            int index = upper_msg.charAt(i)-65;
            if(index >=0 && index <26)
                encrypted_msg += shifted.charAt(index);
            else
                encrypted_msg +=upper_msg.charAt(i);
        }

        return encrypted_msg;
    }

}
