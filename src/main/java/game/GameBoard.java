package game;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.Random;

public class GameBoard {
    public static final int BOARD_SIZE = 2;

    public static final String LINE_DELIMITER = "+-+-+\n";

    private static final String CHARACTER_DELIMITER = "|";

    private static final String BEGIN_LINE = "|";

    private static final String END_LINE = "\n";

    private static final String BOMB_CHARACTER = "X";

    private static final int BOMB_FLAG = 0;

    private static final String EMPTY_CHARACTER = " ";

    private static final int EMPTY_FLAG = -1;

    private final Random random = new Random();

    private final PrimitiveIterator.OfInt randomIterator = random.ints(0, BOARD_SIZE)
                                                                 .iterator();

    private int[][] content = new int[BOARD_SIZE][BOARD_SIZE];

    private final int[][] bombMap = new int[BOARD_SIZE][BOARD_SIZE];

    private GameStatus gameStatus;

    public GameBoard() {
        gameStatus = GameStatus.IN_PROGRESS;
        initContent();
    }

    public String getBoard() {
        StringBuilder displayContentBuilder = new StringBuilder(LINE_DELIMITER);
        for (int i = 0; i < BOARD_SIZE; i++) {
            displayContentBuilder.append(BEGIN_LINE);
            for (int j = 0; j < BOARD_SIZE; j++) {
                displayContentBuilder.append(mapContentToDisplayCharacter(content[i][j]))
                                     .append(CHARACTER_DELIMITER);
            }
            displayContentBuilder.append(END_LINE);
            displayContentBuilder.append(LINE_DELIMITER);
        }
        return displayContentBuilder.toString();
    }

    public void placeBomb() {
        Arrays.stream(bombMap)
              .forEach(row -> Arrays.fill(row, 1));
        int randomRow = randomIterator.nextInt();
        int randomColumn = randomIterator.nextInt();

        bombMap[randomRow][randomColumn] = BOMB_FLAG;
    }

    public void step() {
        int randomRow = randomIterator.nextInt();
        int randomColumn = randomIterator.nextInt();

        if (bombMap[randomRow][randomColumn] == BOMB_FLAG) {
            content[randomRow][randomColumn] = BOMB_FLAG;
            gameStatus = GameStatus.LOST;
        } else {
            content[randomRow][randomColumn] = bombMap[randomRow][randomColumn];
            if (checkAllNonBombSquaresAreOpen()) {
                unveilNeighbours();
                gameStatus = GameStatus.WON;
            }
        }
    }

    private void unveilNeighbours() {
        content = bombMap;
    }

    public GameStatus getStatus() {
        return gameStatus;
    }

    private void initContent() {
        Arrays.stream(content)
              .forEach(row -> Arrays.fill(row, EMPTY_FLAG));

        Arrays.stream(bombMap)
              .forEach(row -> Arrays.fill(row, EMPTY_FLAG));
    }

    private boolean checkAllNonBombSquaresAreOpen() {
        return Arrays.stream(content)
                     .anyMatch(row -> Arrays.stream(row)
                                            .anyMatch(square -> square == EMPTY_FLAG));
    }

    private String mapContentToDisplayCharacter(int i) {
        switch (i) {
            case EMPTY_FLAG:
                return EMPTY_CHARACTER;
            case BOMB_FLAG:
                return BOMB_CHARACTER;
            default:
                return String.valueOf(i);
        }
    }

}
