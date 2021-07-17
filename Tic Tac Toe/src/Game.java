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
            System.out.printf("Heads(1) or Tails(0)?\n");
            guess = reader.nextInt();
            if (guess == 1 || guess == 0) {
                done = true;
            }
        }

        if (guess == start) {
            System.out.printf("Correct, you start!\n");
            return true;
        }
        else
        {
            System.out.printf("Incorrect, opponent starts!\n");
            return false;
        }

    }

    private boolean checkMove(int player, int row, int col) {
        // returns true if update is successful

        int[][] prevBoard = board.getGrid();
        board.updateBoard(player, row, col);
        int[][] nextBoard = board.getGrid();

        if (prevBoard[row][col] == nextBoard[row][col]) {
            return false;
        } else {
            return true;
        }
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

}
