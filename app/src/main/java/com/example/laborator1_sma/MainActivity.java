package com.example.laborator1_sma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bClick =  findViewById(R.id.bClick);
        EditText eName =  findViewById(R.id.eName) ;
        TextView tName =  findViewById(R.id.tName) ;

        bClick.setOnClickListener(v -> {
            String message = "Hello, " + eName.getText().toString() + "!" ;
            tName.setText(message);
        });
    }
}