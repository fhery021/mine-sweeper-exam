package acceptance;

import game.Game;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShowGameBoardAcceptanceTest {

    @DisplayName("Given empty board, the game should show the board.")
    @Test
    void given_EmptyBoard_GameShowBoard_shouldReturn_Board() {
        String expectedGameBoard = "+-+\n" + "| |\n" + "+-+\n";

        Game game = new Game();
        Assertions.assertThat(game.showBoard())
                  .isEqualTo(expectedGameBoard);
    }



}
