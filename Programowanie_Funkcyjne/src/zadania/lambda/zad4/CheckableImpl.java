package zadania.lambda.zad4;

import zadania.lambda.zad3.Checkable;

public class CheckableImpl implements Checkable {
    @Override
    public String checker(Integer num1, Integer num2, String text) {
        return "hehe from " + this.getClass().getSimpleName();
    }
}
