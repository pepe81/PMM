package com.example.pldesigns.examen2eval;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    String[]zonas;
    Spinner sp;
    ArrayAdapter<CharSequence> adapter;
    Button btCalcular;
    EditText edPeso;
    CheckBox cbRegalo,cbTarjeta;
    Intent miIntent;
    Bundle miBundle1,miBundle2;
    RadioButton rbNormal,rbUrgente;

    Double precio,peso,tarifa,resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCalcular = (Button)findViewById(R.id.btCalcular);
        edPeso = (EditText)findViewById(R.id.editText);
        cbRegalo = (CheckBox)findViewById(R.id.cbRegalo);
        cbTarjeta = (CheckBox)findViewById(R.id.cbTarjeta);

        sp = (Spinner)findViewById(R.id.spZonas);
        zonas = getResources().getStringArray(R.array.zonas);
        adapter = ArrayAdapter.createFromResource(this, R.array.zonas, android.R.layout.simple_spinner_item);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(zonas[position].equals("Zona A"))
                {
                    btCalcular.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            miIntent = new Intent(MainActivity.this,MainActivity2.class);
                            peso = Double.parseDouble(edPeso.getText().toString());

                            if(peso<=5)
                            {
                                precio = (peso * 1)+30;
                            }
                            if(peso>5 && peso<=10)
                            {
                                precio = (peso * 1.5)+30;
                            }
                            if(peso>10)
                            {
                                precio = (peso * 2)+30;
                            }
                            if(rbUrgente.isChecked())
                            {
                                precio = precio+(precio*0.30);
                            }

                            miBundle1 = new Bundle();
                            miBundle1.putDouble("Precio", precio);
                            miIntent.putExtras(miBundle1);

                            startActivity(miIntent);
                        }
                    });
                }
                if(zonas[position].equals("Zona B"))
                {
                    btCalcular.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            miIntent = new Intent(MainActivity.this,MainActivity2.class);
                            peso = Double.parseDouble(edPeso.getText().toString());

                            if(peso<=5)
                            {
                                precio = (peso * 1)+20;
                            }
                            if(peso>5 && peso<=10)
                            {
                                precio = (peso * 1.5)+20;
                            }
                            if(peso>10)
                            {
                                precio = (peso * 2)+20;
                            }
                            if(rbUrgente.isChecked())
                            {
                                precio = precio+(precio*0.30);
                            }

                            miBundle1 = new Bundle();
                            miBundle1.putDouble("Precio", precio);
                            miIntent.putExtras(miBundle1);

                            startActivity(miIntent);
                        }
                    });
                }
                if(zonas[position].equals("Zona C"))
                {
                    btCalcular.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            miIntent = new Intent(MainActivity.this,MainActivity2.class);
                            peso = Double.parseDouble(edPeso.getText().toString());

                            if(peso<=5)
                            {
                                precio = (peso * 1)+10;
                            }
                            if(peso>5 && peso<=10)
                            {
                                precio = (peso * 1.5)+10;
                            }
                            if(peso>10)
                            {
                                precio = (peso * 2)+10;
                            }
                            if(rbUrgente.isChecked())
                            {
                                precio = precio+(precio*0.30);
                            }

                            miBundle1 = new Bundle();
                            miBundle1.putDouble("Precio", precio);
                            miIntent.putExtras(miBundle1);

                            startActivity(miIntent);
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }//Por no perder tiempo con el spinner compuesto, de momento lo dejo en el simple
    /*public class MyAdapter extends ArrayAdapter<String>{

        public MyAdapter(Context context, int textViewResourceId,   String[] objects) {
            super(context, textViewResourceId, objects);
        }

        @Override
        public View getDropDownView(int position, View convertView,ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.xml.row, parent, false);
            TextView label=(TextView)row.findViewById(R.id.company);
            label.setText(strings[position]);

            TextView sub=(TextView)row.findViewById(R.id.sub);
            sub.setText(subs[position]);

            ImageView icon=(ImageView)row.findViewById(R.id.image);
            icon.setImageResource(arr_images[position]);

            return row;
        }
    }*/

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
