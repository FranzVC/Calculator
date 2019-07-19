package com.calculator;

import java.util.ArrayList;
import java.util.Arrays;

class Calculator {
    private ArrayList<Character> OPERATORS = new ArrayList<>
            (Arrays.asList('*', '/', '-', '+'));
    private int RIGHT_DIRECTION = 1;
    private int LEFT_DIRECTION = -1;

    private String syntaxError = "Syntax Error";

    String calc(String expression) {
        expression = prepareExpression(expression);
        int pos = 0;
        if (isValidExpression(expression, "(")) {
            pos = getPosition(expression, "(");
            if (pos == 0 || (expression.charAt(pos - 1) == '*' && pos - 1 > 0)) {

                String subExp = extractExpressionFromBraces(expression, pos);
                if (subExp.equals(syntaxError))
                    return subExp;
                expression = expression.replace("(" + subExp + ")", calc(subExp));
            } else {
                expression = expression.substring(0, pos) + "*" + expression.substring(pos);
                return calc(expression);
            }
            return calc(expression);

        } else if (isValidExpression(expression, "sin")) {
            pos = getPosition(expression, "sin");
            if (pos == 0 || (expression.charAt(pos - 1) == '*' && pos - 1 > 0)) {
                pos += 2;
                String number = extractNumber(expression, pos, RIGHT_DIRECTION);
                expression = expression.replace("sin" + number,
                        Double.toString(Math.sin(Double.parseDouble(number))));
            } else {
                expression = expression.substring(0, pos) + "*" + expression.substring(pos);
                return calc(expression);
            }
            return calc(expression);

        } else if (isValidExpression(expression, "cos")) {
            pos = getPosition(expression, "cos");
            if (pos == 0 || (expression.charAt(pos - 1) == '*' && pos - 1 > 0)) {
                pos += 2;

                String number = extractNumber(expression, pos, RIGHT_DIRECTION);
                expression = expression.replace("cos" + number,
                        Double.toString(Math.cos(Double.parseDouble(number))));
            } else {
                expression = expression.substring(0, pos) + "*" + expression.substring(pos);
                return calc(expression);
            }
            return calc(expression);

        } else if (isValidExpression(expression, "exp")) {
            pos = getPosition(expression, "exp");
            if(pos == 0 || (expression.charAt(pos-1) == '*' && pos-1>0)) {

                pos += 2;

                String number = extractNumber(expression, pos, RIGHT_DIRECTION);
                expression = expression.replace("exp" + number,
                        Double.toString(Math.exp(Double.parseDouble(number))));
            }
            else{
                expression = expression.substring(0, pos) + "*" + expression.substring(pos);
                return calc(expression);
            }
            return calc(expression);

        } else if (expression.indexOf("*") > 0 | expression.indexOf("/") > 0) {

            int multPos = expression.indexOf("*");
            int divPos = expression.indexOf("/");

            pos = Math.min(multPos, divPos);
            if (multPos < 0) pos = divPos;
            else if (divPos < 0) pos = multPos;

            char divider = expression.charAt(pos);

            String leftNum = extractNumber(expression, pos, LEFT_DIRECTION);
            String rightNum = extractNumber(expression, pos, RIGHT_DIRECTION);
            if (leftNum.equals(String.valueOf(syntaxError)) || rightNum.equals(String.valueOf(syntaxError))) {
                return String.valueOf(syntaxError);
            }

            expression = expression.replace(leftNum + divider + rightNum,
                    calcShortExpr(leftNum, rightNum, divider));

            return calc(expression);

        } else if (expression.indexOf("-", 1) > 0) {
            pos = expression.indexOf("-", 1);

            char divider = expression.charAt(pos);

            if (expression.charAt(0) == '-') {
                String numberLeft = extractNumber(expression, 0, RIGHT_DIRECTION);
                int operatorPosition = numberLeft.length() + 1;
                String numberRight = extractNumber(expression, operatorPosition, RIGHT_DIRECTION);
                char operation = expression.charAt(operatorPosition);

                expression = expression.replace("-" + numberLeft + operation + numberRight,
                        addition(expression, operatorPosition, numberLeft, numberRight));
            } else {
                String leftNum = extractNumber(expression, pos, LEFT_DIRECTION);
                String rightNum = extractNumber(expression, pos, RIGHT_DIRECTION);
                expression = expression.replace(leftNum + divider + rightNum,
                        calcShortExpr(leftNum, rightNum, divider));
            }
            return calc(expression);
        } else if (expression.indexOf("+") > 0) {
            pos = expression.indexOf("+");
            char divider = expression.charAt(pos);

            if (expression.charAt(0) == '-') {
                String numberLeft = extractNumber(expression, 0, RIGHT_DIRECTION);
                int operatorPosition = numberLeft.length() + 1;
                String numberRight = extractNumber(expression, operatorPosition, RIGHT_DIRECTION);
                char operation = expression.charAt(operatorPosition);

                expression = expression.replace("-" + numberLeft + operation + numberRight,
                        addition(expression, operatorPosition, numberLeft, numberRight));
            } else {
                String leftNum = extractNumber(expression, pos, LEFT_DIRECTION);
                String rightNum = extractNumber(expression, pos, RIGHT_DIRECTION);
                expression = expression.replace(leftNum + divider + rightNum,
                        calcShortExpr(leftNum, rightNum, divider));
            }
            return calc(expression);

        } else return expression;
    }


