package org.westada.quicklauncher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SlopeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slope);

        Button calcBtn = (Button)findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText x1 = (EditText)findViewById(R.id.xOneEditText);
                EditText y1 = (EditText)findViewById(R.id.yOneEditText);
                EditText y2 = (EditText)findViewById(R.id.y2EditText);
                EditText x2 = (EditText)findViewById(R.id.x2EditText);
                TextView slopeRes = (TextView)findViewById(R.id.slopeRes);
                double m = (((getYTwo(y2) - getYOne(y1)) / (getXTwo(x2) - getXOne(x1))));
                slopeRes.setText(String.valueOf(m));
                TextView yIntRes = (TextView)findViewById(R.id.yIntRes);
                double b = (getYTwo(y2) - (m * getXTwo(x2)));
                yIntRes.setText(String.valueOf(b));

            }
        });

    }

    private double getXOne(EditText x1) {

        return Double.parseDouble(x1.getText().toString());

    }
    private double getYOne(EditText y1) {

        return Double.parseDouble(y1.getText().toString());

    }
    private double getXTwo(EditText x2) {

        return Double.parseDouble(x2.getText().toString());

    }
    private double getYTwo(EditText y2) {

        return Double.parseDouble(y2.getText().toString());

    }
}
