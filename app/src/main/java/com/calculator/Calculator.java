package com.calculator;


import com.calculator.utilities.Utility;

class Calculator {
    String calc(String expression) {
        expression = Utility.prepareExpression(expression);
        int pos = 0;

        if (Utility.isValidExpression(expression, "(")) {
            pos = Utility.getPosition(expression, "(");
            if (pos == 0 || (expression.charAt(pos - 1) == '*' && pos - 1 > 0)) {

                String subExp = Utility.extractExpressionFromBraces(expression, pos);
                if (subExp.equals(Utility.syntaxError))
                    return subExp;
                expression = expression.replace("(" + subExp + ")", calc(subExp));
            } else {
                expression = expression.substring(0, pos) + "*" + expression.substring(pos);
                return calc(expression);
            }
            return calc(expression);

        } else if (Utility.isValidExpression(expression, "sin")) {
            pos = Utility.getPosition(expression, "sin");
            if (pos == 0 || (expression.charAt(pos - 1) == '*' && pos - 1 > 0)) {
                pos += 2;
                String number = Utility.extractNumber(expression, pos, Utility.RIGHT_DIRECTION);
                expression = expression.replace("sin" + number,
                        Double.toString(Math.sin(Double.parseDouble(number))));
            } else {
                expression = expression.substring(0, pos) + "*" + expression.substring(pos);
                return calc(expression);
            }
            return calc(expression);

        } else if (Utility.isValidExpression(expression, "cos")) {
            pos = Utility.getPosition(expression, "cos");
            if (pos == 0 || (expression.charAt(pos - 1) == '*' && pos - 1 > 0)) {
                pos += 2;

                String number = Utility.extractNumber(expression, pos, Utility.RIGHT_DIRECTION);
                expression = expression.replace("cos" + number,
                        Double.toString(Math.cos(Double.parseDouble(number))));
            } else {
                expression = expression.substring(0, pos) + "*" + expression.substring(pos);
                return calc(expression);
            }
            return calc(expression);

        } else if (Utility.isValidExpression(expression, "exp")) {
            pos = Utility.getPosition(expression, "exp");
            if(pos == 0 || (expression.charAt(pos-1) == '*' && pos-1>0)) {

                pos += 2;

                String number = Utility.extractNumber(expression, pos, Utility.RIGHT_DIRECTION);
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

            String leftNum = Utility.extractNumber(expression, pos, Utility.LEFT_DIRECTION);
            String rightNum = Utility.extractNumber(expression, pos, Utility.RIGHT_DIRECTION);
            if (leftNum.equals(String.valueOf(Utility.syntaxError)) || rightNum.equals(String.valueOf(Utility.syntaxError))) {
                return String.valueOf(Utility.syntaxError);
            }

            expression = expression.replace(leftNum + divider + rightNum,
                    calcShortExpr(leftNum, rightNum, divider));

            return calc(expression);

        } else if (expression.indexOf("-", 1) > 0) {
            pos = expression.indexOf("-", 1);

            char divider = expression.charAt(pos);

            if (expression.charAt(0) == '-') {
                String numberLeft = Utility.extractNumber(expression, 0, Utility.RIGHT_DIRECTION);
                int operatorPosition = numberLeft.length() + 1;
                String numberRight = Utility.extractNumber(expression, operatorPosition, Utility.RIGHT_DIRECTION);
                char operation = expression.charAt(operatorPosition);

                expression = expression.replace("-" + numberLeft + operation + numberRight,
                        addition(expression, operatorPosition, numberLeft, numberRight));
            } else {
                String leftNum = Utility.extractNumber(expression, pos, Utility.LEFT_DIRECTION);
                String rightNum = Utility.extractNumber(expression, pos, Utility.RIGHT_DIRECTION);
                expression = expression.replace(leftNum + divider + rightNum,
                        calcShortExpr(leftNum, rightNum, divider));
            }
            return calc(expression);
        } else if (expression.indexOf("+") > 0) {
            pos = expression.indexOf("+");
            char divider = expression.charAt(pos);

            if (expression.charAt(0) == '-') {
                String numberLeft = Utility.extractNumber(expression, 0, Utility.RIGHT_DIRECTION);
                int operatorPosition = numberLeft.length() + 1;
                String numberRight = Utility.extractNumber(expression, operatorPosition, Utility.RIGHT_DIRECTION);
                char operation = expression.charAt(operatorPosition);

                expression = expression.replace("-" + numberLeft + operation + numberRight,
                        addition(expression, operatorPosition, numberLeft, numberRight));
            } else {
                String leftNum = Utility.extractNumber(expression, pos, Utility.LEFT_DIRECTION);
                String rightNum = Utility.extractNumber(expression, pos, Utility.RIGHT_DIRECTION);
                expression = expression.replace(leftNum + divider + rightNum,
                        calcShortExpr(leftNum, rightNum, divider));
            }
            return calc(expression);

        } else return expression;
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
