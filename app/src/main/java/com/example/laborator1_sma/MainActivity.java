package com.example.laborator1_sma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends AppCompatActivity {

    Button bClick ;
    Button bPopup ;
    EditText eName ;
    TextView tName ;
    TextView popup_text;
    ConstraintLayout main_page;
    Button closePopupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_page = findViewById(R.id.main_page);
        bClick =  findViewById(R.id.bClick);
        bPopup = findViewById(R.id.bPopup);
        eName =  findViewById(R.id.eName) ;
        tName =  findViewById(R.id.tName) ;

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
                        popupWindow.dismiss();
                    }
                });

            }
        });
    }
}