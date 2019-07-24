package com.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Switch;
import android.widget.TextView;

import com.calculator.utilities.Utility;

public class AdvancedCalcActivity extends AppCompatActivity {
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

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        final Utility util = Utility.getInstance();
        final Calculator calculator = new Calculator();

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

        btn_equals_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = "";
                if (!values.isEmpty()) {
                    values = util.prepareExpression(values);
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
    }

    public void btn_number0_adv(View view) {
        values = values + "0";
        label_values_adv.setText(values);
    }

    public void btn_number1_adv(View view) {
        values = values + "1";
        label_values_adv.setText(values);
    }

    public void btn_number2_adv(View view) {
        values = values + "2";
        label_values_adv.setText(values);
    }

    public void btn_number3_adv(View view) {
        values = values + "3";
        label_values_adv.setText(values);
    }

    public void btn_number4_adv(View view) {
        values = values + "4";
        label_values_adv.setText(values);
    }

    public void btn_number5_adv(View view) {
        values = values + "5";
        label_values_adv.setText(values);
    }

    public void btn_number6_adv(View view) {
        values = values + "6";
        label_values_adv.setText(values);
    }

    public void btn_number7_adv(View view) {
        values = values + "7";
        label_values_adv.setText(values);
    }

    public void btn_number8_adv(View view) {
        values = values + "8";
        label_values_adv.setText(values);
    }

    public void btn_number9_adv(View view) {
        values = values + "9";
        label_values_adv.setText(values);
    }

    public void btn_plus_adv(View view) {
        values = values + "+";
        label_values_adv.setText(values);
    }

    public void btn_less_adv(View view) {
        values = values + "-";
        label_values_adv.setText(values);
    }

    public void btn_multiply_adv(View view) {
        values = values + "*";
        label_values_adv.setText(values);
    }

    public void btn_division_adv(View view) {
        values = values + "/";
        label_values_adv.setText(values);
    }

    public void btn_point_adv(View view) {
        values = values + ".";
        label_values_adv.setText(values);
    }

    public void btn_parenthesisOpen_adv(View view) {
        values = values + "(";
        label_values_adv.setText(values);
    }

    public void btn_parenthesisClose_adv(View view) {
        values = values + ")";
        label_values_adv.setText(values);
    }

    public void btn_PI(View view) {
        values = values + "PI";
        label_values_adv.setText(values);
    }

    public void btn_exp(View view) {
        values = values + "exp";
        label_values_adv.setText(values);
    }

    public void btn_sin(View view) {
        values = values + "sin";
        label_values_adv.setText(values);
    }

    public void btn_cos(View view) {
        values = values + "cos";
        label_values_adv.setText(values);
    }

    public void btn_eraseAll_adv(View view) {
        values = "";
        result = "";
        label_values_adv.setText(values);
        label_result_adv.setText(String.valueOf(result));
    }

    public void btn_erase_adv(View view) {
        if (!values.isEmpty()) {
            values = values.substring(0, values.length() - 1);
            label_values_adv.setText(values);
            result = "";
        }
    }

    public void switch_mode_adv(View view){
        if (!switch_mode_adv.isChecked()) {
            Intent intent = new Intent();
            switch_mode_adv.setText(R.string.modeBasic);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
