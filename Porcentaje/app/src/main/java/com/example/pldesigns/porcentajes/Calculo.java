package com.example.pldesigns.porcentajes;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class Calculo extends Activity
{

    TextView tvResultado;
    EditText edCantidad;
    EditText edPorcentaje;
    RadioGroup rg;
    RadioButton anadir;
    RadioButton quitar;

    float cantidad, porcentaje,resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        tvResultado = (TextView) findViewById(R.id.tvResultado);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        anadir = (RadioButton)findViewById(R.id.rbAnadir);
        quitar = (RadioButton)findViewById(R.id.rbQuitar);

        /*rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if(añadir.isChecked())
                {
                    edCantidad = (EditText) findViewById(R.id.etCantidad);
                    edPorcentaje = (EditText)findViewById(R.id.etPorcentaje);

                    cantidad = Float.parseFloat(edCantidad.getText().toString());
                    porcentaje = Float.parseFloat(edPorcentaje.getText().toString());

                    resultado = cantidad+(cantidad*(porcentaje/100));

                    tvResultado.setText(Float.toString(resultado));
                }
                if(quitar.isChecked())
                {
                    edCantidad = (EditText) findViewById(R.id.etCantidad);
                    edPorcentaje = (EditText)findViewById(R.id.etPorcentaje);

                    cantidad = Float.parseFloat(edCantidad.getText().toString());
                    porcentaje = Float.parseFloat(edPorcentaje.getText().toString());

                    resultado = cantidad-(cantidad*(porcentaje/100));

                    tvResultado.setText(Float.toString(resultado));
                }
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculo, menu);
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
