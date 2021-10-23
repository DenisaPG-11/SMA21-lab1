package lifecycle;

import android.os.Bundle;
import android.util.Log;
import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laborator1_sma.R;

public class ActivityC  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        setTitle("C");
        Log.d(TAG, "onCreate C");

    }

    @Override
    protected void onResume() {

        super.onResume();
        Log.d(TAG, "onResume C");

    }
}
