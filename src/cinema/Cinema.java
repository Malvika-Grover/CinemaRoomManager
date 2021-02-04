//package cinema;
//
//import java.util.Scanner;
//public class Cinema {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the number of rows:");
//        int rows = sc.nextInt();
//
//        System.out.println("Enter the number of seats in each row:");
//        int seats = sc.nextInt();
//
//        System.out.println("Cinema:");
//        int number = 1;
//        System.out.print(" ");
//
//        for (int i = 0; i < seats; i++) {
//            System.out.print(number + " ");
//            number++;
//        }
//
//        number = 1;
//        System.out.println();
//        for (int j = 0; j < rows; j++) {
//            System.out.print(number + " ");
//            for (int k = 0; k < seats; k++) {
//                System.out.print("S" + " ");
//            }
//            System.out.println();
//            number++;
//        }
//        number = 1;
//
//        System.out.println();
//        System.out.println("Enter a row number:");
//        int chosenRow = sc.nextInt();
//        System.out.println("Enter a seat number in that row:");
//        int chosenSeat = sc.nextInt();
//
//        int price;
//
//        int totalSeats = rows * seats;
//        if (totalSeats < 60) {
//            price = 10;
//            System.out.print("Ticket price: ");
//            System.out.println("$" + price);
//
//        } else if (totalSeats > 60) {
//            int frontRow = rows / 2;
//            if (chosenRow > frontRow) {
//                price = 8;
//                System.out.print("Ticket price: ");
//                System.out.println("$" + price);
//
//            } else {
//                price = 10;
//                System.out.print("Ticket price:  ");
//                System.out.println("$" + price);
//            }
//        }
//        System.out.println();
//
//
//
//        System.out.println("Cinema:");
//
//        int[][] total = new int[chosenRow][chosenSeat];
//
//        System.out.print(" ");
//
//        for (int i = 0; i < seats; i++) {
//            System.out.print(number + " ");
//            number++;
//        }
//
//        number = 1;
//        System.out.println();
//        for (int i = 1; i <=rows; i++) {
//            System.out.print(number + " ");
//
//            for (int j = 1; j <= seats; j++) {
//
//
//                if (i < chosenRow && i > chosenRow && j < chosenSeat && j > chosenSeat) {
//                    System.out.print("S"+" ");
//                }
//                if (i == chosenRow && j == chosenSeat) {
//                    System.out.print("B"+" ");
//                } else {
//                    System.out.print("S"+" ");
//                }
//            }
//            System.out.println();
//            number++;
//        }
//        number=1;
//    }
//}

//------------------------------------------------------------------------------------

package cinema;
import java.util.*;
public class Cinema {
    static int[][] array =new int[100][100];
    static int cost=0;

    static void display(int row,int seats)
    {
        System.out.println("\nCinema:");
        {
            System.out.print("  ");
            for (int i = 1; i <= seats; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }


            for(int i=0;i<row;i++)
            {
                System.out.print((i+1)+" ");
                for(int j=0;j<seats;j++)
                {
                    if (array[i][j]==1){
                        System.out.println("B ");
                    }
                    else {
                        System.out.print("S ");
                    }
                }
                System.out.println();
            }
    }
    static void buy(int row,int seats)
    {
        int totalSeats=row*seats;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a row number:");
        int chosenRows = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int chosenSeats = sc.nextInt();

        while(((chosenRows-1)>(row-1) || (chosenSeats-1)>(seats-1)) || array[chosenRows-1][chosenSeats-1]==1 )
        {
            if((chosenRows-1)>(row-1) || (chosenSeats-1)>(seats-1))
                System.out.println("Wrong input!");
            else
                System.out.println("That ticket has already been purchased!\n");
            System.out.println("Enter a row number:");
            chosenRows = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            chosenSeats = sc.nextInt();
        }

        if(totalSeats<=60) {

            System.out.println("\nTicket price: $" + (10));
            array[chosenRows-1][chosenSeats-1] = 1;
            cost+=10;
        }
        else
        {
            int frontRow=(row/2);

            if(chosenRows<=frontRow)
            {
                System.out.println("\nTicket price: $"+(10));
            cost+=10;
            }
            else
            {
                System.out.println("\nTicket price: $"+(8));
            cost+=8;
            }

            array[chosenRows-1][chosenSeats-1]=1;
        }
    }
    static void menu()
    {
        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
    }
    static void stats(int rows,int column) {
        int seats=0;
        int total;
        {
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < column; j++)
                    if (array[i][j] == 1)
                        seats++;
        }

        int totalSeats=rows*column;
        double percentage=(seats*100.00)/(totalSeats);

        if(totalSeats<=60) total=totalSeats*10;
        else {
            int price1=(rows/2)*column*10;
            int price2=(rows-(rows/2))*column*8;
            total=price1+price2;
        }


        System.out.println("Number of purchased tickets: "+seats);
        System.out.printf("Percentage: %.2f \n",percentage);
        System.out.printf("Current income: $%d\n" +
                "Total income: $%d\n\n",cost,total);

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int rows,column;
        System.out.println("Enter the number of rows:");
        rows=sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        column=sc.nextInt();

        while(true)
        {
            menu();
            int ch=sc.nextInt();
            if(ch==1)
                display(rows,column);
            else if(ch==2)
                buy(rows,column);
            else if(ch==3)
                stats(rows,column);
            else
                break;
        }
    }
}