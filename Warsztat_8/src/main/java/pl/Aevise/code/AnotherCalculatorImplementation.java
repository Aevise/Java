package pl.Aevise.code;

import java.util.Random;

public class AnotherCalculatorImplementation implements IAnotherCalculator {
    @Override
    public int run() {
        Random random = new Random();
        return random.nextInt();
    }
}
