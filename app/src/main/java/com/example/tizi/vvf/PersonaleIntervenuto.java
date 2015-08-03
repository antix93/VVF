package com.example.tizi.vvf;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


public class PersonaleIntervenuto extends Activity {
        protected boolean[] choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        choice = new boolean[6];
        setContentView(R.layout.activity_personale_intervenuto);
        final CheckBox personale0 = (CheckBox) findViewById(R.id.CkbPer1);
        final CheckBox personale1 = (CheckBox) findViewById(R.id.CkbPer2);
        final CheckBox personale2 = (CheckBox) findViewById(R.id.CkbPer3);
        final CheckBox personale3 = (CheckBox) findViewById(R.id.CkbPer4);
        final CheckBox personale4 = (CheckBox) findViewById(R.id.CkbPer5);
        final CheckBox personale5 = (CheckBox) findViewById(R.id.CkbPer6);
        final Button AnnButton = (Button) findViewById(R.id.AnnBtn);
        final Button ConButton = (Button) findViewById(R.id.ConfBtn);
        final InterActivityData globalVariables = (InterActivityData) getApplicationContext();

        boolean[] previousResult = globalVariables.getPersonaleIntervento();
        if(previousResult != null) {
            if (previousResult[0]) personale0.setChecked(true);
            if (previousResult[1]) personale1.setChecked(true);
            if (previousResult[2]) personale2.setChecked(true);
            if (previousResult[3]) personale3.setChecked(true);
            if (previousResult[4]) personale4.setChecked(true);
            if (previousResult[5]) personale5.setChecked(true);
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
                if (personale0.isChecked()) choice[0] = true;
                if (personale1.isChecked()) choice[1] = true;
                if (personale2.isChecked()) choice[2] = true;
                if (personale3.isChecked()) choice[3] = true;
                if (personale4.isChecked()) choice[4] = true;
                if (personale5.isChecked()) choice[5] = true;
                globalVariables.setPersonaleIntervento(choice);
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
