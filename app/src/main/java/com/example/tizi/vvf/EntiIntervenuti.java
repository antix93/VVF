package com.example.tizi.vvf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class EntiIntervenuti extends Activity {
    protected boolean[] choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enti_intervenuti);
        choice = new boolean[6];
        final Button AnnButton = (Button) findViewById(R.id.AnnBtn);
        final Button ConButton = (Button) findViewById(R.id.ConfBtn);
        final CheckBox carabinieri = (CheckBox) findViewById(R.id.CkbCar);
        final CheckBox polizia = (CheckBox) findViewById(R.id.CkbPol);
        final CheckBox vigili = (CheckBox) findViewById(R.id.CkbVig);
        final CheckBox soraka = (CheckBox) findViewById(R.id.Ckb118);
        final CheckBox finanza = (CheckBox) findViewById(R.id.CkbGdf);
        final CheckBox altro = (CheckBox) findViewById(R.id.checkAltro);
        final InterActivityData globalVariables = (InterActivityData) getApplicationContext();

        boolean[] previousResult = globalVariables.getEntiIntervento();
        if(previousResult != null) {
            if (previousResult[0]) carabinieri.setChecked(true);
            if (previousResult[1]) polizia.setChecked(true);
            if (previousResult[2]) vigili.setChecked(true);
            if (previousResult[3]) soraka.setChecked(true);
            if (previousResult[4]) finanza.setChecked(true);
            if (previousResult[5]) altro.setChecked(true);
        }

        AnnButton.setOnClickListener(new View.OnClickListener() {
                                         public void onClick(View v) {

                                             setResult(0);
                                             finish();
                                         }
                                     }
        );

        ConButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent resultIntent = new Intent();
                if (carabinieri.isChecked()) choice[0] = true;
                if (polizia.isChecked()) choice[1] = true;
                if (vigili.isChecked()) choice[2] = true;
                if (soraka.isChecked()) choice[3] = true;
                if (finanza.isChecked()) choice[4] = true;
                if (altro.isChecked()) choice[5] = true;
                globalVariables.setEntiIntervento(choice);
                setResult(1, resultIntent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enti_intervenuti, menu);
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
