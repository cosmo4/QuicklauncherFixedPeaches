package org.westada.quicklauncher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuadraticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic);

        Button quadCalc = (Button) findViewById(R.id.quadCalc);
        quadCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAll();

            }
        });



    }
    public void setAll(){
        EditText num1 = (EditText) findViewById(R.id.x1);
        EditText num2 = (EditText) findViewById(R.id.x2);
        EditText num3 = (EditText) findViewById(R.id.x3);
        EditText num4 = (EditText) findViewById(R.id.y1);
        EditText num5 = (EditText) findViewById(R.id.y2);
        EditText num6 = (EditText) findViewById(R.id.y3);

        TextView aTextView = (TextView) findViewById(R.id.aTextView);
        double a = ((((getNumOne(num1) * (getNumSix(num6) - getNumFive(num5)))
                + (getNumTwo(num2) * (getNumFour(num4) - getNumSix(num6)))
                        + (getNumThree(num3) * (getNumFive(num5) - getNumFour(num4)))) /
                        ((getNumOne(num1) - getNumTwo(num2)) * (getNumOne(num1) - getNumThree(num3))
                        * (getNumTwo(num2) - getNumThree(num3)))));
        aTextView.setText(String.valueOf(a));

        TextView bTextView = (TextView)findViewById(R.id.bTextView);
        double b = (((getNumFive(num5) - getNumFour(num4)) / (getNumTwo(num2) - getNumOne(num1))) -
                (a * (getNumOne(num1) + getNumTwo(num2))));
        bTextView.setText(String.valueOf(b));

        TextView cTextView = (TextView)findViewById(R.id.cTextView);
        double c = (getNumFour(num4) - (a * Math.pow(getNumOne(num1), 2)) - (b * getNumOne(num1)));
        cTextView.setText(String.valueOf(c));
    }


    private double getNumOne(EditText num1) {

        return Double.parseDouble(num1.getText().toString());

    }
    private double getNumTwo(EditText num2) {

        return Double.parseDouble(num2.getText().toString());

    }
    private double getNumThree(EditText num3) {

        return Double.parseDouble(num3.getText().toString());

    }
    private double getNumFour(EditText num4) {

        return Double.parseDouble(num4.getText().toString());

    }
    private double getNumFive(EditText num5) {

        return Double.parseDouble(num5.getText().toString());

    }
    private double getNumSix(EditText num6) {

        return Double.parseDouble(num6.getText().toString());

    }


}
