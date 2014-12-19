package com.example.pepe.ejercicio6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity2 extends Activity {

    Button volver;
    String mensajeDevolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        volver = (Button)findViewById(R.id.btVolver2);

        /*Bundle bundle = getIntent().getExtras();
        mensajeDevolver = bundle.getString("TEXTO");*/
        volver.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent vuelveIntent = new Intent();
                Bundle vuelveBundle = new Bundle();
                String mensaje = "Pantalla 1, vuelvo de pantalla2";
                vuelveBundle.putString("DEVUELVO2",mensaje);
                vuelveIntent.putExtras(vuelveBundle);
                setResult(RESULT_OK,vuelveIntent);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
