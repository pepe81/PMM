package com.example.pepe.dibujosareas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity {

    String[]formas;
    Spinner sp;
    ArrayAdapter<CharSequence> adapter;
    TextView radio;
    TextView lado1;
    TextView lado2;
    EditText edRadio;
    EditText edLado1;
    EditText edLado2;
    Button dibujar;
    Intent miIntent;
    Bundle miBundleRadio;
    Bundle miBundleL1;
    Bundle miBundleL2;

    float l1,l2;
    float r;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        radio = (TextView) findViewById(R.id.textView);
        lado1 = (TextView) findViewById(R.id.tvLado1);
        lado2 = (TextView) findViewById(R.id.tvLado2);

        edRadio = (EditText) findViewById(R.id.edRadio);
        edLado1 = (EditText) findViewById(R.id.edLado1);
        edLado2 = (EditText) findViewById(R.id.edLado2);

        sp = (Spinner)findViewById(R.id.spinner);
        formas = getResources().getStringArray(R.array.formas);
        adapter = ArrayAdapter.createFromResource(this, R.array.formas, android.R.layout.simple_spinner_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if (formas[position].equals("Seleccionar"))
                {
                    radio.setVisibility(View.INVISIBLE);
                    edRadio.setVisibility(View.INVISIBLE);
                    lado1.setVisibility(View.INVISIBLE);
                    lado2.setVisibility(View.INVISIBLE);
                    edLado1.setVisibility(View.INVISIBLE);
                    edLado2.setVisibility(View.INVISIBLE);
                    dibujar.setVisibility(View.INVISIBLE);
                }
                if(formas[position].equals("Rectángulo"))
                {
                    lado1.setVisibility(View.VISIBLE);
                    lado2.setVisibility(View.VISIBLE);
                    edLado1.setVisibility(View.VISIBLE);
                    edLado2.setVisibility(View.VISIBLE);

                    radio.setVisibility(View.INVISIBLE);
                    edRadio.setVisibility(View.INVISIBLE);

                    dibujar.setVisibility(View.VISIBLE);

                    dibujar = (Button) findViewById(R.id.btDibujar);

                    dibujar.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            miIntent = new Intent(MyActivity.this,ActivityRectangulo.class);
                            l1 = Float.parseFloat(edLado1.getText().toString());
                            l2 = Float.parseFloat(edLado2.getText().toString());
                            miBundleL1 = new Bundle();
                            miBundleL1.putFloat("Lado1",l1);
                            miBundleL2 = new Bundle();
                            miBundleL2.putFloat("Lado2",l2);
                            miIntent.putExtras(miBundleL1);
                            miIntent.putExtras(miBundleL2);
                            startActivity(miIntent);
                        }
                    });
                }
                if(formas[position].equals("Círculo"))
                {
                    radio.setVisibility(View.VISIBLE);
                    edRadio.setVisibility(View.VISIBLE);

                    lado1.setVisibility(View.INVISIBLE);
                    lado2.setVisibility(View.INVISIBLE);
                    edLado1.setVisibility(View.INVISIBLE);
                    edLado2.setVisibility(View.INVISIBLE);

                    dibujar.setVisibility(View.VISIBLE);

                    dibujar.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            miIntent = new Intent(MyActivity.this,ActivityCirculo.class);
                            r = Float.parseFloat(edRadio.getText().toString());
                            miBundleRadio = new Bundle();
                            miBundleRadio.putFloat("RADIO",r);
                            miIntent.putExtras(miBundleRadio);
                            startActivity(miIntent);
                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
        sp.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_areas)
        {
            sp.setVisibility(View.VISIBLE);
            return true;
        }
        if(id == R.id.action_trazos)
        {
            sp.setVisibility(View.INVISIBLE);

            lado1.setVisibility(View.INVISIBLE);
            lado2.setVisibility(View.INVISIBLE);
            edLado1.setVisibility(View.INVISIBLE);
            edLado2.setVisibility(View.INVISIBLE);

            radio.setVisibility(View.INVISIBLE);
            edRadio.setVisibility(View.INVISIBLE);

            dibujar.setVisibility(View.INVISIBLE);

            Toast.makeText(getApplicationContext(),"En construcción",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
