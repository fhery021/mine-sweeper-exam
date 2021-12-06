package game;

public final class BoardTestHelper {

    public static String createEmptyBoard() {
        String emptyLine = "| | |\n";
        StringBuilder emptyBoardBuilder = new StringBuilder(GameBoard.LINE_DELIMITER);
        for (int i = 0; i < GameBoard.BOARD_SIZE; i++) {
            emptyBoardBuilder.append(emptyLine);
            emptyBoardBuilder.append(GameBoard.LINE_DELIMITER);
        }
        return emptyBoardBuilder.toString();
    }

}
