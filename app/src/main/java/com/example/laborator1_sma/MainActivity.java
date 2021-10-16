package com.example.laborator1_sma;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bClick ;
    Button bPopup ;
    EditText eName ;
    TextView tName ;
    TextView popup_text;
    ConstraintLayout main_page;
    Button closePopupBtn;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_page = findViewById(R.id.main_page);
        bClick =  findViewById(R.id.bClick);
        bPopup = findViewById(R.id.bPopup);
        eName =  findViewById(R.id.eName) ;
        tName =  findViewById(R.id.tName) ;

        builder = new AlertDialog.Builder(this);

        bClick.setOnClickListener(v -> {
            String message = "Hello, " + eName.getText().toString() + "!" ;
            tName.setText(message);

        });

        bPopup.setOnClickListener( new View.OnClickListener()  {

            @Override
            public void onClick(View v) {
                //instantiate the popup.xml layout file

                LayoutInflater layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.popup_firstpage,null);

                closePopupBtn = customView.findViewById(R.id.closePopupBtn);

                //instantiate popup window
                PopupWindow popupWindow = new PopupWindow(customView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                popup_text = popupWindow.getContentView().findViewById(R.id.popup_text);
                popup_text.setText("nu");

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
                                        Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                                Toast.LENGTH_SHORT).show();
                                        popupWindow.dismiss();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //  Action for 'NO' Button
                                        dialog.cancel();
                                        Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
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
    }
}