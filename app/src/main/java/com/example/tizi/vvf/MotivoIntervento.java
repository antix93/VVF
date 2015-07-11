package com.example.tizi.vvf;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MotivoIntervento extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivo_intervento);

        //Bottone Personale 1
        final Button IncBtn = (Button) findViewById(R.id.IncendioBtn);
        final Button IncidBtn = (Button) findViewById(R.id.IncBtb);
        final Button SocPer = (Button) findViewById(R.id.SocBtn);
        final Button LavStra = (Button) findViewById(R.id.LavBtn);
        final Button ApePor = (Button) findViewById(R.id.ApeBtn);
        IncBtn.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                    resetButton(IncBtn, IncidBtn, SocPer, LavStra, ApePor);
                    IncBtn.setBackgroundColor(Color.GREEN);


            }
        });

        //Bottone Personale 2

        IncidBtn.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                    resetButton(IncBtn, IncidBtn, SocPer, LavStra, ApePor);
                    IncidBtn.setBackgroundColor(Color.GREEN);


            }
        });

        //Bottone Personale 3

        SocPer.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                    resetButton(IncBtn, IncidBtn, SocPer, LavStra, ApePor);
                    SocPer.setBackgroundColor(Color.GREEN);

            }
        });

        //Bottone Personale 4

        LavStra.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                    resetButton(IncBtn, IncidBtn, SocPer, LavStra, ApePor);
                    LavStra.setBackgroundColor(Color.GREEN);

            }
        });

        //Bottone Personale 5

        ApePor.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                    resetButton(IncBtn, IncidBtn, SocPer, LavStra, ApePor);
                    ApePor.setBackgroundColor(Color.GREEN);

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
                setResult(1);
                finish();
            }
        });

    }

    private void resetButton(Button incBtn, Button incidBtn, Button socPer, Button lavStra, Button apePor) {
        incBtn.setBackgroundColor(Color.GRAY);
        incidBtn.setBackgroundColor(Color.GRAY);
        socPer.setBackgroundColor(Color.GRAY);
        lavStra.setBackgroundColor(Color.GRAY);
        apePor.setBackgroundColor(Color.GRAY);
    }


    public boolean onPrepareOptionsMenu(Menu menu){
        menu.getItem(0).setEnabled(false);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_motivo_intervento, menu);
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
