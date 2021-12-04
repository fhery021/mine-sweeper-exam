package dummy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DummyTest {

    @DisplayName("Given no input, dummy method should return dummy string")
    @Test
    void given_NoInput_dummyMethod_shouldReturn_dummyString() {
        Assertions.assertThat(Dummy.DUMMY_STRING).isEqualTo("dummyString");
    }
}