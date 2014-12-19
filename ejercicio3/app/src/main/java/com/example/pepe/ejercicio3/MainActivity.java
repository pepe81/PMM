package com.example.pepe.ejercicio3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioButton rojo = (RadioButton)findViewById(R.id.rbRojo);
        final RadioButton azul = (RadioButton)findViewById(R.id.rbAzul);
        final RadioButton verde = (RadioButton)findViewById(R.id.rbVerde);
        final TextView pantalla = (TextView)findViewById(R.id.tvPantalla);
        final RadioGroup colores = (RadioGroup)findViewById(R.id.rgColores);

        colores.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if(rojo.isChecked())
                {
                    Toast.makeText(getBaseContext(),"Has seleccionado el color rojo",Toast.LENGTH_SHORT).show();
                    pantalla.setBackgroundColor(Color.RED);
                }
                if(azul.isChecked())
                {
                    Toast.makeText(getBaseContext(),"Has seleccionado el color azul",Toast.LENGTH_SHORT).show();
                    pantalla.setBackgroundColor(Color.BLUE);
                }
                if(verde.isChecked())
                {
                    Toast.makeText(getBaseContext(),"Has seleccionado el color verde",Toast.LENGTH_SHORT).show();
                    pantalla.setBackgroundColor(Color.GREEN);
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
