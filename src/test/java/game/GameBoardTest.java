package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameBoardTest {
    GameBoard gameBoard;

    private static final String EMPTY_BOARD = BoardTestHelper.createEmptyBoard();

    @BeforeEach
    void init() {
        gameBoard = new GameBoard();
    }

    @Test
    @DisplayName("Given empty board, getBoard should return clear board")
    void givenEmptyBoard_getBoard_shouldReturnClearBoard() {
        assertThat(gameBoard.getBoard()).isEqualTo(EMPTY_BOARD);
    }

    @Test
    @DisplayName("Given empty board, placeBomb should not impact display board")
    void givenEmptyBoard_placeBomb_should_notImpactDisplayBoard() {
        gameBoard.placeBomb();

        assertThat(gameBoard.getBoard()).isEqualTo(EMPTY_BOARD);
    }

    @Test
    @DisplayName("Given empty board, placeBomb and step should update the board")
    void givenEmptyBoard_placeBombAndStep_should_updateTheBoard() {
        gameBoard.placeBomb();
        gameBoard.step();

        assertThat(gameBoard.getBoard()).isNotEqualTo(EMPTY_BOARD);
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

        assertThat(gameBoard.getStatus()).isNotEqualTo(GameStatus.IN_PROGRESS);
    }

    @Test
    @DisplayName("Given board with 0 bomb, after step on it you should win")
    void givenBoardWith0Bomb_step_shouldSetStatusToWIN() {
        gameBoard.step();

        assertThat(gameBoard.getStatus()).isEqualTo(GameStatus.WON);
    }

}
