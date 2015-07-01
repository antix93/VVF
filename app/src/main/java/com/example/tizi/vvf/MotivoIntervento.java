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
        IncBtn.setOnClickListener(new View.OnClickListener() {
            int C1=0;
            public void onClick(View v) {
                if (C1==0){
                    IncBtn.setBackgroundColor(Color.GREEN);
                    C1 = 1;
                }else{
                    IncBtn.setBackgroundColor(Color.GRAY);
                    C1=0;
                }

            }
        });

        //Bottone Personale 2
        final Button IncidBtn = (Button) findViewById(R.id.IncBtb);
        IncidBtn.setOnClickListener(new View.OnClickListener() {
            int C2=0;
            public void onClick(View v) {
                if (C2==0){
                    IncidBtn.setBackgroundColor(Color.GREEN);
                    C2 = 1;
                }else{
                    IncidBtn.setBackgroundColor(Color.GRAY);
                    C2=0;
                }

            }
        });

        //Bottone Personale 3
        final Button SocPer = (Button) findViewById(R.id.SocBtn);
        SocPer.setOnClickListener(new View.OnClickListener() {
            int C3=0;
            public void onClick(View v) {
                if (C3==0){
                    SocPer.setBackgroundColor(Color.GREEN);
                    C3 = 1;
                }else{
                    SocPer.setBackgroundColor(Color.GRAY);
                    C3=0;
                }

            }
        });

        //Bottone Personale 4
        final Button LavStra = (Button) findViewById(R.id.LavBtn);
        LavStra.setOnClickListener(new View.OnClickListener() {
            int C4=0;
            public void onClick(View v) {
                if (C4==0){
                    LavStra.setBackgroundColor(Color.GREEN);
                    C4 = 1;
                }else{
                    LavStra.setBackgroundColor(Color.GRAY);
                    C4=0;
                }

            }
        });

        //Bottone Personale 5
        final Button ApePor = (Button) findViewById(R.id.ApeBtn);
        ApePor.setOnClickListener(new View.OnClickListener() {
            int C5=0;
            public void onClick(View v) {
                if (C5==0){
                    ApePor.setBackgroundColor(Color.GREEN);
                    C5 = 1;
                }else{
                    ApePor.setBackgroundColor(Color.GRAY);
                    C5=0;
                }

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
