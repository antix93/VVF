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

import com.example.tizi.vvf.AuxiliaryClass.Anagrafica;

public class DettaglioAnagrafica extends Activity {
    protected Anagrafica data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettaglio_anagrafica);
        final EditText RicText = (EditText) findViewById(R.id.TxtRic);
        final EditText ProText = (EditText) findViewById(R.id.TxtPro);
        final EditText AffText = (EditText) findViewById(R.id.TxtAff);
        final EditText AltText = (EditText) findViewById(R.id.TxtAlt);
        final Button AnnButton = (Button) findViewById(R.id.AnnBtn);
        final Button ConButton = (Button) findViewById(R.id.ConfBtn);
        RelativeLayout layoutRelative = (RelativeLayout) findViewById(R.id.layoutRelative);
        final InterActivityData globalVariables = (InterActivityData) getApplicationContext();
        final Anagrafica previousResult = globalVariables.getAnagraficaIntervento();

        if(previousResult != null) {
                RicText.setText(previousResult.getRichiedente());
                ProText.setText(previousResult.getProprietario());
                AffText.setText(previousResult.getAffittuario());
                AltText.setText(previousResult.getAltro());
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
                data = new Anagrafica( RicText.getText().toString(), ProText.getText().toString(), AffText.getText().toString(), AltText.getText().toString());
                globalVariables.setAnagraficaIntervento(data);
                setResult(1);
                finish();
            }
        });

        /* Keyboard Hider on Touch */
        layoutRelative.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (RicText.isFocused() || ProText.isFocused() || AffText.isFocused() || AltText.isFocused()) {
                    if (event.getY() >= 72) {
                        //Will only enter this if the EditText already has focus
                        //And if a touch event happens outside of the EditText
                        //Which in my case is at the top of my layout
                        //and 72 pixels long
                        RicText.clearFocus();
                        ProText.clearFocus();
                        AffText.clearFocus();
                        AltText.clearFocus();
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
        getMenuInflater().inflate(R.menu.menu_dettaglio_anagrafica, menu);
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
