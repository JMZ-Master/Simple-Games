public class Main {

    public static void main(String[] args) {
        // Tic Tac Toe game
        int size = 3;
        int win = 3;
        boolean gameOver = false;
        int p1 = Game.getP1();
        int p2 = Game.getP2();

        Game game = new Game(size, win);
        game.getBoard().displayBoard();
        int start = game.whoStarts();

        while(!gameOver) {
            if (start == p1) {
                // p1 starts
                System.out.println("Player One: ");
                game.askMove(p1);
                game.getBoard().displayBoard();
                if (game.checkWin(p1)){
                    gameOver = true;
                    System.out.println("Player one wins!");
                } else if (game.checkDraw()){
                    gameOver = true;
                    System.out.println("Draw!");
                } else {
                    // p2 turn
                    System.out.println("Player Two: ");
                    game.askMove(p2);
                    game.getBoard().displayBoard();

                    if (game.checkWin(p2)){
                        gameOver = true;
                        System.out.println("Player two wins!");
                    } else if (game.checkDraw()){
                        gameOver = true;
                        System.out.println("Draw!");
                    }
                }

            } else {
                // p2 starts
                System.out.println("Player Two: ");
                game.askMove(p2);
                game.getBoard().displayBoard();
                if (game.checkWin(p2)){
                    gameOver = true;
                    System.out.println("Player two wins!");
                } else if (game.checkDraw()){
                    gameOver = true;
                    System.out.println("Draw!");
                } else {
                    // p1 turn
                    System.out.println("Player One: ");
                    game.askMove(p1);
                    game.getBoard().displayBoard();

                    if (game.checkWin(p1)){
                        gameOver = true;
                        System.out.println("Player one wins!");
                    } else if (game.checkDraw()){
                        gameOver = true;
                        System.out.println("Draw!");
                    }
                }
            }
        }

    }

}
