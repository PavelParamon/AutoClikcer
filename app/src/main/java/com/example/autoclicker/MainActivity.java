package com.example.autoclicker;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    static boolean stopFlag = true;
    static String pointX, pointY;
    EditText editTextX, editTextY;
    DisplayMetrics metrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextX = findViewById(R.id.editTextX);
        editTextY = findViewById(R.id.editTextY);
        Display display = getWindowManager().getDefaultDisplay();
        metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        startService(new Intent(this, PlayerService.class));
    }

    public void onClickBtnSave(View view) {
        if (!editTextX.getText().toString().equals("") && !editTextX.getText().toString().equals(pointX)) {
            if (Integer.parseInt(editTextX.getText().toString()) <= metrics.widthPixels)
                pointX = editTextX.getText().toString();
            else
                Toast.makeText(this, "The entered value X is larger then the screen size", Toast.LENGTH_SHORT).show();
        }

        if (!editTextY.getText().toString().equals("") && !editTextY.getText().toString().equals(pointY)) {
            if (Integer.parseInt(editTextY.getText().toString()) <= metrics.heightPixels)
                pointY = editTextY.getText().toString();
            else
                Toast.makeText(this, "The entered value Y is larger then the screen size", Toast.LENGTH_SHORT).show();
        }

    }
}
