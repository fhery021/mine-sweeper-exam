package acceptance;

import game.Display;
import game.Game;
import game.GameStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ShowGameBoardAcceptanceTest {

    @Mock
    Display display;

    @DisplayName("Given empty board, the game should show the board.")
    @Test
    void given_newGame_play_shouldReturn_winner() {
        String expectedGameBoard = "+-+\n" + "| |\n" + "+-+\n";

        Game game = new Game(display);
        final GameStatus gameStatus = game.play();

        Mockito.verify(display).show(expectedGameBoard);
        Assertions.assertThat(gameStatus).isEqualTo(GameStatus.IN_PROGRESS);
    }
}
