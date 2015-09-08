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
import android.widget.Spinner;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;
import android.widget.NumberPicker;
import android.content.Context;

public class CercaIntervento extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerca_intervento);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final Button Back = (Button) findViewById(R.id.AnnBtn);
        final Button Confirm = (Button) findViewById(R.id.ConfBtn);
        final InterActivityData globalVariables = (InterActivityData) getApplicationContext();

        Back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                globalVariables.setMotivoRicerca(0);
                setResult(0);
                finish();
            }
        });

        Confirm.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                //To-Do -> link to a new activity that shows result based on filter choice
                int value = spinner.getSelectedItemPosition();
                value++;
                globalVariables.setMotivoRicerca(value);
                Intent intent = new Intent(v.getContext(), ArchivioIntervento.class);
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cerca_intervento, menu);
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
