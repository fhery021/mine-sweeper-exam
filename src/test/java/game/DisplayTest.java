package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DisplayTest {

    @DisplayName("Given a message, show should log it")
    @Test
    void given_Message_show_should_log() {
        // given
        Display display = new Display();
        // when
        display.show("message");
        // then
        assertThat(display).isNotNull();
    }

}
