package com.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    double result = 0;
    String values = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Pattern pattern = Pattern.compile("\\d+");

        final List<Integer> list_results = new ArrayList<>();


        final TextView label_values = findViewById(R.id.label_values);
        final TextView label_result = findViewById(R.id.label_result);


        Button btn_number1 = findViewById(R.id.btn_numberOne);
        Button btn_number2 = findViewById(R.id.btn_numberTwo);
        Button btn_number3 = findViewById(R.id.btn_numberThree);
        Button btn_number4 = findViewById(R.id.btn_numberFour);
        Button btn_number5 = findViewById(R.id.btn_numberFive);
        Button btn_number6 = findViewById(R.id.btn_numberSix);
        Button btn_number7 = findViewById(R.id.btn_numberSeven);
        Button btn_number8 = findViewById(R.id.btn_numberEight);
        Button btn_number9 = findViewById(R.id.btn_numberNine);
        Button btn_number0 = findViewById(R.id.btn_numberZero);
        Button btn_less = findViewById(R.id.btn_subtraction);
        Button btn_plus = findViewById(R.id.btn_addition);
        Button btn_multiplication = findViewById(R.id.btn_multiplication);
        Button btn_division = findViewById(R.id.btn_division);
        Button btn_equals = findViewById(R.id.btn_equals);
        Button btn_erase = findViewById(R.id.btn_erase);

        btn_number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result > 0) {
                    values = values + "0";
                    label_values.setText(values);
                    //result = Integer.parseInt(values);
                }
            }
        });

        btn_number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "1";
                label_values.setText(values);
                //result = Double.parseDouble(values);
            }
        });

        btn_number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "2";
                label_values.setText(values);
                //result = Integer.parseInt(values);
            }
        });

        btn_number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "3";
                label_values.setText(values);
                //result = Integer.parseInt(values);
            }
        });

        btn_number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "4";
                label_values.setText(values);
                //result = Integer.parseInt(values);
            }
        });

        btn_number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "5";
                label_values.setText(values);
                //result = Integer.parseInt(values);
            }
        });

        btn_number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "6";
                label_values.setText(values);
                //result = Integer.parseInt(values);
            }
        });

        btn_number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "7";
                label_values.setText(values);
                //result = Integer.parseInt(values);
            }
        });

        btn_number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "8";
                label_values.setText(values);
                //result = Integer.parseInt(values);
            }
        });

        btn_number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values = values + "9";
                label_values.setText(values);
                //result = Integer.parseInt(values);
            }
        });

        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calcular result y luego mostrar

                label_result.setText(Double.toString(result));
                Matcher m = pattern.matcher(values);
                while (m.find()) {
                    System.out.println(m.group());
                    list_results.add(Integer.parseInt(m.group()));
                }

                for (int i = 0; i < values.length(); i++) {
                    if (values.charAt(i) > 9) {
                        switch (values.charAt(i))
                        {
                            case '+':
                                break;
                            case '-':
                                break;
                            case '*':
                                break;
                            case '/':
                                break;
                        }
                    }
                }
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
        //CE
        btn_erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!values.isEmpty()) {
                    values = values.substring(0, values.length() - 1);
                    label_values.setText(values);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

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
}