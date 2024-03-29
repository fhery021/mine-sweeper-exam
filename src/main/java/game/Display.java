package game;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
public class Display {
    public void show(String string) {
        log.info("\n" + string + "\n");
    }
}
