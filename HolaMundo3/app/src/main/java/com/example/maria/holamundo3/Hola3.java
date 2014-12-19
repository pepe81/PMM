package com.example.maria.holamundo3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.BLUE;


public class Hola3 extends Activity implements View.OnClickListener {
    public static int COD_RESPUESTA=0;

    TextView elSaludo;
    TextView pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola3);

        final EditText miTexto= (EditText)findViewById(R.id.miTxt);
        final Button miBoton= (Button)findViewById(R.id.miBtn);
        elSaludo= (TextView)findViewById(R.id.miLbl);

        //Si regreso de otra actividad
        if (savedInstanceState!=null)
        {
            String mensajePasado=savedInstanceState.getString("TEXTO");
            elSaludo.setText(mensajePasado);

        }
        //Borrar el texto inicial del EditText
        miTexto.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            public void onFocusChange(View v, boolean b)
            {
                if (b)  miTexto.setText("");

            }
        });

        miBoton.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent miIntent= new Intent(Hola3.this, Pantalla2.class);
                Bundle miBundle=new Bundle();
                String mensajePaso= "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent, COD_RESPUESTA);
                //elSaludo.setText(mensajePaso);
            }
        });

        Button boton1 = (Button) findViewById(R.id.miBtn1);
        pantalla = (TextView)findViewById(R.id.tvColores);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Has pulsado el boton Rojo.",Toast.LENGTH_SHORT).show();
                pantalla.setBackgroundColor(Color.RED);
            }
        });

        Button boton3 = (Button)findViewById(R.id.miBtn3);
        boton3.setOnClickListener(this);

        Button btAceptar = (Button)findViewById(R.id.btAceptar);

        btAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckColor();
            }
        });
    }

    @Override
    public void onClick(View v) {
        pantalla = (TextView)findViewById(R.id.tvColores);
        Toast.makeText(getBaseContext(),"Has pulsado el boton Verde.",Toast.LENGTH_SHORT).show();
        pantalla.setBackgroundColor(Color.GREEN);
    }

    public void miClick(View v)
    {
        pantalla = (TextView)findViewById(R.id.tvColores);
        Toast.makeText(getBaseContext(),"Has pulsado el boton Azul.",Toast.LENGTH_SHORT).show();
        pantalla.setBackgroundColor(Color.BLUE);
    }

    public void onActivityResult(int cod_resp, int cod_result,Intent intent)
    {
        if (cod_result== RESULT_OK)
        {
            Bundle otroBundle = intent.getExtras();
            elSaludo.setText(otroBundle.getString("DEVUELTO"));
        }
    }

    public void onCheckColor ()
    {
        RadioButton op1 = (RadioButton)findViewById(R.id.op1);
        RadioButton op2 = (RadioButton) findViewById(R.id.op2);
        RadioButton op3 = (RadioButton) findViewById(R.id.op3);

        if (op1.isChecked())
        {
            final TextView pantalla = (TextView)findViewById(R.id.tvColores);
            pantalla.setBackgroundColor(Color.RED);
        }
        if (op2.isChecked())
        {
            final TextView pantalla = (TextView)findViewById(R.id.tvColores);
            pantalla.setBackgroundColor(Color.BLUE);
        }
        if (op3.isChecked())
        {
            final TextView pantalla = (TextView)findViewById(R.id.tvColores);
            pantalla.setBackgroundColor(Color.GREEN);
        }
    }
}
