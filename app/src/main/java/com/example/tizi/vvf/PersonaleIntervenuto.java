package com.example.tizi.vvf;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class PersonaleIntervenuto extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personale_intervenuto);

        //Bottone Personale 1
        final Button PerBtn1 = (Button) findViewById(R.id.PerBtn1);
        PerBtn1.setOnClickListener(new View.OnClickListener() {
        int C1=0;
            public void onClick(View v) {
                if (C1==0){
                    PerBtn1.setBackgroundColor(Color.GREEN);
                    C1 = 1;
                }else{
                    PerBtn1.setBackgroundColor(Color.GRAY);
                    C1=0;
                }

            }
        });

        //Bottone Personale 2
        final Button PerBtn2 = (Button) findViewById(R.id.PerBtn2);
        PerBtn2.setOnClickListener(new View.OnClickListener() {
            int C2=0;
            public void onClick(View v) {
                if (C2==0){
                    PerBtn2.setBackgroundColor(Color.GREEN);
                    C2 = 1;
                }else{
                    PerBtn2.setBackgroundColor(Color.GRAY);
                    C2=0;
                }

            }
        });

        //Bottone Personale 3
        final Button PerBtn3 = (Button) findViewById(R.id.PerBtn3);
        PerBtn3.setOnClickListener(new View.OnClickListener() {
            int C3=0;
            public void onClick(View v) {
                if (C3==0){
                    PerBtn3.setBackgroundColor(Color.GREEN);
                    C3 = 1;
                }else{
                    PerBtn3.setBackgroundColor(Color.GRAY);
                    C3=0;
                }

            }
        });

        //Bottone Personale 4
        final Button PerBtn4 = (Button) findViewById(R.id.PerBtn4);
        PerBtn4.setOnClickListener(new View.OnClickListener() {
            int C4=0;
            public void onClick(View v) {
                if (C4==0){
                    PerBtn4.setBackgroundColor(Color.GREEN);
                    C4 = 1;
                }else{
                    PerBtn4.setBackgroundColor(Color.GRAY);
                    C4=0;
                }

            }
        });

        //Bottone Personale 5
        final Button PerBtn5 = (Button) findViewById(R.id.PerBtn5);
        PerBtn5.setOnClickListener(new View.OnClickListener() {
            int C5=0;
            public void onClick(View v) {
                if (C5==0){
                    PerBtn5.setBackgroundColor(Color.GREEN);
                    C5 = 1;
                }else{
                    PerBtn5.setBackgroundColor(Color.GRAY);
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
        getMenuInflater().inflate(R.menu.menu_personale_intervenuto, menu);
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
