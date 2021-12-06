package acceptance;

import game.BoardTestHelper;
import game.Game;
import game.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({ MockitoExtension.class })
class ShowGameBoardAcceptanceTest {

    private static final String EMPTY_BOARD = BoardTestHelper.createEmptyBoard();

    @DisplayName("Given empty board, the game should show the board.")
    @Test
    void given_newGame_game_should_showBoard() {
        // given
        Game game = new Game();
        // when

        // then
        assertThat(game.getGameStatus()).isEqualTo(GameStatus.IN_PROGRESS);
        assertThat(game.getGameBoard()).isEqualTo(EMPTY_BOARD);
    }

    @DisplayName("Given a board with bomb, when playing, you should win or loose")
    @Test
    void given_boardWithBomb_whenStepOnIt_status_shouldReturn_Loose() throws InterruptedException {
        // given
        Game game = new Game();
        // when
        game.play();

        // then
        assertThat(game.getGameStatus()).isIn(GameStatus.LOST, GameStatus.WON);
    }
}
