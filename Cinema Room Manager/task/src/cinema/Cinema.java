package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the number of seats in each row:");
        int cols = Integer.parseInt(scanner.nextLine());
        Seats seats = new Seats(rows, cols);
        int currentIncome = 0;
        while (true) {
            int choice = displayMenu(scanner);
            switch (choice) {
                case 1 -> seats.displayCinema(rows, cols);
                case 2 -> {
                    boolean booked = false;
                    while (!booked) {
                        System.out.println("Enter a row number:");
                        int row = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter a seat number in that row:");
                        int col = Integer.parseInt(scanner.nextLine());
                        if (row >= 1 && col >= 1 && row <= rows && col <= cols) {
                            if (seats.checkSeat(row, col)) {
                                seats.markSeat(row, col);
                                int temp = returnTicketPrice(rows, cols, row);
                                System.out.println("Ticket price: $" + temp);
                                currentIncome += temp;
                                booked = true;
                            } else {
                                System.out.println("That ticket has already been purchased!");
                            }
                        } else {
                            System.out.println("Wrong input!");
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Number of purchased tickets: " + seats.purchased);
                    System.out.printf("Percentage: %.2f", (((float) seats.purchased / (rows * cols) * 100)));
                    System.out.println("%");
                    System.out.println("Current income: $" + currentIncome);
                    System.out.println("Total income: $" + returnTotalIncome(rows, cols));
                }
                case 0 -> {
                    return;
                }
            }
        }
    }


    public static int displayMenu(Scanner scanner) {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int returnTicketPrice(int rows, int cols, int row) {
        if (rows * cols <= 60) {
            return 10;
        } else {
            int firstHalf = rows / 2;
            if (row <= firstHalf) {
                return 10;
            } else {
                return 8;
            }
        }
    }

    public static int returnTotalIncome(int rows, int cols) {
        int firstHalf = rows / 2;
        return (firstHalf * cols * 10) + ((rows - firstHalf) * cols * 8);
    }
}