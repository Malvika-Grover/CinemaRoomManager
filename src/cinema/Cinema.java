package cinema;

import java.util.Scanner;
public class Cinema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();

        System.out.println("Cinema:");
        int number = 1;
        System.out.print(" ");

        for (int i = 0; i < seats; i++) {
            System.out.print(number + " ");
            number++;
        }

        number = 1;
        System.out.println();
        for (int j = 0; j < rows; j++) {
            System.out.print(number + " ");
            for (int k = 0; k < seats; k++) {
                System.out.print("S" + " ");
            }
            System.out.println();
            number++;
        }
        number = 1;

        System.out.println();
        System.out.println("Enter a row number:");
        int chosenRow = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int chosenSeat = sc.nextInt();

        int price;

        int totalSeats = rows * seats;
        if (totalSeats < 60) {
            price = 10;
            System.out.print("Ticket price: ");
            System.out.println("$" + price);

        } else if (totalSeats > 60) {
            int frontRow = rows / 2;
            if (chosenRow > frontRow) {
                price = 8;
                System.out.print("Ticket price: ");
                System.out.println("$" + price);

            } else {
                price = 10;
                System.out.print("Ticket price:  ");
                System.out.println("$" + price);
            }
        }
        System.out.println();
        System.out.println("Cinema:");

        int[][] total = new int[chosenRow][chosenSeat];

        System.out.print(" ");

        for (int i = 0; i < seats; i++) {
            System.out.print(number + " ");
            number++;
        }

        number = 1;
        System.out.println();
        for (int i = 1; i <=rows; i++) {
            System.out.print(number + " ");

            for (int j = 1; j <= seats; j++) {


                if (i < chosenRow && i > chosenRow && j < chosenSeat && j > chosenSeat) {
                    System.out.print("S"+" ");
                }
                if (i == chosenRow && j == chosenSeat) {
                    System.out.print("B"+" ");
                } else {
                    System.out.print("S"+" ");
                }
            }
            System.out.println();
            number++;
        }
        number=1;
    }
}
