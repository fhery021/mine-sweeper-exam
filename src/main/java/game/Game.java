package game;

public class Game {

    private Display display;

    private GameBoard gameBoard;

    String displayBoard = "+-+\n" + "| |\n" + "+-+\n";

    public Game(Display display) {
        this.display = display;
    }

    public GameStatus play() {
        display.show(displayBoard);
        return GameStatus.LOOSE;
    }
}