    private boolean isValidExpression(String expression, String operation) {
        return expression.contains(operation);
    }

    private int getPosition(String expression, String operation) {
        return expression.indexOf(operation);
    }

    private String extractExpressionFromBraces(String expression, int pos) {
        int braceDepth = 1;
        String subExp = "";

        for (int i = pos + 1; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case '(':
                    braceDepth++;
                    subExp += "(";
                    break;
                case ')':
                    braceDepth--;
                    if (braceDepth != 0) subExp += ")";
                    break;
            }
            if (braceDepth > 0) subExp += expression.charAt(i);
            if (braceDepth == 0 && !subExp.equals("")) return subExp;
        }
        return String.valueOf(syntaxError);
    }

    private String extractNumber(String expression, int pos, int direction) {
        String resultNumber = "";
        int currPos = pos + direction;

        if (currPos < expression.length() && currPos >= 0) {
            if (expression.charAt(currPos) == '-') {
                resultNumber += expression.charAt(currPos);
                currPos += direction;
            }

            for (; currPos >= 0 && currPos < expression.length() && !OPERATORS.contains(expression.charAt(currPos)); currPos += direction) {
                resultNumber += expression.charAt(currPos);
            }

            if (direction == LEFT_DIRECTION) resultNumber = new
                    StringBuilder(resultNumber).reverse().toString();

            return resultNumber;
        }
        return syntaxError;
    }

    private String calcShortExpr(String leftNum, String rightNum, char divider) {
        switch (divider) {
            case '*':
                return Double.toString(Double.parseDouble(leftNum) *
                        Double.parseDouble(rightNum));
            case '/':
                return Double.toString(Double.parseDouble(leftNum) /
                        Double.parseDouble(rightNum));
            case '+':
                return Double.toString(Double.parseDouble(leftNum) +
                        Double.parseDouble(rightNum));
            case '-':
                return Double.toString(Double.parseDouble(leftNum) -
                        Double.parseDouble(rightNum));
            default:
                return "0";
        }
    }

    String prepareExpression(String expression) {
        expression = expression.replace("PI", "("+Double.toString(Math.PI)+")");
        expression = expression.replace("E", Double.toString(Math.E));
        expression = expression.replace("sin.", "sin0.");
        expression = expression.replace("cos.", "cos0.");
        expression = expression.replace("exp.", "exp0.");

        expression = expression.replace("++", "+");
        expression = expression.replace("+-", "-");
        expression = expression.replace("--", "+");
        expression = expression.replace("-+", "-");
        expression = expression.replace("*+", "*");
        expression = expression.replace("/+", "/");
        expression = expression.replace("+.", "+0.");
        expression = expression.replace("-.", "-0.");
        expression = expression.replace("*.", "*0.");
        expression = expression.replace("/.", "/0.");

        if (expression.contains("+*")) {
            return syntaxError;
        }
        if (expression.contains("+/")) {
            return syntaxError;
        }
        if (expression.contains("-*")) {
            return syntaxError;
        }
        if (expression.contains("-/")) {
            return syntaxError;
        }
        if (expression.contains("**")) {
            return syntaxError;
        }
        if (expression.contains("*/")) {
            return syntaxError;
        }
        if (expression.contains("/*")) {
            return syntaxError;
        }
        if (expression.contains("//")) {
            return syntaxError;
        }
        return expression;
    }

    private String addition(String expression, int operatorPosition, String numberLeft, String numberRight) {
        if (expression.charAt(operatorPosition) == '-') {
            return "-" + (Double.parseDouble(numberLeft) +
                    Double.parseDouble(numberRight));
        } else {
            return String.valueOf(Double.parseDouble(numberRight) -
                    Double.parseDouble(numberLeft));
        }
    }
}
