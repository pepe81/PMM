package com.example.pepe.ejercicio5;

import android.app.Activity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    RadioGroup grupo;
    RadioButton suma,resta;
    TextView pantalla;
    EditText uno, dos;
    int op1,op2;
    int resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grupo = (RadioGroup)findViewById(R.id.radioGroup);
        suma = (RadioButton)findViewById(R.id.rbSuma);
        resta = (RadioButton)findViewById(R.id.rbResta);
        pantalla = (TextView)findViewById(R.id.tvResultado);
        uno = (EditText)findViewById(R.id.etUno);
        dos = (EditText)findViewById(R.id.etDos);



        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                op1 = (int)Double.parseDouble(uno.getText().toString());
                op2 = (int)Double.parseDouble(dos.getText().toString());
                if(suma.isChecked())
                {
                    resultado = (op1+op2);
                    pantalla.setText("El resultado de la suma es: "+resultado);
                }
                if (resta.isChecked())
                {
                    resultado = (op1-op2);
                    pantalla.setText("El resultado de la resta es: "+resultado);
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
