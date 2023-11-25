package ru.samsung.itschool.mdev.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText objectA, objectB, objectC;
    public TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objectA = findViewById(R.id.a);
        objectB = findViewById(R.id.b);
        objectC = findViewById(R.id.c);
        res = findViewById(R.id.res);
        Button button = findViewById(R.id.run);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans = "error";
                double a = Double.parseDouble(objectA.getText().toString());
                double b = Double.parseDouble(objectB.getText().toString());
                double c = Double.parseDouble(objectC.getText().toString());

                if (a == 0) {
                    if (b == 0 && c == 0) {
                        ans = "any";
                    } else if (b == 0 && c != 0) {
                        ans = "none";
                    } else {
                        ans = String.valueOf((-c) / b);
                    }
                } else if (b == 0) {
                    if ((-c) / a < 0) {
                        ans = "none";
                    } else if ((-c) / a == 0) {
                        ans = "0.0";
                    } else {
                        ans = String.valueOf(Math.sqrt((-c) / a));
                    }
                } else {
                    double d = b * b - 4 * a * c;
                    if (d < 0) {
                        ans = "none";
                    } else if (d == 0) {
                        ans = String.valueOf((-b) / (2 * a));
                    }
                    else {
                        double r = ((-b) - Math.sqrt(d)) / (2 * a);
                        r = (r == 0) ? 0 : r;
                        ans = String.valueOf(r);
                        r = ((-b) + Math.sqrt(d)) / (2 * a);
                        r = (r == 0) ? 0 : r;
                        ans += " " + r;
                    }
                }
                res.setText(ans);
            }
        });
    }
}
