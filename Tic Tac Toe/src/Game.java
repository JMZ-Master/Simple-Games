public class Game {

    private Board board;
    int winLength;

    public Game(int size, int winLength) {
        board = new Board(size);
        this.winLength = winLength;

        board.displayBoard();
    }

}
