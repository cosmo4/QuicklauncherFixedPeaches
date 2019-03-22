package org.westada.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Attempt to
        Button secondActivityBtn = (Button)findViewById(R.id.secondActivityBtn);
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startIntent.putExtra("org.westada.quicklauncher.SOMETHING", "HELLO WORLD! It's Luke Warner");
                startActivity(startIntent);
            }
        });

        Button googleBtn = (Button)findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "https://www.westada.org/ehs";
                Uri webaddress = Uri.parse(google);

                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
                if (gotoGoogle.resolveActivity(getPackageManager()) != null) {
                    startActivity(gotoGoogle);
                }
            }
        });

        Button slopeBtn = (Button)findViewById(R.id.slopeBtn);
        slopeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent slopeIntent = new Intent(getApplicationContext(), SlopeActivity.class);
                startActivity(slopeIntent);
            }
        });

        Button quadBtn = (Button)findViewById(R.id.quadBtn);
        quadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quadIntent = new Intent(getApplicationContext(), QuadraticActivity.class);
                startActivity(quadIntent);
            }
        });
    }
}
