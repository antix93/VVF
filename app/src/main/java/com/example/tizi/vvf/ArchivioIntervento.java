package com.example.tizi.vvf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ArchivioIntervento extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archivio_intervento);
        /* list loading
        ListView listaElementi = (ListView) findViewById(R.id.ListViewArchivio);
        TextView elem1 = new TextView(getBaseContext());
        elem1.setText("Elemento 1");
        ArrayList<View> list = new ArrayList<View>();
        View item = (View) elem1;
        list.add(0, item);
        listaElementi.addTouchables(list);
        */
        Button annulla = (Button) findViewById(R.id.AnnullaArchivio);
        annulla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), MainMenu.class);
                startActivityForResult(intent, 0);

            }

            });

    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_archivio_intervento, menu);
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
