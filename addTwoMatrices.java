import java.util.Scanner;

public class addTwoMatrices {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int row , column;
        System.out.println("Enter number of Row : ");
        row = input.nextInt();
        System.out.println("Enter number of Column : ");
        column = input.nextInt();
        System.out.println("Enter Matrix 1 : ");
        int [][] m1 = storeMatrix(row, column);
        System.out.println("Enter Matrix 2 : ");
        int [][] m2 = storeMatrix(row, column);
        int [][] sum = addMatrices(m1 , m2, row, column);
        System.out.println("Sum of two equals : ");
        printMatrix(sum , row , column);

    }

    public static int[][] storeMatrix(int row , int column ){
        int [][] matix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matix[i][j]= input.nextInt();
            }
        }
        return matix;
    }

    public static int[][] addMatrices(int[][] m1 , int[][] m2 ,int row , int column ){
        int [][] sum = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sum[i][j]= m1[i][j] + m2[i][j];
            }
        }
        return sum;
    }

    public static void printMatrix(int[][] matrix, int row ,int column){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
