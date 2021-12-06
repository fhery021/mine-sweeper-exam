package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class GameTest {

    Game game;

    @Mock
    GameBoard gameBoard;

    @Mock
    Display display;

    @BeforeEach
    void init() {
        game = new Game(gameBoard, display);
    }

    @DisplayName("Given a new Game, during initialization, game board should be created")
    @Test
    void givenNewGame_constructor_should_createGameBoard() {
        // Given
        String emptyBoard = "+-+\n" + "| |\n" + "+-+\n";
        Mockito.when(gameBoard.getBoard()).thenReturn(emptyBoard);
        // When
        // Then
        Mockito.verify(gameBoard).getBoard();
        assertThat(game.getGameBoard()).isEqualTo(emptyBoard);
    }

    @DisplayName("Given a lost game, game status changes to lost, and displays Game Over message")
    @Test
    void givenLostGame_getGameStatus_shouldReturn_Lost() throws InterruptedException {
        // Given
        Mockito.when(gameBoard.getStatus()).thenReturn(GameStatus.IN_PROGRESS, GameStatus.LOST);
        // When
        game.play();
        // Then
        Mockito.verify(gameBoard).step();
        assertThat(game.getGameStatus()).isEqualTo(GameStatus.LOST);
        Mockito.verify(display).show("BOOM! Game over.\n");
    }

    @DisplayName("Given a won game, game status changes to won, and displays Good Job message")
    @Test
    void givenWonGame_getGameStatus_shouldReturn_Won() throws InterruptedException {
        // Given
        Mockito.when(gameBoard.getStatus()).thenReturn(GameStatus.IN_PROGRESS, GameStatus.WON);
        // When
        game.play();
        // Then
        Mockito.verify(gameBoard).step();
        assertThat(game.getGameStatus()).isEqualTo(GameStatus.WON);
        Mockito.verify(display).show("The land is cleared! GOOD JOB! \n");
    }

}
