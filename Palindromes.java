import java.util.Scanner;

public class Palindromes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = "";

        while (true){
            System.out.println("\n***************************************");
            System.out.println("Enter \"CLOSE\" if you want to leave...");
            System.out.println("***************************************");

            System.out.println("Enter a String: ");
            str = input.nextLine();
            if (str.equals("CLOSE")) {
                System.out.println("**** GOODBYE ^_^ ****");
                break;
            }
            boolean flag =true;
            int size = str.length();

            for (int i = 0; i < size/2; i++) {
                if (str.charAt(i) != str.charAt(size-(i+1))) {
                    flag = false;
                }
            }

            if (flag) {
                System.out.println(str + " is a Palindromes");
            }else {
                System.out.println(str + " is not a Palindromes");
            }

        }

    }
}
