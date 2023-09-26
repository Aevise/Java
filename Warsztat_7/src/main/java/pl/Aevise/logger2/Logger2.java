package pl.Aevise.logger2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.Aevise.logger1.Logger1;

public class Logger2 {
    private static final Logger log = LoggerFactory.getLogger(Logger2.class.getName());

    public static void main(String[] args) {
        log();
    }

    public static void log() {
        log.trace("hello darkness my old friend trace: {}", Logger2.class.getName());
        log.debug("hello darkness my old friend debug: {}", Logger2.class.getName());
        log.info("hello darkness my old friend info: {}", Logger2.class.getName());
        log.warn("hello darkness my old friend warn: {}", Logger2.class.getName());
        log.error("hello darkness my old friend error: {}", Logger2.class.getName());
    }
}
