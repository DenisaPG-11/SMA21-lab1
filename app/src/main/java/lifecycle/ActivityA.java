package lifecycle;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laborator1_sma.R;

public class ActivityA  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        setTitle("A");
        Log.d(TAG, "onCreate A");

    }

    @Override
    protected void onResume() {

        super.onResume();
        Log.d(TAG, "onResume A");

    }

}
