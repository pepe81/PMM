package com.example.pepe.joselopezexamenprimeraev;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button operar = (Button)findViewById(R.id.btOperar);
        final RadioButton sumar = (RadioButton)findViewById(R.id.rbSumar);
        final RadioButton restar = (RadioButton)findViewById(R.id.rbRestar);
        final TextView resultado = (TextView)findViewById(R.id.tvResultado);
        final CheckBox pulsado = (CheckBox)findViewById(R.id.cbPulsa);
        final ImageView imagen = (ImageView)findViewById(R.id.imageView);

        operar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText valor1 = (EditText)findViewById(R.id.edValor1);
                EditText valor2 = (EditText)findViewById(R.id.edValor2);

                int v1 = (int) Double.parseDouble(valor1.getText().toString());
                int v2 = (int) Double.parseDouble(valor2.getText().toString());

                if (sumar.isChecked())
                {
                    int res = (v1+v2);
                    resultado.setText(res+"");
                }
                if (restar.isChecked())
                {
                    int res = (v1-v2);
                    resultado.setText(res+"");
                }
            }
        });
        pulsado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pulsado.isChecked())
                {
                    imagen.setVisibility(View.VISIBLE);
                }
                else
                {
                    imagen.setVisibility(View.INVISIBLE);
                };
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
