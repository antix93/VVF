package com.example.tizi.vvf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainMenu extends Activity {
    public Intervento[] interventi;
    private Button NuoInt;
    private Button CerBtn;
    private Button ArcBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        interventi = new Intervento[10];
        NuoInt = (Button) findViewById(R.id.NuoIntBtn);
        CerBtn = (Button) findViewById(R.id.CerBtn);
        ArcBtn = (Button) findViewById(R.id.ArcBtn);

        NuoInt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), NuovoIntervento.class);
                startActivityForResult(intent, 0);
            }
        });



        CerBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), CercaIntervento.class);
                startActivityForResult(intent, 1);
            }
        });



        ArcBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ArchivioIntervento.class);
                startActivityForResult(intent, 2);
            }
        });




    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 0) {
            if(resultCode == 0){
                //annulla
                //data.getStringExtra("prova");
                Toast toast = Toast.makeText(getApplicationContext(), "Annullato", Toast.LENGTH_LONG);
                toast.show();
                NuoInt.setText("Nuovo Intervento");
            }else{
                //nuovo
                if(resultCode == 1){
                    Toast toast = Toast.makeText(getApplicationContext(), "Confermato", Toast.LENGTH_LONG);
                    toast.show();
                    NuoInt.setText("Nuovo Intervento");
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Congelato", Toast.LENGTH_LONG);
                    toast.show();
                    NuoInt.setText("Continua Intervento");
                }
            }

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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
