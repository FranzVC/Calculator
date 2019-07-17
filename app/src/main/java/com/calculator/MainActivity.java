package com.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<Character> OPERATORS = new ArrayList<>
            (Arrays.asList('*', '/', '-', '+'));
    private static int RIGHT_DIRECTION = 1;
    private static int LEFT_DIRECTION = -1;

    String result = "";
    String values = "";

    TextView label_values;
    TextView label_result;
    Button btn_number1;
    Button btn_number2;
    Button btn_number3;
    Button btn_number4;
    Button btn_number5;
    Button btn_number6;
    Button btn_number7;
    Button btn_number8;
    Button btn_number9;
    Button btn_number0;
    Button btn_less;
    Button btn_plus;
    Button btn_multiplication;
    Button btn_division;
    Button btn_equals;
    Button btn_erase;
    Button btn_point;
    Button btn_parenthesisOpen;
    Button btn_parenthesisClose;
    Button btn_eraseAll;
    Switch switch_mode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        label_values = findViewById(R.id.label_values);
        label_result = findViewById(R.id.label_result);

        btn_number1 = findViewById(R.id.btn_numberOne);
        btn_number2 = findViewById(R.id.btn_numberTwo);
        btn_number3 = findViewById(R.id.btn_numberThree);
        btn_number4 = findViewById(R.id.btn_numberFour);
        btn_number5 = findViewById(R.id.btn_numberFive);
        btn_number6 = findViewById(R.id.btn_numberSix);
        btn_number7 = findViewById(R.id.btn_numberSeven);
        btn_number8 = findViewById(R.id.btn_numberEight);
        btn_number9 = findViewById(R.id.btn_numberNine);
        btn_number0 = findViewById(R.id.btn_numberZero);
        btn_less = findViewById(R.id.btn_subtraction);
        btn_plus = findViewById(R.id.btn_addition);
        btn_multiplication = findViewById(R.id.btn_multiplication);
        btn_division = findViewById(R.id.btn_division);
        btn_equals = findViewById(R.id.btn_equals);

        btn_erase = findViewById(R.id.btn_erase);
        btn_eraseAll = findViewById(R.id.btn_eraseAll);
        btn_point = findViewById(R.id.btn_point);
        btn_parenthesisOpen = findViewById(R.id.btn_parenthesisOpen);
        btn_parenthesisClose = findViewById(R.id.btn_parenthesisClose);
        switch_mode = findViewById(R.id.switch_mode);

        btn_number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "0";
                label_values.setText(values);
            }
        });

        btn_number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "1";
                label_values.setText(values);
                System.out.println(String.valueOf(2.0 - 3.0));
            }
        });

        btn_number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "2";
                label_values.setText(values);
            }
        });

        btn_number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "3";
                label_values.setText(values);
            }
        });

        btn_number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "4";
                label_values.setText(values);
            }
        });

        btn_number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "5";
                label_values.setText(values);
            }
        });

        btn_number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "6";
                label_values.setText(values);
            }
        });

        btn_number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "7";
                label_values.setText(values);
            }
        });

        btn_number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "8";
                label_values.setText(values);
            }
        });

        btn_number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "9";
                label_values.setText(values);
            }
        });

        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = "";
                if (!values.isEmpty()) {
                    values = prepareExpression(values);
                    result = calc(values);
                }
                label_result.setText(String.valueOf(result));
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "+";
                label_values.setText(values);
            }
        });

        btn_less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "-";
                label_values.setText(values);
            }
        });

        btn_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "*";
                label_values.setText(values);
            }
        });

        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "/";
                label_values.setText(values);
            }
        });

        btn_erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!values.isEmpty()) {
                    values = values.substring(0, values.length() - 1);
                    label_values.setText(values);
                    result = "";
                }
            }
        });

        btn_eraseAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = "";
                result = "";
                label_values.setText(values);
                label_result.setText(String.valueOf(result));
            }
        });

        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + ".";
                label_values.setText(values);
            }
        });

        btn_parenthesisOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "(";
                label_values.setText(values);
            }
        });

        btn_parenthesisClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + ")";
                label_values.setText(values);
            }
        });

        switch_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_mode.isChecked()) {
                    Intent intent = new Intent(MainActivity.this, AdvancedCalcActivity.class);
                    switch_mode.setText(R.string.modeAdvanced);
                    startActivity(intent);
                } else {
                    switch_mode.setText(R.string.modeBasic);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }

    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
    }

    private static String calc(String expression) {
        int pos = 0;
        //Extracting expression from braces, doing recursive call
        //replace braced expression on result of it solving
        if (-1 != (pos = expression.indexOf("("))) {

            String subexp = extractExpressionFromBraces(expression, pos);
            if (subexp.equals("Failure!"))
                return subexp;

            expression = expression.replace("(" + subexp + ")", calc(subexp));

            return calc(expression);

            //Three states for calculating sin cos exp
            //input must be like sin0.7
        } else if (-1 != (pos = expression.indexOf("sin"))) {
            pos += 2;//shift index to last symbol of "sin" instead of first
            String number = extractNumber(expression, pos, RIGHT_DIRECTION);
            expression = expression.replace("sin" + number,
                    Double.toString(Math.sin(Double.parseDouble(number))));

            return calc(expression);

        } else if (-1 != (pos = expression.indexOf("cos"))) {
            pos += 2;
            String number = extractNumber(expression, pos, RIGHT_DIRECTION);
            expression = expression.replace("cos" + number,
                    Double.toString(Math.cos(Double.parseDouble(number))));

            return calc(expression);

        } else if (-1 != (pos = expression.indexOf("exp"))) {

            pos += 2;
            String number = extractNumber(expression, pos, RIGHT_DIRECTION);
            expression = expression.replace("exp" + number,
                    Double.toString(Math.exp(Double.parseDouble(number))));

            return calc(expression);

        } else if (expression.indexOf("*") > 0 | expression.indexOf("/") > 0) {

            int multPos = expression.indexOf("*");
            int divPos = expression.indexOf("/");

            pos = Math.min(multPos, divPos);
            if (multPos < 0) pos = divPos;
            else if (divPos < 0) pos = multPos;
            //If one value of
            //*Pos will be -1 result of min will be incorrect.

            char divider = expression.charAt(pos);

            String leftNum = extractNumber(expression, pos, LEFT_DIRECTION);
            String rightNum = extractNumber(expression, pos, RIGHT_DIRECTION);
            if (leftNum.equals("Failure!") || rightNum.equals("Failure!")) {
                return "Failure!";
            }

            expression = expression.replace(leftNum + divider + rightNum,
                    calcShortExpr(leftNum, rightNum, divider));

            return calc(expression);

        } else if (expression.indexOf("+") > 0 | expression.indexOf("-", 1) > 0) {
            int sumPos = expression.indexOf("+");
            int minusPos = expression.indexOf("-");

            pos = Math.min(sumPos, minusPos);

            if (sumPos < 0) pos = minusPos;
            else if (minusPos < 0) pos = sumPos;

            char divider = expression.charAt(pos);

            //first expression number negative
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

    private static String extractExpressionFromBraces(String expression, int pos) {
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
        return "Failure!";
    }

    private static String extractNumber(String expression, int pos, int direction) {
        String resultNumber = "";
        int currPos = pos + direction;//shift pos on next symbol from divider

        if (currPos < expression.length() && currPos >= 0) {
            //For negative numbers
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
        return "Failure!";
    }

    private static String calcShortExpr(String leftNum, String rightNum, char divider) {
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

    private static String prepareExpression(String expression) {
        expression = expression.replace("PI", Double.toString(Math.PI));
        expression = expression.replace("E", Double.toString(Math.E));
        expression = expression.replace(" ", "");

        return expression;
    }

    private static String addition(String expression, int operatorPosition, String numberLeft, String numberRight) {
        if (expression.charAt(operatorPosition) == '-') {
            return "-" + (Double.parseDouble(numberLeft) +
                    Double.parseDouble(numberRight));
        } else {
            return String.valueOf(Double.parseDouble(numberRight) -
                    Double.parseDouble(numberLeft));
        }
    }
}