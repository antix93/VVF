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
        final InterActivityData globalVariables = (InterActivityData) getApplicationContext();
        String[] valuesDefault = new String[] { "Incendio 27/02/2015", "Apertura Porta 25/02/2015", "Incendio 21/02/2015",
                "Incendio 27/02/2015", "Incidente 27/01/2015", "Salvataggio 27/02/2013", "Incidente 27/02/2012", "Incendio 27/02/2011", "Incidente 27/02/2010",
                "Incendio 20/02/2010"};
        String[] valuesIncendio = new String[] { "Incendio 27/02/2015", "Incendio 25/02/2015", "Incendio 21/02/2015",
                "Incendio 27/02/2015", "Incendio 27/01/2015", "Incendio 27/02/2013", "Incendio 27/02/2012", "Incendio 27/02/2011", "Incendio 27/02/2010",
                "Incendio 20/02/2010"};
        String[] valuesApertura = new String[] { "Apertura 27/02/2015", "Apertura 25/02/2015", "Apertura 21/02/2015", "Apertura 27/02/2015", "Apertura 27/01/2015", "Apertura 27/02/2013", "Apertura 27/02/2012", "Apertura 27/02/2011", "Apertura 27/02/2010",
                "Apertura 20/02/2010"};
        String[] valuesIncidente = new String[] { "Incidente 27/02/2015", "Incidente 25/02/2015", "Incidente 21/02/2015","Incidente 27/02/2015", "Incidente 27/01/2015", "Incidente 27/02/2013", "Incidente 27/02/2012", "Incidente 27/02/2011", "Incidente 27/02/2010",
                "Incidente 20/02/2010"};
        String[] valuesSalvataggio = new String[] { "Salvataggio 27/02/2015", "Salvataggio 25/02/2015", "Salvataggio 21/02/2015",
                "Salvataggio 27/02/2015", "Salvataggio 27/01/2015", "Salvataggio 27/02/2013", "Salvataggio 27/02/2012", "Salvataggio 27/02/2011", "Salvataggio 27/02/2010",
                "Salvataggio 20/02/2010"};
        String[][] values = {valuesDefault, valuesIncendio, valuesApertura, valuesIncidente, valuesSalvataggio};
        int reasonIndex = globalVariables.getMotivoRicerca();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values[reasonIndex]);
        ListView listview = (ListView) findViewById(R.id.listViewArchivio);
        listview.setAdapter(adapter);

         AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // Do something in response to the click
                Intent intent = new Intent(v.getContext(), DettaglioArchivio.class);
                startActivity(intent);
            }
        };

        listview.setOnItemClickListener(mMessageClickedHandler);

        Button annulla2 = (Button) findViewById(R.id.AnnullaArchivio);
        annulla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(0);
                finish();
            }

        });
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
