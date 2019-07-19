package com.calculator.utilities;

import java.util.ArrayList;
import java.util.Arrays;

public class Utility {

    private static ArrayList<Character> OPERATORS = new ArrayList<>
            (Arrays.asList('*', '/', '-', '+'));
    public static int RIGHT_DIRECTION = 1;
    public static int LEFT_DIRECTION = -1;
    public static String syntaxError = "Syntax Error";

    public static boolean isValidExpression(String expression, String operation) {
        return expression.contains(operation);
    }

    public static int getPosition(String expression, String operation) {
        return expression.indexOf(operation);
    }

    public static String extractExpressionFromBraces(String expression, int pos) {
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

    public static String prepareExpression(String expression) {
        expression = expression.replace("PI", "("+Double.toString(Math.PI)+")");
        //expression = expression.replace("E", Double.toString(Math.E));
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

    public static String extractNumber(String expression, int pos, int direction) {
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
}
