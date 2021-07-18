import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Board board;
    int winLength;

    public Game(int size, int winLength) {
        board = new Board(size);
        this.winLength = winLength;

        board.displayBoard();
    }

    public boolean WhoStarts() {
        //returns true if guesses correctly
        int guess = -1, start;
        boolean done = false;
        double rand;
        rand = Math.random() * 100;
        if (rand > 50){start = 1;}else{start = 0;}
        Scanner reader = new Scanner(System.in);

        while (!done) {
            System.out.print("Heads(1) or Tails(0)?\n");
            guess = reader.nextInt();
            if (guess == 1 || guess == 0) {
                done = true;
            }
        }

        if (guess == start) {
            System.out.print("Correct, you start!\n");
            return true;
        }
        else
        {
            System.out.print("Incorrect, opponent starts!\n");
            return false;
        }

    }

    private boolean checkMove(int player, int row, int col) {
        // returns true if update is successful

        int[][] prevBoard = board.getGrid();
        board.updateBoard(player, row, col);
        int[][] nextBoard = board.getGrid();

        return prevBoard[row][col] != nextBoard[row][col];
    }

    public void askMove(int player) {
        int row = -1, col = -1;
        Scanner reader = new Scanner(System.in);
        while (!this.checkMove(player, row, col)) {
            System.out.println("Enter row number: ");
            row = reader.nextInt();
            System.out.println("Enter column number: ");
            col = reader.nextInt();
        }
    }

    public boolean checkWin(int player) {
        /* Returns true if the player wins else false.
         */
        int[][] grid = board.getGrid();
        int[][] square;
        /* Winning chain is comprised of identical moves linked in
         * vertical, horizontal or diagonal direction
         * on the board. It needs to be 'winLength'
         * (e.g. 3) long for the player to win.
         *
         * Any nxn grid has 2(n+1) winning chains
         * and any mxm board has (m-n+1)^2 of these grids.
         * e.g. playing to win for 3 on a 4x4 board
         * means 4*8 = 32 possible ways to win.
        */
        for (int i = 0; i < board.size - winLength + 1; i++) {
            for (int j = 0; j < board.size - winLength + 1; j++) {
                // each subgrid has 2(winLength + 1) ways to win
                square = subGrid(grid, i, j, winLength);
                if (winChains(square, winLength, player)) {
                    return true;
                }
            }
        }

        return false;
    }

    private int[][] subGrid(int[][] grid, int row, int col, int size) {
        int[][] square = new int[size][size];

        for (int i = 0; i < size; i++) {
            System.arraycopy(grid[row + i], col, square[i], 0, size);
        }

        return square;
    }

    private boolean winChains(int[][] square, int size, int play) {
        int j;

        // checking each row
        for (int i = 0; i < size; i++) {
            j = 0;
            while(square[i][j] == play && j < size) {
                j = j + 1;
                if (j == size) {
                    return true;
                }
            }
        }

        // checking each column
        for (int i = 0; i < size; i++) {
            j = 0;
            while(square[j][i] == play && j < size) {
                j = j + 1;
                if (j == size) {
                    return true;
                }
            }
        }

        // checking the two diagonals
        j = 0;
        while(square[j][j] == play && j < size) {
            j = j + 1;
            if (j == size) {
                return true;
            }
        }
        j = 0;
        while(square[j][size-1-j] == play && j < size) {
            j = j + 1;
            if (j == size) {
                return true;
            }
        }

        return false;
    }

    public boolean checkDraw() {
        for (int i = 0; i < board.size; i++) {
            for (int j = 0; j < board.size;j++) {
                if (board.grid[i][j] == -1) {
                    // unoccupied
                    return false;
                }
            }
        }

        return true;
    }

}
