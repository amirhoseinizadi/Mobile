package com.amirlking.sumcalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);

        EditText num1_et = findViewById(R.id.num1_et);
        EditText num2_et = findViewById(R.id.num2_et);
        Button result_btn = findViewById(R.id.result_btn);
        TextView result_txt = findViewById(R.id.textView);
        RadioButton sum = findViewById(R.id.radioButton);
        RadioButton sub = findViewById(R.id.radioButton2);
        RadioButton mul = findViewById(R.id.radioButton3);
        RadioButton div = findViewById(R.id.radioButton4);

        result_btn.setOnClickListener(v -> {
                try {
                    int num1 = Integer.parseInt(num1_et.getText().toString());
                    int num2 = Integer.parseInt(num2_et.getText().toString());
                    double result= 0;
                    int res_int = 0;

                    if (sum.isChecked()){
                        result = num1 + num2;
                    }else if (sub.isChecked()){
                        result = num1 - num2;
                    }else if (mul.isChecked()){
                        result = num1 * num2;
                    } else{
                        if (num2 != 0){
                            result = (double) num1 / num2;
                        } else {
                            result_txt.setTextColor(getResources().getColor(R.color.red));
                            result_txt.setText("second number in divide always not be Zero");
                            Toast.makeText(calculator.this, "second number in divide always nit be Zero", Toast.LENGTH_SHORT).show();
                        }
                    }
                    if (!div.isChecked()){
                        res_int = (int) result;
                        result_txt.setTextColor(getResources().getColor(R.color.black));
                        result_txt.setText("Result :" + res_int);
                        Toast.makeText(calculator.this, "Result: " + res_int, Toast.LENGTH_SHORT).show();
                    }
                    else if (num2 != 0){
                        result_txt.setTextColor(getResources().getColor(R.color.black));
                        result_txt.setText("Result :" + result);
                        Toast.makeText(calculator.this, "Result: " + result, Toast.LENGTH_SHORT).show();
                    }

                } catch (NumberFormatException e) {
                    if(num1_et.getText().length() == 0 || num2_et.getText().length() == 0){
                        result_txt.setTextColor(getResources().getColor(R.color.red));
                        result_txt.setText("one or two input is Empty");
                        Toast.makeText(calculator.this, "one or two input is Empty" , Toast.LENGTH_SHORT).show();
                    } else {
                        result_txt.setTextColor(getResources().getColor(R.color.red));
                        result_txt.setText("Invalid input");
                        Toast.makeText(calculator.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    }
                }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}