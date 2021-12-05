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

    @DisplayName("Given empty board with bomb, click on square should unveil the bomb.")
    @Test
    void givenEmptyBoardWithBomb_click_should_unveil_bomb() {
        String expectedGameBoard = "+-+\n" + "|X|\n" + "+-+\n";

        Game game = new Game();
        game.click();
        Assertions.assertThat(game.showBoard())
                  .isEqualTo(expectedGameBoard);
    }


}
