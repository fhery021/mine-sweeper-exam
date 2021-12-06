package game;

import java.util.concurrent.TimeUnit;

public class Game {
    private final GameBoard gameBoard;

    private final Display display;

    public Game() {
        this.gameBoard = new GameBoard();
        this.display = new Display();
        initGame();
    }

    public Game(GameBoard gameBoard, Display display) {
        this.gameBoard = gameBoard;
        this.display = display;
        initGame();
    }

    public GameStatus getGameStatus() {
        return gameBoard.getStatus();
    }

    public String getGameBoard() {
        return gameBoard.getBoard();
    }

    public void play() throws InterruptedException {
        while (gameBoard.getStatus()
                        .equals(GameStatus.IN_PROGRESS)) {
            waitTwoSeconds();
            gameBoard.step();
            display.show(gameBoard.getBoard());
        }
        displayGameResult(gameBoard.getStatus());
    }

    private void initGame() {
        showInitMessage();
        this.gameBoard.placeBomb();
    }

    private void showInitMessage() {
        display.show("Game Created.\n" + gameBoard.getBoard());
    }

    private void waitTwoSeconds() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    private void displayGameResult(GameStatus gameStatus) {
        if (gameStatus.equals(GameStatus.WON)) {
            display.show("The land is cleared! GOOD JOB! \n");
        } else {
            display.show("BOOM! Game over.\n");
        }
    }
}
