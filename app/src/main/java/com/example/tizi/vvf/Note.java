package com.example.tizi.vvf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;


public class Note extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        final Button AnnButton = (Button) findViewById(R.id.AnnBtn);
        final Button ConButton = (Button) findViewById(R.id.ConfBtn);
        final EditText NoteText = (EditText) findViewById(R.id.Note);
        final InterActivityData globalVariables = (InterActivityData) getApplicationContext();
        RelativeLayout layoutRelative = (RelativeLayout) findViewById(R.id.layoutRelative);

        String previousResult = globalVariables.getNoteIntervento();
        if(previousResult != null){
            NoteText.setText(previousResult);
        }

       //Annulla
        AnnButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(0);
                finish();
            }
        });

        //Conferma
        ConButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                globalVariables.setNoteIntervento(NoteText.getText().toString().trim());
                setResult(1);
                finish();
            }
        });

        /* Keyboard Hider on Touch */
        layoutRelative.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (NoteText.isFocused()) {
                    if (event.getY() >= 72) {
                        //Will only enter this if the EditText already has focus
                        //And if a touch event happens outside of the EditText
                        //Which in my case is at the top of my layout
                        //and 72 pixels long
                        NoteText.clearFocus();
                        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_note, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu){
        menu.getItem(0).setEnabled(false);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.IcoNome) {
            Intent intent = new Intent(this, DettUtente.class);
            startActivityForResult(intent, 0);
        }
        return super.onOptionsItemSelected(item);
    }
}
