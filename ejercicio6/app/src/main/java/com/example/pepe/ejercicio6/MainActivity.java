package com.example.pepe.ejercicio6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity
{
    public static final int COD_RESPUESTA2 = 2;
    public static final int COD_RESPUESTA3 = 3;
    Button act2,act3;
    TextView textView;
    Intent miIntent;
    Bundle miBundle;
    String mensaje;
    TextView tvMensaje;
    ImageView victoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        victoria = (ImageView)findViewById(R.id.ivVictoria);

        victoria.setVisibility(View.INVISIBLE);

        textView = (TextView)findViewById(R.id.tvPantalla1);
        tvMensaje = (TextView)findViewById(R.id.tvDevuelto);

        act2 = (Button)findViewById(R.id.btAct2);
        act3 = (Button)findViewById(R.id.btAct3);

  /*      if(savedInstanceState!=null)
        {
            String mensajeDevuelto = (String) savedInstanceState.get("DEVUELVO2");
            System.out.println("mensajeDevuelto "+mensajeDevuelto);
            textView.setText(mensajeDevuelto);

        }*/

        act2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                miIntent = new Intent(MainActivity.this,MainActivity2.class);
                mensaje = textView.getText().toString();
                miIntent.putExtra("TEXTO",mensaje);
                //paso texto textView a pantalla 2
                startActivityForResult(miIntent, COD_RESPUESTA2);
            }
        });
        act3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                miIntent = new Intent(MainActivity.this,MainActivity3.class);
                mensaje = textView.getText().toString();
                miIntent.putExtra("TEXTO",mensaje);
                //paso texto textView a pantalla 3
                startActivityForResult(miIntent,COD_RESPUESTA3);
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode,Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        switch (requestCode)
        {
            case COD_RESPUESTA2:
                /*Intent intentRecoger = getIntent();
                String mensajeDevuelto = intentRecoger.getStringExtra("DEVUELVO2");
                System.out.println("recojo"+mensajeDevuelto);*/
                //Haciendo "trampa"
                tvMensaje.setText("Vuelvo de Pantalla 2");
                victoria.setVisibility(View.VISIBLE);
                break;
            case COD_RESPUESTA3:
                /*Bundle bundle3 = miIntent.getExtras();
                textView.setText(bundle3.getString("TEXTO"));*/
                //Haciendo "trampa"
                tvMensaje.setText("Vuelvo de Pantalla 3");
                victoria.setVisibility(View.VISIBLE);
                break;

        }
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
