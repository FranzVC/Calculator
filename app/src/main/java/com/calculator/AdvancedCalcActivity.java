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

public class AdvancedCalcActivity extends AppCompatActivity {

    private static ArrayList<Character> OPERATORS = new ArrayList<>
            (Arrays.asList('*', '/', '-', '+'));
    private static int RIGHT_DIRECTION = 1;
    private static int LEFT_DIRECTION = -1;

    double result = 0;
    String values = "";

    TextView label_values_adv;
    TextView label_result_adv;
    Button btn_number1_adv;
    Button btn_number2_adv;
    Button btn_number3_adv;
    Button btn_number4_adv;
    Button btn_number5_adv;
    Button btn_number6_adv;
    Button btn_number7_adv;
    Button btn_number8_adv;
    Button btn_number9_adv;
    Button btn_number0_adv;
    Button btn_less_adv;
    Button btn_plus_adv;
    Button btn_multiplication_adv;
    Button btn_division_adv;
    Button btn_equals_adv;
    Button btn_erase_adv;
    Button btn_point_adv;
    Button btn_parenthesisOpen_adv;
    Button btn_parenthesisClose_adv;
    Button btn_eraseAll_adv;
    Switch switch_mode_adv;
    Button btn_exponent;
    Button btn_PI;
    Button btn_cos;
    Button btn_sin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_calc);

        label_values_adv = findViewById(R.id.label_values_adv);
        label_result_adv = findViewById(R.id.label_result_adv);

        btn_number1_adv = findViewById(R.id.btn_numberOne_adv);
        btn_number2_adv = findViewById(R.id.btn_numberTwo_adv);
        btn_number3_adv = findViewById(R.id.btn_numberThree_adv);
        btn_number4_adv = findViewById(R.id.btn_numberFour_adv);
        btn_number5_adv = findViewById(R.id.btn_numberFive_adv);
        btn_number6_adv = findViewById(R.id.btn_numberSix_adv);
        btn_number7_adv = findViewById(R.id.btn_numberSeven_adv);
        btn_number8_adv = findViewById(R.id.btn_numberEight_adv);
        btn_number9_adv = findViewById(R.id.btn_numberNine_adv);
        btn_number0_adv = findViewById(R.id.btn_numberZero_adv);
        btn_less_adv = findViewById(R.id.btn_subtraction_adv);
        btn_plus_adv = findViewById(R.id.btn_addition_adv);
        btn_multiplication_adv = findViewById(R.id.btn_multiplication_adv);
        btn_division_adv = findViewById(R.id.btn_division_adv);
        btn_equals_adv = findViewById(R.id.btn_equals_adv);

        btn_erase_adv = findViewById(R.id.btn_erase_adv);
        btn_eraseAll_adv = findViewById(R.id.btn_eraseAll_adv);
        btn_point_adv = findViewById(R.id.btn_point_adv);
        btn_parenthesisOpen_adv = findViewById(R.id.btn_parenthesisOpen_adv);
        btn_parenthesisClose_adv = findViewById(R.id.btn_parenthesisClose_adv);
        switch_mode_adv = findViewById(R.id.switch_mode_adv);

        btn_cos = findViewById(R.id.btn_cos);
        btn_sin = findViewById(R.id.btn_sin);
        btn_exponent = findViewById(R.id.btn_exponent);
        btn_PI = findViewById(R.id.btn_Pi);

        btn_number0_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "0";
                label_values_adv.setText(values);
            }
        });

        btn_number1_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "1";
                label_values_adv.setText(values);
            }
        });

        btn_number2_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "2";
                label_values_adv.setText(values);
            }
        });

        btn_number3_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "3";
                label_values_adv.setText(values);
            }
        });

        btn_number4_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "4";
                label_values_adv.setText(values);
            }
        });

        btn_number5_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "5";
                label_values_adv.setText(values);
            }
        });

        btn_number6_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "6";
                label_values_adv.setText(values);
            }
        });

        btn_number7_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "7";
                label_values_adv.setText(values);
            }
        });

        btn_number8_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "8";
                label_values_adv.setText(values);
            }
        });

        btn_number9_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "9";
                label_values_adv.setText(values);
            }
        });

        btn_equals_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = 0;
                if (!values.isEmpty()) {
                    values = prepareExpression(values);
                    result = Double.valueOf(calc(values));
                }
                label_result_adv.setText(String.valueOf(result));
            }
        });

        btn_plus_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "+";
                label_values_adv.setText(values);
            }
        });

        btn_less_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "-";
                label_values_adv.setText(values);
            }
        });

        btn_multiplication_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "*";
                label_values_adv.setText(values);
            }
        });

        btn_division_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "/";
                label_values_adv.setText(values);
            }
        });

        btn_PI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "PI";
                label_values_adv.setText(values);
            }
        });

        btn_exponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "exp";
                label_values_adv.setText(values);
            }
        });

        btn_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "cos";
                label_values_adv.setText(values);
            }
        });

        btn_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "sin";
                label_values_adv.setText(values);
            }
        });

        btn_erase_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!values.isEmpty()) {
                    values = values.substring(0, values.length() - 1);
                    label_values_adv.setText(values);
                    result = 0;
                }
            }
        });

        btn_eraseAll_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = "";
                result = 0.0;
                label_values_adv.setText(values);
                label_result_adv.setText(String.valueOf(result));
            }
        });

        btn_point_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + ".";
                label_values_adv.setText(values);
            }
        });

        btn_parenthesisOpen_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "(";
                label_values_adv.setText(values);
            }
        });

        btn_parenthesisClose_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + ")";
                label_values_adv.setText(values);
            }
        });

        switch_mode_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_mode_adv.isChecked()) {
                    switch_mode_adv.setText(R.string.modeAdvanced);
                } else {
                    Intent intent = new Intent();
                    switch_mode_adv.setText(R.string.modeBasic);
                }
            }
        });
    }

    private static String calc(String expression) {
        int pos = 0;
        //Extracting expression from braces, doing recursive call
        //replace braced expression on result of it solving
        if (-1 != (pos = expression.indexOf("("))) {

            String subexp = extractExpressionFromBraces(expression, pos);
            expression = expression.replace("(" + subexp + ")", calc(subexp));

            return calc(expression);

            //Three states for calculating sin cos exp
            //input must be like sin0.7
        } else if (-1 != (pos = expression.indexOf("sin"))) {
            pos += 2;//shift index to last symbol of "sin" instead of first
            String number = extractNumber(expression, pos, RIGHT_DIRECTION);
            expression = expression.replace("sin" + number,
                    Double.toString(Math.sin(Math.toRadians(Double.parseDouble(number)))));
            System.out.println(Math.cos(90));

            return calc(expression);

        } else if (-1 != (pos = expression.indexOf("cos"))) {
            pos += 2;
            String number = extractNumber(expression, pos, RIGHT_DIRECTION);
            expression = expression.replace("cos" + number,
                    Double.toString(Math.cos(Math.toRadians(Double.parseDouble(number)))));

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

            expression = expression.replace(leftNum + divider + rightNum,
                    calcShortExpr(leftNum, rightNum, divider));

            return calc(expression);

        } else if (expression.indexOf("+") > 0 | expression.indexOf("-") > 0) {
            int sumPos = expression.indexOf("+");
            int minusPos = expression.indexOf("-");

            pos = Math.min(sumPos, minusPos);

            if (sumPos < 0) pos = minusPos;
            else if (minusPos < 0) pos = sumPos;

            char divider = expression.charAt(pos);

            String leftNum = extractNumber(expression, pos, LEFT_DIRECTION);
            String rightNum = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace(leftNum + divider + rightNum,
                    calcShortExpr(leftNum, rightNum, divider));

            return calc(expression);
        } else return expression;
    }

    private static String extractExpressionFromBraces(String expression, int pos) {
        int braceDepth = 1;
        String subexp = "";

        for (int i = pos + 1; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case '(':
                    braceDepth++;
                    subexp += "(";
                    break;
                case ')':
                    braceDepth--;
                    if (braceDepth != 0) subexp += ")";
                    break;
                default:
                    if (braceDepth > 0) subexp += expression.charAt(i);

            }
            if (braceDepth == 0 && !subexp.equals("")) return subexp;
        }
        //if (braceDepth > 0)
            return "Failure!";
    }

    private static String extractNumber(String expression, int pos, int direction) {
        String resultNumber = "";
        int currPos = pos + direction;//shift pos on next symbol from divider

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
}
