package game;

public class Game {

    String displayBoard = "+-+\n" + "| |\n" + "+-+\n";

    public String showBoard() {
        System.out.println(displayBoard);
        return displayBoard;
    }

    public void click() {
        this.displayBoard = "+-+\n" + "|X|\n" + "+-+\n";
    }
}
