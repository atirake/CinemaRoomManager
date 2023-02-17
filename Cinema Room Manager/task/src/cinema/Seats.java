package cinema;

public class Seats {
    int[][] cinema;
    int purchased;

    public Seats(int rows, int cols) {
        this.purchased = 0;
        this.cinema = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < cols + 1; j++) {
                if (i == 0) {
                    this.cinema[i][j] = j;
                } else if (j == 0) {
                    this.cinema[i][j] = i;
                } else {
                    this.cinema[i][j] = -1;
                }
                if (i == 0 && j == 0) {
                    cinema[i][j] = -2;
                }
            }
        }
    }

    public void markSeat(int row, int col) {
        if (row >= 0 && col >= 0) {
            this.cinema[row][col] = -3;
            this.purchased += 1;
        }
    }

    public boolean checkSeat(int row, int col) {
        return (this.cinema[row][col] == -3 ? false:true);
    }
    public void displayCinema(int rows, int cols) {
        System.out.println("Cinema:");
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < cols + 1; j++) {
                if (cinema[i][j] == -3) {
                    System.out.print("B" + " ");
                } else if (cinema[i][j] == -2) {
                    System.out.print(" " + " ");
                } else if (cinema[i][j] == -1) {
                    System.out.print("S" + " ");
                } else {
                    System.out.print(cinema[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
