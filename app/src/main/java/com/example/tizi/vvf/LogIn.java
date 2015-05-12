package com.example.tizi.vvf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class LogIn extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        final Button OkButton = (Button) findViewById(R.id.OkBtn);

        OkButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Toast toast = Toast.makeText(getApplicationContext(),"Sei stato autenticato",Toast.LENGTH_LONG);
                toast.show();

                Intent intent = new Intent(v.getContext(), MainMenu.class);
                startActivityForResult(intent, 0);
            }
        });
    }

}
