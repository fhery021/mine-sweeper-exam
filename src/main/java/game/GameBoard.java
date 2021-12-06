package game;

public class GameBoard {

    private static final String FRAME = "+-+\n";

    private String displayContent = FRAME + "| |\n" + FRAME;
    private String content = FRAME + "| |\n" + FRAME;

    private GameStatus gameStatus;

    public GameBoard() {
        gameStatus = GameStatus.IN_PROGRESS;
    }

    public String getBoard() {
        return displayContent;
    }

    public void placeBomb() {
        content = FRAME + "|X|\n" + FRAME;
    }

    public void step() {
        displayContent = content;
        gameStatus = content.contains("X") ? GameStatus.LOST : GameStatus.WON;
    }

    public GameStatus getStatus() {
        return gameStatus;
    }
}
