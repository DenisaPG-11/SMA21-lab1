package lifecycle;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laborator1_sma.R;

public class MainActivity_lifecycle extends AppCompatActivity {

    Button buttonA, buttonB, buttonC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);


        buttonA.setOnClickListener(v -> {

        });

        buttonB.setOnClickListener(v -> {

        });

        buttonC.setOnClickListener(v -> {

        });
    }
}
