package com.example.tizi.vvf;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.tizi.vvf.AuxiliaryClass.Mezzo;

public class MezziIntervenuti extends Activity {
    public EditText[] km;
    public EditText[] lt;
    public CheckBox[] mezzo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mezzi_intervenuti);

        mezzo = new CheckBox[6];
        km = new EditText[6];
        lt = new EditText[6];

            for(int j=0; j<6; j++) {
                String distanceID = "km" + j;
                String literID = "lt" + j;
                String vehicleID = "Ckb" + j;
                int resdID = getResources().getIdentifier(distanceID, "id", getPackageName());
                int reslID = getResources().getIdentifier(literID, "id", getPackageName());
                int resvID = getResources().getIdentifier(vehicleID, "id", getPackageName());
                km[j] = ((EditText) findViewById(resdID));
                lt[j] = ((EditText) findViewById(reslID));
                mezzo[j] = ((CheckBox) findViewById(resvID));
            }

        final RelativeLayout layoutRelative = (RelativeLayout) findViewById(R.id.layoutRelative);
        final Button ConButton = (Button) findViewById(R.id.ConfBtn);
        final Button AnnButton = (Button) findViewById(R.id.AnnBtn);
        final InterActivityData globalVariables = (InterActivityData) getApplicationContext();
        Mezzo[] previousResult = globalVariables.getMezziIntervento();
        if (previousResult != null){
            //Preload Data
            for(int i = 0; i<6; i++){
                if(previousResult[i].checked){
                    mezzo[i].setChecked(true);
                    km[i].setText(previousResult[i].km);
                    km[i].setEnabled(true);
                    lt[i].setText(previousResult[i].lt);
                    lt[i].setEnabled(true);
                }
            }

        }
       for(int i = 0; i < 6; i++) {
           mezzo[i].setOnCheckedChangeListener(new MyCheckListener(i) {

                                                   @Override
                                                   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                                                                lt[getPosition()].setEnabled(isChecked);
                                                                km[getPosition()].setEnabled(isChecked);
                                                   }
                                               }
           );
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
                if(moduleError()){
                    AlertDialog alert = new AlertDialog.Builder(MezziIntervenuti.this).create();
                    alert.setTitle("Impossibile Confermare");
                    alert.setMessage("Compilare tutti i campi relativi ai mezzi selezionati");

                    alert.setButton(Dialog.BUTTON_POSITIVE, "Annulla", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alert.show();
                }else {
                    Mezzo[] result = new Mezzo[6];
                    for (int i = 0; i < 6; i++) {
                        result[i] = new Mezzo(mezzo[i].isChecked(), km[i].getText().toString(), lt[i].getText().toString());
                    }

                    globalVariables.setMezziIntervento(result);
                    setResult(1);
                    finish();
                }
            }
        });

        //Keyboard Hider on Touch

        layoutRelative.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                for(int i = 0; i<6;i++){
                    if (km[i].isFocused() || lt[i].isFocused()) {
                        if (event.getY() >= 72) {
                            //Will only enter this if the EditText already has focus
                            //And if a touch event happens outside of the EditText
                            //Which in my case is at the top of my layout
                            //and 72 pixels long

                            km[i].clearFocus();
                            lt[i].clearFocus();

                            InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                            return false;

                        }

                    }
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mezzi_intervenuti, menu);
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

    public boolean moduleError(){
        for(int i = 0; i< 6; i++){
            if(mezzo[i].isChecked() && (km[i].getText().toString().equals("")  || lt[i].getText().toString().equals("") )) return true;
        }
        return false;
    }
};

 class MyCheckListener implements CompoundButton.OnCheckedChangeListener {
        private int position;

        public MyCheckListener(int position) {
            this.position = position;
        }

     public int getPosition(){
         return position;
     }
        public void onCheckedChanged(CompoundButton buttonView,  boolean isChecked){
            return;
        }
        }