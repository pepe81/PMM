package com.example.pldesigns.examen2eval;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity2 extends ActionBarActivity
{
    Double coste,peso;
    TextView tvCoste,tvZona,tvTarifa,tvPeso,tvDecoracion;
    ImageView image;
    Intent intent;
    String zona,tarifa,decoracion,precio,zonaBd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        coste = getIntent().getDoubleExtra("Precio", 0);
        zona = getIntent().getStringExtra("Zona");
        peso = getIntent().getDoubleExtra("Peso",0);
        tarifa = getIntent().getStringExtra("Tarifa");
        decoracion = getIntent().getStringExtra("Decoracion");

        System.out.println("Recibo precio = "+coste);

        image = (ImageView)findViewById(R.id.ivZona);
        tvCoste = (TextView)findViewById(R.id.tvCoste);
        tvDecoracion = (TextView)findViewById(R.id.tvDecoracion);
        tvZona = (TextView)findViewById(R.id.tvZona);
        tvTarifa = (TextView)findViewById(R.id.tvTarifa);
        tvPeso = (TextView)findViewById(R.id.tvPeso);

        if(zona.equals("A"))
        {
            image.setImageResource(R.drawable.asia_oceania);
        }
        else if (zona.equals("B"))
        {
            image.setImageResource(R.drawable.america_africa);
        }
        else if(zona.equals("C"))
        {
            image.setImageResource(R.drawable.europa);
        }
        tvCoste.setText(coste.toString()+" €.");
        tvDecoracion.setText(decoracion.toString());
        tvZona.setText(zona.toString());
        tvPeso.setText(peso.toString()+" kg.");
        tvTarifa.setText(tarifa.toString());
    }
    public void mandarDatos(Intent intent,String zona,String precio)
    {
        intent.putExtra("Zona", zona);
        intent.putExtra("Precio", precio);

        startActivity(intent);
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
        if (id == R.id.action_grabar)
        {
            precio = "Precio: "+coste.toString();
            zonaBd = "Zona: "+zona;
            intent = new Intent(MainActivity2.this,ListarBd.class);
            mandarDatos(intent,zonaBd,precio);

            return true;
        }
        if (id == R.id.action_dibujar)
        {
            intent = new Intent(MainActivity2.this,Dibujar.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
