public class Board {

    int size;
    static int max = 10;
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
                if (grid[i][j] == 0) {
                    System.out.printf(" O ");
                } else if (grid[i][j] == 1) {
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

}
