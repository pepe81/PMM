package com.example.pepe.ejercicio6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity3 extends Activity {

    Button volver;
    String mensajeDevolver;
    String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);
        volver = (Button)findViewById(R.id.btVolver3);
        Intent intentRecoger = getIntent();
        final Intent intentDevolver = new Intent(MainActivity3.this,MainActivity.class);
        final String miValor = intentRecoger.getStringExtra("TEXTO");


        /*Bundle bundle = getIntent().getExtras();
        mensajeDevolver = bundle.getString("TEXTO");*/
        volver.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent vuelveIntent = new Intent(MainActivity3.this,MainActivity.class);
                Bundle vuelveBundle = new Bundle();
                mensaje = miValor + ", vuelvo de pantalla3";
                System.out.println(mensaje);
                vuelveBundle.putString("DEVUELVO2", mensaje);
                vuelveIntent.putExtras(vuelveBundle);
                setResult(RESULT_OK,vuelveIntent);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity3, menu);
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
