public class Calculator {
    public static String calculator(double number1, double number2, String operator) {
            if (operator.equals("+")) {
                return String.valueOf(number1 + number2);
            } else if (operator.equals("-")) {
                return String.valueOf(number1 - number2);
            } else if (operator.equals("*")) {
                return String.valueOf(number1*number2);
            } else {
                return String.valueOf(number1/number2);
            }
    }
}
