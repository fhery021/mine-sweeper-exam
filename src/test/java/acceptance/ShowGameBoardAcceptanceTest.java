package acceptance;

import game.Display;
import game.Game;
import game.GameBoard;
import game.GameStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ShowGameBoardAcceptanceTest {

    @Mock
    Display display;

    @Mock
    GameBoard gameBoard;

    @DisplayName("Given empty board, the game should show the board.")
    @Test
    void given_newGame_game_should_showBoard() {
        // given
        String expectedGameBoard = "+-+\n" + "| |\n" + "+-+\n";

        Game game = new Game(display);

        // when
        final GameStatus gameStatus = game.play();

        // then
        Mockito.verify(display).show(expectedGameBoard);
        assertThat(gameStatus).isNotEqualTo(GameStatus.IN_PROGRESS);
    }

    @DisplayName("Given a board with bomb, when step on it, you loose")
    @Test
    void given_boardWithBomb_whenStepOnIt_status_shouldReturn_Loose() {
        // given
        Game game = new Game(display);

        // when
        final GameStatus gameStatus = game.play();

        assertThat(gameStatus).isEqualTo(GameStatus.LOOSE);
    }
}
