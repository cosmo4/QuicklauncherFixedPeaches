package org.westada.lwarn4737;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAdd();

            }
        });

        Button subBtn = (Button) findViewById(R.id.subBtn);
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setsub();

            }
        });


        Button multBtn = (Button) findViewById(R.id.multBtn);
        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMult();
            }
        });


        Button divBtn = (Button) findViewById(R.id.divBtn);
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDiv();
            }
        });

        Button power = (Button) findViewById(R.id.power);
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNums();
            }
        });

        Button secPower = (Button) findViewById(R.id.secPower);
        secPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNums();
            }
        });

    }
    private double getNumOne(EditText num1) {

        return Double.parseDouble(num1.getText().toString());

    }
    private double getNumTwo(EditText num2) {

        return Double.parseDouble(num2.getText().toString());

    }
    private void setNums() {
        EditText num1 = (EditText) findViewById(R.id.firstNumEditText);
        EditText num2 = (EditText) findViewById(R.id.secondNumEditText);
        TextView res = (TextView) findViewById(R.id.resultTextView);
        res.setText(Math.pow(getNumOne(num1), getNumTwo(num2)) + "");
    }
    private void setsub() {
        EditText num1 = (EditText) findViewById(R.id.firstNumEditText);
        EditText num2 = (EditText) findViewById(R.id.secondNumEditText);
        TextView res = (TextView) findViewById(R.id.resultTextView);
        res.setText((getNumOne(num1) - getNumTwo(num2)) + "");

    }
    private void setAdd() {
        EditText num1 = (EditText) findViewById(R.id.firstNumEditText);
        EditText num2 = (EditText) findViewById(R.id.secondNumEditText);
        TextView res = (TextView) findViewById(R.id.resultTextView);
        res.setText(getNumOne(num1) + getNumTwo(num2) + "");
    }
    private void setMult() {
        EditText num1 = (EditText) findViewById(R.id.firstNumEditText);
        EditText num2 = (EditText) findViewById(R.id.secondNumEditText);
        TextView res = (TextView) findViewById(R.id.resultTextView);
        res.setText((getNumOne(num1) * getNumTwo(num2)) + "");
    }
    private void setDiv() {
        EditText num1 = (EditText) findViewById(R.id.firstNumEditText);
        EditText num2 = (EditText) findViewById(R.id.secondNumEditText);
        TextView res = (TextView) findViewById(R.id.resultTextView);
        res.setText(getNumOne(num1) / getNumTwo(num2) + "");
    }



}
