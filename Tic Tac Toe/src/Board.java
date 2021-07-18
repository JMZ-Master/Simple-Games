public class Board {

    int size;
    static int max = 10;
    int[][] grid;
    static final int p1 = 1, p2 = 0;

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

    public static int getP1() {
        return p1;
    }

    public static int getP2() {
        return p2;
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
        System.out.print("\n");

        for (int i = 0; i < size; i++) {
            System.out.printf("%d", i); // row number
            for (int j = 0; j < size; j++) {
                // printing each row
                if (grid[i][j] == p2) {
                    System.out.print(" O ");
                } else if (grid[i][j] == p1) {
                    System.out.print(" X ");
                } else {
                    System.out.print("   ");
                }

                if (j < size - 1) {
                    System.out.print("|");
                } else {
                    System.out.print("\n");
                }
            }
            // column below for -+-+-
            if (i < size - 1) {
                for (int j = 0; j < size; j++) {
                    if (j == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print("+");
                    }
                    System.out.print("---");
                    if (j == size - 1) {
                        System.out.print("\n");
                    }
                }
            }

        }


    }

    public void updateBoard(int player, int row, int col) {
        /* Updates the board with the desired move.
         */

//        if (row >= 0 && row < size && col >= 0 && col < size) {
//            // location within the board
//            if (grid[row][col] == -1) {
//                // unoccupied space
//                grid[row][col] = player;
//            }
//        }
        grid[row][col] = player;

    }

    public int[][] getGrid() {
        return grid;
    }
}
