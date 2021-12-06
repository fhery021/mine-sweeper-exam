package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameBoardTest {
    GameBoard gameBoard;

    @BeforeEach
    void init() {
        gameBoard = new GameBoard();
    }

    @Test
    @DisplayName("Given empty board, getBoard should return clear board")
    void givenEmptyBoard_getBoard_shouldReturnClearBoard() {
        final String emptyBoard = "+-+\n" + "| |\n" + "+-+\n";

        assertThat(gameBoard.getBoard()).isEqualTo(emptyBoard);
    }

    @Test
    @DisplayName("Given empty board, placeBomb should not impact display board")
    void givenEmptyBoard_placeBomb_should_notImpactDisplayBoard() {
        final String boardWithoutBomb = "+-+\n" + "| |\n" + "+-+\n";

        gameBoard.placeBomb();

        assertThat(gameBoard.getBoard()).isEqualTo(boardWithoutBomb);
    }


    @Test
    @DisplayName("Given empty board, placeBomb, then step should place bomb")
    void givenEmptyBoard_placeBombAndstep_should_placeBomb() {
        final String boardWithBomb = "+-+\n" + "|X|\n" + "+-+\n";

        gameBoard.placeBomb();
        gameBoard.step();

        assertThat(gameBoard.getBoard()).isEqualTo(boardWithBomb);
    }

    @Test
    @DisplayName("Given empty board, game status is IN PROGRESS")
    void givenEmptyBoard_getStatus_shouldReturn_InProgress() {
        assertThat(gameBoard.getStatus()).isEqualTo(GameStatus.IN_PROGRESS);
    }

    @Test
    @DisplayName("Given board with bomb, after step on it you should loose")
    void givenBoardWithBomb_step_shouldSetStatusToLOST() {
        gameBoard.placeBomb();
        gameBoard.step();

        assertThat(gameBoard.getStatus()).isEqualTo(GameStatus.LOST);
    }

    @Test
    @DisplayName("Given board with 0 bomb, after step on it you should win")
    void givenBoardWith0Bomb_step_shouldSetStatusToWIN() {
        gameBoard.step();

        assertThat(gameBoard.getStatus()).isEqualTo(GameStatus.WON);
    }

}
