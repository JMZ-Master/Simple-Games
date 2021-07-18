public class Board {

    int size;
    static int max = 10;
    static final int p1 = 1, p2 = 0;
    int[][] grid;

    public Board(int size) {
        /* size must be at least 3 and
         * a maximum of 10
         */
        if (size < 3) {
            this.size = 3;
        } else if (size > 10) {
            this.size = max;
        } else {
            this.size = size;
        }

        grid = new int[this.size][this.size];
        createBoard();

    }

    private void createBoard() {
        /* Initialises game board based on the
         * given size. Empty spaces are represented by -1.
         */

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = -1;
            }
        }
    }

    public void displayBoard() {
        /* Prints the board to the console.
         */

        // printing the column numbers
        for (int i = 0; i < size; i++) {
            System.out.printf("  %d ",i);
        }
        System.out.printf("\n");

        for (int i = 0; i < size; i++) {
            System.out.printf("%d", i); // row number
            for (int j = 0; j < size; j++) {
                // printing each row
                if (grid[i][j] == p2) {
                    System.out.printf(" O ");
                } else if (grid[i][j] == p1) {
                    System.out.printf(" X ");
                } else {
                    System.out.printf("   ");
                }

                if (j < size - 1) {
                    System.out.printf("|");
                } else {
                    System.out.printf("\n");
                }
            }
            // column below for -+-+-
            if (i < size - 1) {
                for (int j = 0; j < size; j++) {
                    if (j == 0) {
                        System.out.printf(" ");
                    } else {
                        System.out.printf("+");
                    }
                    System.out.printf("---");
                    if (j == size - 1) {
                        System.out.printf("\n");
                    }
                }
            }

        }


    }

    public void updateBoard(int player, int row, int col) {
        /* Tries to update the board with the desired move.
         */

        if (row >= 0 && row < size && col >= 0 && col < size) {
            // location within the board
            if (grid[row][col] == -1) {
                // unoccupied space
                grid[row][col] = player;
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }
}
