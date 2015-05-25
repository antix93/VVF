package com.example.tizi.vvf;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import android.support.v4.app.FragmentActivity;

import java.util.Calendar;


public class orari extends FragmentActivity {

    static final int dialog_id = 0;
    int hour, minute;
    EditText EdUsc;
    EditText EdArr;
    EditText EdPar;
    EditText EdRie;
    EditText EdText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orari);

        //Ora Uscita
        EdUsc = (EditText) findViewById(R.id.TxtUsc);
        EdUsc.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                EdText = EdUsc;

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(EdUsc, InputMethodManager.SHOW_IMPLICIT);
                imm.hideSoftInputFromWindow(EdUsc.getWindowToken(), 0);

                showDialog(dialog_id);

            }
        });

        //Ora Arrivo
        EdArr = (EditText) findViewById(R.id.TxtArr);
        EdArr.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                EdText = EdArr;

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(EdArr, InputMethodManager.SHOW_IMPLICIT);
                imm.hideSoftInputFromWindow(EdArr.getWindowToken(), 0);

                showDialog(dialog_id);

            }
        });

        //Ora Partenza
        EdPar = (EditText) findViewById(R.id.TxtPar);
        EdPar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                EdText = EdPar;

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(EdPar, InputMethodManager.SHOW_IMPLICIT);
                imm.hideSoftInputFromWindow(EdPar.getWindowToken(), 0);

                showDialog(dialog_id);

            }
        });

        //Ora Rientro
        EdRie = (EditText) findViewById(R.id.TxtRie);
        EdRie.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                EdText = EdRie;

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(EdRie, InputMethodManager.SHOW_IMPLICIT);
                imm.hideSoftInputFromWindow(EdRie.getWindowToken(), 0);

                showDialog(dialog_id);

            }
        });

        //Annulla
        final Button AnnButton = (Button) findViewById(R.id.AnnBtn);
        AnnButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                setResult(0);
                finish();
            }
        });
        //Conferma
        final Button ConButton = (Button) findViewById(R.id.ConfBtn);
        ConButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("orario1", "22:30");
                setResult(1, resultIntent);
                finish();
            }
        });


    }

    public Dialog onCreateDialog(int id){

        Calendar calendar= Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        switch (id){
            case dialog_id:
               return new TimePickerDialog(this, mTimeSetListener, hour, minute, false );
        }

        return null;

    }

    protected  TimePickerDialog.OnTimeSetListener mTimeSetListener;

    {
        mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int hour_minute) {
                hour =  hourOfDay;
                minute = hour_minute;
                Toast.makeText(getBaseContext(), "Ora: " + hour + " minuti: " + minute, Toast.LENGTH_LONG).show();

                EdText.setText(hour + ":" + minute);

            }
        };
    }

    /*
    public void showDialog(View view){
        DialogHandler dialogHandler = new DialogHandler();
        dialogHandler.show(getFragmentManager(),"time_picker");

        //Ora senza keyboard

        EditText yourEditText= (EditText) findViewById(R.id.TxtUsc);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(yourEditText, InputMethodManager.SHOW_IMPLICIT);
        imm.hideSoftInputFromWindow(yourEditText.getWindowToken(), 0);
    }*/

    public boolean onPrepareOptionsMenu(Menu menu){
        menu.getItem(0).setEnabled(false);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_orari, menu);
        return true;
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
