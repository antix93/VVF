package com.example.tizi.vvf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;
import android.widget.NumberPicker;
import android.content.Context;


public class CercaIntervento extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerca_intervento);

        final Button Back = (Button) findViewById(R.id.BackButton);

        Back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), MainMenu.class);
                startActivityForResult(intent, 0);
            }
        });

        final Button Confirm = (Button) findViewById(R.id.ConfirmButton);

        Confirm.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //To-Do -> link to a new activity that shows result based on filter choice
                Intent intent = new Intent(v.getContext(), MainMenu.class);
                startActivityForResult(intent, 0);
            }
        });
        RelativeLayout layoutRelative = (RelativeLayout) findViewById(R.id.layoutRelative);
        final EditText searchEditText = (EditText) findViewById(R.id.Motivo);

        layoutRelative.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (searchEditText.isFocused()) {
                    if (event.getY() >= 72) {
                        //Will only enter this if the EditText already has focus
                        //And if a touch event happens outside of the EditText
                        //Which in my case is at the top of my layout
                        //and 72 pixels long
                        searchEditText.clearFocus();
                        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }
                }
                return false;
            }
        });
        /* final EditText Motivo = (EditText) findViewById(R.id.Motivo);
        Motivo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new NumberPicker(v.getContext());
            }
        }); */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cerca_intervento, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
