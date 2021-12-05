package game;

public class Game {

    private Display display;

    String displayBoard = "+-+\n" + "| |\n" + "+-+\n";

    public Game(Display display) {
        this.display = display;
    }

    public GameStatus play() {
        display.show(displayBoard);
        return GameStatus.IN_PROGRESS;
    }
}
