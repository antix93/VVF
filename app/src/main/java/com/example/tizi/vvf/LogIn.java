package com.example.tizi.vvf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class LogIn extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        final Button OkButton = (Button) findViewById(R.id.OkBtn);

        OkButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Toast toast = Toast.makeText(getApplicationContext(), "Sei stato autenticato", Toast.LENGTH_LONG);
                toast.show();

                Intent intent = new Intent(v.getContext(), MainMenu.class);
                startActivityForResult(intent, 0);
            }
        });
        /* Keyboard Hider on Touch */
        RelativeLayout layoutRelative = (RelativeLayout) findViewById(R.id.layoutRelative);
        final EditText DistText = (EditText) findViewById(R.id.TxtDis);
        final EditText PassText = (EditText) findViewById(R.id.TxtPsw);
        layoutRelative.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (DistText.isFocused() || PassText.isFocused()) {
                    if (event.getY() >= 72) {
                        //Will only enter this if the EditText already has focus
                        //And if a touch event happens outside of the EditText
                        //Which in my case is at the top of my layout
                        //and 72 pixels long
                        DistText.clearFocus();
                        PassText.clearFocus();
                        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }
                }
                return false;
            }
        });
    }


}
