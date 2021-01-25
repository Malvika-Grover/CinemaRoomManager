package cinema;

import java.util.Scanner;
public class Cinema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cinema:");
        for (int i = 1; i < 9; i++) {
            System.out.print(" "+i);
        }
        System.out.println();
        for (int j = 1; j < 8; j++) {
            System.out.println(j+" S S S S S S S S");
        }
        int price = 0;
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();
        int totalSeats = rows*seats;
        if (totalSeats <= 60){
            price = totalSeats * 10;
            System.out.println("Total income:");
            System.out.println("$"+price);

        }else if (totalSeats > 60){
            int frontRows = rows/2;
            int price1 = seats * frontRows * 10;
            int price2 =  seats * (rows - frontRows) * 8;
            System.out.println("Total income:");
            System.out.println("$"+(price1+price2));
        }
    }
}