package com.example.pepe.ejercicio4;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends Activity {

    ToggleButton rojo;
    ToggleButton verde;
    ToggleButton azul;
    TextView pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rojo = (ToggleButton)findViewById(R.id.tbRojo);
        verde = (ToggleButton)findViewById(R.id.tbVerde);
        azul = (ToggleButton)findViewById(R.id.tbAzul);
        pantalla = (TextView)findViewById(R.id.tvPantalla);

        pantalla.setBackgroundColor(Color.BLACK);

        rojo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (rojo.isChecked())
                {
                    azul.setChecked(false);
                    verde.setChecked(false);
                    pantalla.setBackgroundColor(Color.RED);
                }
                else
                {
                    pantalla.setBackgroundColor(Color.BLACK);
                }
            }
        });
        azul.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(azul.isChecked())
                {
                    rojo.setChecked(false);
                    verde.setChecked(false);
                    pantalla.setBackgroundColor(Color.BLUE);
                }
                else
                {
                    pantalla.setBackgroundColor(Color.BLACK);
                }
            }
        });
        verde.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (verde.isChecked())
                {
                    azul.setChecked(false);
                    rojo.setChecked(false);
                    pantalla.setBackgroundColor(Color.GREEN);
                }
                else
                {
                    pantalla.setBackgroundColor(Color.BLACK);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
