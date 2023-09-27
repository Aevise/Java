package pl.Aevise.code;

public class Calculator {
    private final IAnotherCalculator anotherCalculator;

    public Calculator(IAnotherCalculator anotherCalculator) {
        this.anotherCalculator = anotherCalculator;
    }

    public static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static int divide(int num1, int num2) {
        if(num2 <= 0  || num1 <= 0){
            return 0;
        }
        return num1 / num2;
    }

    public int add(int num1, int num2) {
        int run = anotherCalculator.run();
        return num1 + num2 + run;
    }
}
