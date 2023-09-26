package pl.Aevise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.Aevise.logger1.Logger1;
import pl.Aevise.logger2.Logger2;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String empty = null;
        something2(empty);
        something();
        log.getClass();
    }
    static void something(){
        log.trace("hello darkness my old friend trace: {}", 1);
        log.debug("hello darkness my old friend debug: {}", 2);
        log.info("hello darkness my old friend info: {}", 3);
        log.warn("hello darkness my old friend warn: {}", 4);
        log.error("hello darkness my old friend error: {}, second param {}", 5, 11);

        Logger1.log();
        Logger2.log();

    }

    static void something2(String string){
        try{
            string.equals("123");
        }catch (NullPointerException e){
            log.error("hello darkness my old friend error: {}", e);
        }
    }
}
