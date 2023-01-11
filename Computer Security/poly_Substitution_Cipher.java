package ComputerSecurity;

import java.util.Scanner;

public class poly_Substitution_Cipher {
    private static String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static int index = 0 ;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String msg;
        String key;
        System.out.println("Enter the message : ");
        msg = input.nextLine();
        System.out.println("Enter the key : ");
        key = input.nextLine();

        System.out.println("Encrypt Text : " + encrypt(msg , key));
    }

    public static String encrypt(String msg, String key) {

        String encrypted_msg = "";
        msg = delete_spaces(msg);
        System.out.println("plain Text : " + msg);
        String[] words = split_msg(msg , key) ;

        for (int i = 0; i <= index; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                encrypted_msg += encrypt_char( w.charAt(j) , key.charAt(j));
            }
        }

        return encrypted_msg;
    }

    public static char encrypt_char(char ch, char key) {
        char encrypted_char ;
        String shifted ="";
        if(key >= 97 && key <= 122 )
            key -= 32;

        for (int i = key-65; i != key - 66; ) {
            shifted += alphabets.charAt(i);
            i = (i + 1) % 26;
        }
        shifted += alphabets.charAt(key - 66);

        if(ch >= 97 && ch <= 122 )
            ch -= 32;

        int index = ch-65;
        if(index >= 0 && index < 26 )
            return shifted.charAt(index);
        else
             return ch;
    }

    public static String[] split_msg (String msg , String key ){

        String[] words = new String[25];
        for (int i = 0; i < 25; i++) {
            words [i] = "";
        }

        for (int i = 0,j=0; i < msg.length();i++,j++) {
            if(j < key.length()){
                words[index] += msg.charAt(i);
            }
            else{
                j=0;
                index++;
                words[index] += msg.charAt(i);

            }
        }

        return words;
    }

    public static String delete_spaces(String msg){
        String m ="";
        for (int i = 0; i < msg.length(); i++) {
            if(msg.charAt(i) != ' '){
                m +=msg.charAt(i);
            }
        }
        return m ;
    }

    public static void test (String msg , String key) {

        msg = delete_spaces(msg);
        String[] words = split_msg(msg , key) ;

        System.out.println(index+1);
        for (int i = 0; i <= index; i++) {
            System.out.println(words[i]);
        }

    }


}
