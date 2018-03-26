package com.example.drosi.tip_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double tipPercent;
    double totalTip;
    double mealTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare all the widgets within java code
        final EditText mealCost = (EditText)findViewById(R.id.edtMealCost);
        final Spinner tipSelector = (Spinner)findViewById(R.id.spinner_tips);
        final Button btnCalculate = (Button)findViewById(R.id.btnCalc);

        // Add the click listener to the button
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            final TextView txtTip = (TextView)findViewById(R.id.txtTotal);
            @Override
            public void onClick(View view) {
                mealTotal = Double.parseDouble(mealCost.getText().toString());
                DecimalFormat currency = new DecimalFormat("$###,###.##");

                // Switch through the spinners selections and assign a double value accordingly
                switch(tipSelector.getSelectedItem().toString()) {
                    case "5%":
                        tipPercent = 0.05;
                        break;
                    case "10%":
                        tipPercent = 0.1;
                        break;
                    case "15%":
                        tipPercent = 0.15;
                        break;
                    case "20%":
                        tipPercent = 0.2;
                        break;
                    case "25%":
                        tipPercent = 0.25;
                        break;
                    default:
                        tipPercent = 0;
                }
                // Calculate the total tip
                totalTip = mealTotal * tipPercent;

                // Display the total tip to the user nicely formatted
                txtTip.setText(currency.format(totalTip));
            }
        });

    }
}
