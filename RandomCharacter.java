import java.util.Scanner;

public class RandomCharacter {

    public static char getRandomChar(char startChar, char endChar) {
        return (char) (startChar + Math.random() * (endChar - startChar  + 1));
    }

    public static char getRandomLowerChar() {
        return getRandomChar('a', 'z');
    }

    public static char getRandomUpperChar() {
        return getRandomChar('A', 'Z');
    }

    public static char getRandomDigitChar() {
        return getRandomChar('0', '9');
    }

    public static char getRandomChar() {
        return getRandomChar('\u0000', '\uFFFF');
    }
}

class Main {
    private static Scanner input =new Scanner(System.in);
    public static void main(String args[]) {
        String flag ;
        while (true){
            System.out.println("Do you want to leave?");
            System.out.println("Enter Yes or No.");
            flag =input.next();
            if (flag.equals("Yes")) {
                System.out.println("**** GOODBYE ^_^ ****");
                break;
            }else{
                RandomFunc();
            }
        }

    }
    public static void RandomFunc(){
        final int NUM_OF_CHARS ;
        System.out.println("Enter number of char : ");
        NUM_OF_CHARS = input.nextInt();
        final int CHARS_PER_LINE ;
        System.out.println("Enter number of char in one line : ");
        CHARS_PER_LINE = input.nextInt();

        for (int i = 0; i<NUM_OF_CHARS; i++){
            char ch = RandomCharacter.getRandomLowerChar();
            if((i+1)%CHARS_PER_LINE == 0)
                System.out.println(ch);
            else
                System.out.print(ch);
        }
        System.out.println();
        System.out.println("***********************************");
    }
}
