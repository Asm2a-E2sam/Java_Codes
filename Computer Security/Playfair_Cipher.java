package ComputerSecurity;

import java.util.Scanner;

public class Playfair_Cipher {
    private static String alphabets = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String msg;
        String key;
        System.out.println("Enter the message : ");
        msg = input.nextLine();
        System.out.println("Enter the key : ");
        key = input.nextLine();


    }

    public static char[][] generate_key (String key){
        char [][] key_matrix = new char[5][5];
        key = key.toUpperCase();
        String k = "";
        k += key.charAt(0);
        for (int i = 1; i < key.length(); i++) {
            boolean flag = false ;
            for (int j = 0; j < i ; j++) {
                if(key.charAt(j) == key.charAt(i)){
                    flag =true;
                }
            }
            if (flag == false)
                k += key.charAt(i);
        }

        int indx = k.length();
        for (int i = 0; i < alphabets.length(); i++) {
            boolean flag = false ;
            for (int j = 0; j < indx ; j++) {
                if(k.charAt(j) == alphabets.charAt(i)){
                    flag =true;
                }
            }
            if (flag == false)
                k += alphabets.charAt(i);
        }

        int x =0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                key_matrix[i][j] = k.charAt(x);
                x++;
            }
         }
         return key_matrix;
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
