package com.zhukv.SmartCalculator.logic;

import com.zhukv.SmartCalculator.entity.CalculationsRequest;
import com.zhukv.SmartCalculator.entity.CalculationsResult;

import java.util.HashMap;
import java.util.function.BinaryOperator;


public record Calculator(CalculationsRequest request) {
    private static final HashMap<String, BinaryOperator<Double>> supportedOperators;

    static {
        supportedOperators = new HashMap<>();
        supportedOperators.put("+", Double::sum);
        supportedOperators.put("*", (a, b) -> a * b);
        supportedOperators.put("-", (a, b) -> a - b);
        supportedOperators.put("/", (a, b) -> a / b);
    }

    public CalculationsResult calculate() {
        String resultValue = executeCalculations(
                request.getFirst(),
                request.getSecond(),
                request.getOperator(),
                request.isSquare()
        );

        resultValue = resultValue.contains(".0")?resultValue.substring(0, resultValue.length()-2):resultValue;

        return new CalculationsResult(resultValue, makeOutput(resultValue));
    }

    private String makeOutput(String resultValue) {
        StringBuilder output = new StringBuilder();
        output.append(request.getFirst());

        if (!request.getOperator().equals("")) {
            output.append(" ");
            output.append(request.getOperator());
            output.append(" ");
            output.append(request.getSecond());
        }

        if (request.isSquare()) {
            output.insert(0, "(");
            output.append(")^2");
        }

        output.append(" = ");
        output.append(resultValue);
        return output.toString();
    }

    private String executeCalculations(String first, String second, String operator, boolean square) {
        double resultValue;
        Double firstNumber = Double.valueOf(first);
        if (!operator.equals("")) {
            Double secondNumber = Double.valueOf(second);
            resultValue = supportedOperators.get(operator).apply(firstNumber, secondNumber);
        } else resultValue = firstNumber;
        if (square) resultValue *= resultValue;
        return Double.toString(resultValue);
    }
}
