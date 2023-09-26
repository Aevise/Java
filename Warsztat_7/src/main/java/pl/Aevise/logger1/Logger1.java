package pl.Aevise.logger1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.Aevise.logger2.Logger2;

public class Logger1 {
    private static final Logger log = LoggerFactory.getLogger(Logger1.class.getName());

    public static void main(String[] args) {
        log();
    }

    public static void log() {
        log.trace("hello darkness my old friend trace: {}", Logger1.class.getName());
        log.debug("hello darkness my old friend debug: {}", Logger1.class.getName());
        log.info("hello darkness my old friend info: {}", Logger1.class.getName());
        log.warn("hello darkness my old friend warn: {}", Logger1.class.getName());
        log.error("hello darkness my old friend error: {}", Logger1.class.getName());
    }
}
