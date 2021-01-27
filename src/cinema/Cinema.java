package cinema;

import java.util.Scanner;
public class Cinema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cinema:");
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();

        int number = 1;
        System.out.print(" ");

        for (int i = 0; i < seats; i++) {
            System.out.print(number + " ");
            number++;
        }

        number = 1;
        System.out.println();
        for (int j = 1; j < rows; j++) {
            System.out.print(number + " ");
            for (int k = 0; k < seats; k++) {
                System.out.print("S" + " ");
            }
            System.out.println();
            number++;
        }
    }
}












































