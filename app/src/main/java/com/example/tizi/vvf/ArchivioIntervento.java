package com.example.tizi.vvf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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

                setResult(0);
                finish();

            }

            });

        final ListView listview = (ListView) findViewById(R.id.listViewArchivio);
        String[] values = new String[] { "Incendio 27/02/2015", "Incendio 25/02/2015", "Incendio 21/02/2015",
                "Incendio 27/02/2015", "Apertura Porta 27/01/2015", "Salvataggio 27/02/2013", "Incendio 27/02/2012", "Incendio 27/02/2011", "Incendio 27/02/2010",
                "Apertura Porta 20/02/2010"};

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);
/*
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent,  View v,
                                    int position, long id) {

                Intent intent = new Intent(v.getContext(), DettaglioIntervento.class);
                startActivity(intent);
            }

        });*/


    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_archivio_intervento, menu);
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

class StableArrayAdapter extends ArrayAdapter<String> {

    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public StableArrayAdapter(Context context, int textViewResourceId,
                              List<String> objects) {
        super(context, textViewResourceId, objects);
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
        }
    }

    @Override
    public long getItemId(int position) {
        String item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}
