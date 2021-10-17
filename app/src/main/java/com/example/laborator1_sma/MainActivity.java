package com.example.laborator1_sma;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    Button bClick;
    Button bPopup;
    Button closePopupBtn;
    Button bSearch, bShare;

    EditText eName;

    TextView tName;
    TextView popup_text;

    ConstraintLayout main_page;

    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_page = findViewById(R.id.main_page);
        bClick = findViewById(R.id.bClick);
        bPopup = findViewById(R.id.bPopup);
        eName = findViewById(R.id.eName);
        tName = findViewById(R.id.tName);

        builder = new AlertDialog.Builder(this);

        bClick.setOnClickListener(v -> {
            String message = "Hello, " + eName.getText().toString() + "!";
            tName.setText(message);

        });

        //4 -> task 1

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        bClick.setBackgroundColor(Color.parseColor("#AC1B1B"));
                        break;
                    case 1:
                        //Toast.makeText(parent.getContext(), "Red!", Toast.LENGTH_SHORT).show();
                        bClick.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        bClick.setBackgroundColor(Color.BLUE);
                        break;
                    case 3:
                        bClick.setBackgroundColor(Color.GREEN);
                        break;
                    case 4:
                        bClick.setBackgroundColor(Color.BLACK);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });

        bPopup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //instantiate the popup.xml layout file

                LayoutInflater layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.popup_firstpage, null);

                closePopupBtn = customView.findViewById(R.id.closePopupBtn);

                //instantiate popup window
                PopupWindow popupWindow = new PopupWindow(customView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                popup_text = popupWindow.getContentView().findViewById(R.id.popup_text);

                //display the popup window
                popupWindow.showAtLocation(main_page, Gravity.CENTER, 0, 0);

                popup_text.setText("Hello, " + eName.getText().toString() + "!");

                closePopupBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        builder.setMessage("Do you want to close it?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // finish();
                                        Toast.makeText(getApplicationContext(), "you choose yes action for alertbox",
                                                Toast.LENGTH_SHORT).show();
                                        popupWindow.dismiss();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //  Action for 'NO' Button
                                        dialog.cancel();
                                        Toast.makeText(getApplicationContext(), "you choose no action for alertbox",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                });
                        //Creating dialog box
                        AlertDialog alert = builder.create();
                        //Setting the title manually
                        alert.setTitle("You will close this popup window :?");
                        alert.show();

                        //   popupWindow.dismiss();
                    }
                });

            }
        });

        // 6 -> task2

        bSearch = findViewById(R.id.bSearch);
        bShare = findViewById(R.id.bShare);

        bSearch.setOnClickListener(v -> {

            try {
                String escapedQuery = URLEncoder.encode(eName.getText().toString(), "UTF-8");
                Uri url_search = Uri.parse("https://www.google.com/search?q=" + escapedQuery);

                Intent openBrowser = new Intent(Intent.ACTION_VIEW, url_search);
                startActivity(openBrowser);

            }  catch (UnsupportedEncodingException e) {
                throw new IllegalStateException(e.getMessage(), e);
            }

        });

        //adtion _ send
        bShare.setOnClickListener(v -> {
            Intent shareEName = new Intent(Intent.ACTION_SEND);
            shareEName.putExtra(Intent.EXTRA_TEXT, eName.getText().toString());
            shareEName.setType("text/plain");

            Intent receiver = new Intent(this, ApplicationSelectorReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, receiver, PendingIntent.FLAG_UPDATE_CURRENT);
            Intent chooser = Intent.createChooser(shareEName, null, pendingIntent.getIntentSender());
            startActivity(chooser);

        });


    }


}