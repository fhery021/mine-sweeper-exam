package acceptance;

import game.Game;
import game.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({MockitoExtension.class})
class ShowGameBoardAcceptanceTest {

    @DisplayName("Given empty board, the game should show the board.")
    @Test
    void given_newGame_game_should_showBoard() {
        // given
        String expectedGameBoard = "+-+\n" + "| |\n" + "+-+\n";
        Game game = new Game();
        // when

        // then
        assertThat(game.getGameStatus()).isEqualTo(GameStatus.IN_PROGRESS);
        assertThat(game.getGameBoard()).isEqualTo(expectedGameBoard);
    }

    @DisplayName("Given a board with bomb, when step on it, you loose")
    @Test
    void given_boardWithBomb_whenStepOnIt_status_shouldReturn_Loose() throws InterruptedException {
        // given
        String expectedGameBoard = "+-+\n" + "|X|\n" + "+-+\n";
        Game game = new Game();
        // when
        game.play();

        // then
        assertThat(game.getGameStatus()).isEqualTo(GameStatus.LOST);
        assertThat(game.getGameBoard()).isEqualTo(expectedGameBoard);
    }
}
