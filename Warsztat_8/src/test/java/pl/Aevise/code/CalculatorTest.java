package pl.Aevise.code;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params .ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Slf4j
public class CalculatorTest {
    private Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting something before all Tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Starting something after all Tests");
    }

    public static int[][] testData() {
        return new int[][]{
                {5, 2, 3},
                {4, 2, 2},
                {9, 5, 4}};
    }

    private String createMessage(int param) {
        System.out.println("Creating Message " + param);
        return "Failure Message";
    }

    @BeforeEach
    void beforeEach() {
        calculator = new Calculator(() -> 0); // zaślepianie (Mock) interface funkcyjnego
        System.out.println("Starting something before each Test");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Starting something after each Test");
    }

    @ParameterizedTest
    @MethodSource(value = "testData")
    @DisplayName("Testing methong which tests adding behaviour")
    void add(int[] testData) {
//        given, when
//        int result = Calculator.add(testData[0], testData[1]);
//        then
        Assertions.assertEquals(testData[0], calculator.add(testData[1], testData[2]));
//       Testy sparametryzowane korzystają z tablic dwuwymiarowych
//        Assertions.assertEquals(expected, result, () -> createMessage(expected)); //supplier wykonuje sie gdy test zawiedzie
    }

    @Test
    void subtract() {
        int num1 = 5;
        int num2 = 7;
        Integer expected = -2;
        String test = "hehe";
//        when
        Integer result = Calculator.subtract(num1, num2);
//        then
        Assertions.assertEquals(expected, result);
        Assertions.assertAll(
                ()-> Assertions.assertEquals(5,5, () -> "My message 1"),
                ()-> Assertions.assertEquals(7,1, () -> "My message 2"),
                ()-> Assertions.assertEquals(6,5, () -> "My message 3")
        );
//        NumberFormatException throwable = Assertions.
//                assertThrows(NumberFormatException.class, () -> Calculator.add(num1, test));
    }

    @Test
    void multiply() {
        int num1 = 5;
        int num2 = 7;
        Integer expected = 35;
//        when
        Integer result = Calculator.multiply(num1, num2);
//        then
        Assertions.assertEquals(expected, result);
        log.info("Some log [{}]", result);
    }

    @Test
    void divide() {
        int num1 = 5;
        int num2 = 7;
        Integer expected = 0;
//        when
        Integer result = Calculator.divide(num1, num2);
//        then
        Assertions.assertEquals(expected, result);
        log.debug("Some log [{}]", result);
    }
}
