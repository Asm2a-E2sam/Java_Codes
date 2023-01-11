package ComputerSecurity;

import java.util.Scanner;

public class TranspositionCipher {
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

        System.out.println(encrypt(msg , key));

    }

    public static String encrypt (String msg , String key){
        String encrypted_msg = "";
        msg = delete_spaces(msg);
        String [] words = split_msg(msg , key);

        for (int i = 0; i <= index; i++) {
            String w = "";

            for (int j = 0; j < words[i].length(); j++) {
                int indx = key.charAt(j) -'0';
                w += words[i].charAt(indx-1);
            }
            encrypted_msg += w;
        }

        return encrypted_msg ;
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


}
