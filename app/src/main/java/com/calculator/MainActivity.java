package com.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.calculator.utilities.Utility;

public class MainActivity extends AppCompatActivity {


    private int ACTIVITY2 = 123;
    private static String syntaxError = "Syntax Error";
    private String result = "";
    private String values = "";

    TextView label_values, label_result;
    Button btn_number1, btn_number2, btn_number3, btn_number4, btn_number5, btn_number6, btn_number7, btn_number8, btn_number9, btn_number0;
    Button btn_less, btn_plus, btn_multiplication, btn_division, btn_equals, btn_erase, btn_point, btn_parenthesisOpen, btn_parenthesisClose, btn_eraseAll;
    Switch switch_mode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY2) {
            if (resultCode == RESULT_OK) {
                switch_mode.setChecked(false);
                switch_mode.setText(R.string.modeBasic);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        final Utility util = Utility.getInstance();
        final Calculator calculator = new Calculator();

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

        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = "";
                if (!values.isEmpty()) {
                    values = util.prepareExpression(values);
                    if (values.contains(syntaxError)) {
                        values = "";
                        label_values.setText(values);
                        label_result.setText(syntaxError);
                    } else {
                        result = calculator.calc(values);
                        label_result.setText(String.valueOf(result));
                    }
                }
            }
        });
    }

    public void btn_number0(View view) {
        values = values + "0";
        label_values.setText(values);
    }

    public void btn_number1(View view) {
        values = values + "1";
        label_values.setText(values);
    }

    public void btn_number2(View view) {
        values = values + "2";
        label_values.setText(values);
    }

    public void btn_number3(View view) {
        values = values + "3";
        label_values.setText(values);
    }

    public void btn_number4(View view) {
        values = values + "4";
        label_values.setText(values);
    }

    public void btn_number5(View view) {
        values = values + "5";
        label_values.setText(values);
    }

    public void btn_number6(View view) {
        values = values + "6";
        label_values.setText(values);
    }

    public void btn_number7(View view) {
        values = values + "7";
        label_values.setText(values);
    }

    public void btn_number8(View view) {
        values = values + "8";
        label_values.setText(values);
    }

    public void btn_number9(View view) {
        values = values + "9";
        label_values.setText(values);
    }

    public void btn_plus(View view) {
        values = values + "+";
        label_values.setText(values);
    }

    public void btn_less(View view) {
        values = values + "-";
        label_values.setText(values);
    }

    public void btn_multiply(View view) {
        values = values + "*";
        label_values.setText(values);
    }

    public void btn_division(View view) {
        values = values + "/";
        label_values.setText(values);
    }

    public void btn_point(View view) {
        values = values + ".";
        label_values.setText(values);
    }

    public void btn_parenthesisOpen(View view) {
        values = values + "(";
        label_values.setText(values);
    }

    public void btn_parenthesisClose(View view) {
        values = values + ")";
        label_values.setText(values);
    }

    public void btn_eraseAll(View view) {
        values = "";
        result = "";
        label_values.setText(values);
        label_result.setText(String.valueOf(result));
    }

    public void btn_erase(View view) {
        if (!values.isEmpty()) {
            values = values.substring(0, values.length() - 1);
            label_values.setText(values);
            result = "";
        }
    }

    public void switch_mode(View view){
        if (switch_mode.isChecked()) {
            Intent intent = new Intent(MainActivity.this, AdvancedCalcActivity.class);
            switch_mode.setText(R.string.modeAdvanced);
            startActivityForResult(intent, ACTIVITY2);
        }
    }
}