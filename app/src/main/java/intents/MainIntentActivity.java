package intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laborator1_sma.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainIntentActivity extends AppCompatActivity {

    Button start_a, start_b, start_c, start_d ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_intent_activity);

        start_a = findViewById(R.id.start_a);
        start_b = findViewById(R.id.start_b);
        start_c = findViewById(R.id.start_c);
        start_d = findViewById(R.id.start_d);

        start_a.setOnClickListener(v -> {

            Uri url_search = Uri.parse("https://www.google.com");
            Intent openBrowser = new Intent(Intent.ACTION_VIEW, url_search);
            startActivity(openBrowser);

        });

        start_b.setOnClickListener(v -> {

            Uri url_search = Uri.parse("tel:00401213456");
            Intent openBrowser = new Intent(Intent.ACTION_VIEW, url_search);
            startActivity(openBrowser);

        });

        start_c.setOnClickListener(v -> {

            Uri url_search = Uri.parse("https://www.google.com");
            Intent openBrowser = new Intent(MSA.LAUNCH, url_search);
            startActivity(openBrowser);

        });

        start_d.setOnClickListener(v -> {

            Uri url_search = Uri.parse("tel:00401213456");
            Intent openBrowser = new Intent(MSA.LAUNCH, url_search);
            startActivity(openBrowser);

        });



    }

}