package lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laborator1_sma.R;

public class MainActivity_lifecycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecycle_layout);

    }

    public void clicked (View view ){
        switch (view.getId()){
            case R.id.buttonA:
                startActivity(new Intent(this, ActivityA.class));
            case R.id.buttonB:
                startActivity(new Intent(this, ActivityB.class));
            case R.id.buttonC:
                startActivity(new Intent(this, ActivityC.class));
        }

    }
}
