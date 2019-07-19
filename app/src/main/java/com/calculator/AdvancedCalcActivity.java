package com.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class AdvancedCalcActivity extends AppCompatActivity {
    Calculator calculator = new Calculator();

    private static String syntaxError = "Syntax Error";
    private String result = "";
    private String values = "";

    TextView label_values_adv, label_result_adv;
    Button btn_number1_adv, btn_number2_adv, btn_number3_adv, btn_number4_adv, btn_number5_adv, btn_number6_adv, btn_number7_adv, btn_number8_adv,
            btn_number9_adv, btn_number0_adv;
    Button btn_less_adv, btn_plus_adv, btn_multiplication_adv, btn_division_adv, btn_equals_adv, btn_erase_adv,
            btn_point_adv, btn_parenthesisOpen_adv, btn_parenthesisClose_adv, btn_eraseAll_adv, btn_exponent;
    Button btn_PI, btn_cos, btn_sin;
    Switch switch_mode_adv;

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
                result = "";
                if (!values.isEmpty()) {
                    values = calculator.prepareExpression(values);
                    if (values.contains(syntaxError)) {
                        values = "";
                        label_values_adv.setText(values);
                        label_result_adv.setText(syntaxError);
                    } else {
                        result = calculator.calc(values);
                        label_result_adv.setText(String.valueOf(result));
                    }
                }
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
                    result = "";
                }
            }
        });

        btn_eraseAll_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = "";
                result = "";
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
                if (!switch_mode_adv.isChecked()) {
                    Intent intent = new Intent();
                    switch_mode_adv.setText(R.string.modeBasic);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
