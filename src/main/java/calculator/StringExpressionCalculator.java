package calculator;

public class StringExpressionCalculator {

    /*
    기능 요구사항

    사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
    문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
    즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
    예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
     */

    public int calculate(String expression) {
        String[] expressions = split(expression);

        int result = Integer.valueOf(expressions[0]);

        for (int i = 1; i < expressions.length; i += 2) {
            String operator = expressions[i];
            int number = Integer.valueOf(expressions[i + 1]);

            result = operate(result, operator, number);
        }

        return result;
    }

    private int operate(int firstNumber, String operation, int secondNumber) {
        if("/".equals(operation) && secondNumber == 0) {
            throw new IllegalArgumentException();
        }

        switch (operation) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                return firstNumber / secondNumber;
            default:
                throw new IllegalArgumentException();
        }
    }

    private String[] split(String expression) {
        if(expression == null || "".equals(expression)) {
            throw new IllegalArgumentException();
        }

        return expression.split(" ");
    }
}