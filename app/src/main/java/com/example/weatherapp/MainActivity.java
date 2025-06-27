package com.example.weatherapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button_getCityId, button_getWeatherByCityName, button_getWeatherByCityId;
    EditText et_datainput;
    ListView lv_weatherreport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button_getCityId = findViewById(R.id.button_getCityId);
        button_getWeatherByCityId = findViewById(R.id.button_getWeatherByCityId);
        button_getWeatherByCityName = findViewById(R.id.button_getWeatherByCityName);

        et_datainput = findViewById(R.id.et_datainput);

        lv_weatherreport = findViewById(R.id.lv_weatherreport);

        //click listeners for each button

        button_getWeatherByCityId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "You clicked me", Toast.LENGTH_SHORT).show();
            }
        });

        button_getCityId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked 1st", Toast.LENGTH_SHORT).show();
            }
        });

      button_getWeatherByCityName.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(MainActivity.this, "You typed " + et_datainput.getText().toString() , Toast.LENGTH_SHORT).show();
          }
      });
    }
}