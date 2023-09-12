package com.example.bmi_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editWeight, editHeight, editHeightIn;
        TextView txtResult;
        Button btnResult;
        LinearLayout liMain;

        editHeight = findViewById(R.id.editHeight);
        editHeightIn =findViewById(R.id.editHeightIn);
        editWeight = findViewById(R.id.editWeight);
        btnResult = findViewById(R.id.btnResult);
        txtResult = findViewById(R.id.txtResult);
        liMain = findViewById(R.id.liMain);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(editWeight.getText().toString());
                int ht = Integer.parseInt(editHeight.getText().toString());
                int hti = Integer.parseInt(editHeightIn.getText().toString());

                int totalIn =   ht*12+hti;
                double totalcm = totalIn*2.53;
                double  totalm = totalcm/100;
                double bmi = wt/(totalm*totalm);


                if(bmi > 24){
                    txtResult.setText("you are overweight");
                    liMain.setBackgroundColor(getResources().getColor(R.color.overW));
                } else if (bmi < 18) {
                    txtResult.setText("you are under Weight");
                    liMain.setBackgroundColor(getResources().getColor(R.color.underw));
                }
                else {
                    txtResult.setText("your are Normal");
                    liMain.setBackgroundColor(getResources().getColor(R.color.healthy));
                }

            }
        });

    }
}