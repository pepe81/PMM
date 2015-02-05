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
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    String[] zonas = {"Zona A","Zona B","Zona C"};
    String[] continentes = {"Asia y Oceania","America y Africa","Europa"};
    String[] precios = {"30 €","20 €","10 €"};

    int arr_images[] = {R.drawable.asia_oceania, R.drawable.america_africa, R.drawable.europa};

    Spinner sp;
    Button btCalcular;
    EditText edPeso;
    CheckBox cbRegalo,cbTarjeta;
    Intent intent;
    RadioButton rbNormal,rbUrgente;
    RadioGroup rg;

    Double precio,peso,incremento;
    String decoracion,tarifa,zona;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbNormal = (RadioButton)findViewById(R.id.rbNormal);
        rbUrgente = (RadioButton)findViewById(R.id.rbUrgente);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        btCalcular = (Button)findViewById(R.id.btCalcular);
        edPeso = (EditText)findViewById(R.id.edPeso);
        cbRegalo = (CheckBox)findViewById(R.id.cbRegalo);
        cbTarjeta = (CheckBox)findViewById(R.id.cbTarjeta);

        sp = (Spinner)findViewById(R.id.spZonas);
        sp.setAdapter(new MyAdapter(this, R.layout.row, zonas));

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, final View view, final int position, long id)
            {
                if(zonas[position].equals("Zona A"))
                {
                    btCalcular.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            intent = new Intent(MainActivity.this,MainActivity2.class);

                            peso = Double.parseDouble(edPeso.getText().toString());
                            incremento = calcularIncremento(peso);

                            precio = incremento+30;

                            if (rbUrgente.isChecked())
                            {
                                precio = precio+(precio*0.30);
                                tarifa = "Urgente";
                                System.out.println("Precio urgente: "+precio);
                            }else if(rbNormal.isChecked())
                            {
                                tarifa = "Normal";
                            }
                            if(cbRegalo.isChecked())
                                decoracion = "Caja regalo.";
                            else if(cbTarjeta.isChecked())
                                decoracion = "Tarjeta dedicada.";

                            zona = "A";

                            mandarDatos(zona,precio,peso,decoracion,tarifa);
                        }
                    });
                }
                if(zonas[position].equals("Zona B"))
                {
                    btCalcular.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            intent = new Intent(MainActivity.this,MainActivity2.class);

                            peso = Double.parseDouble(edPeso.getText().toString());
                            incremento = calcularIncremento(peso);

                            precio = incremento+20;

                            if (rbUrgente.isChecked())
                            {
                                precio = precio+(precio*0.30);
                                tarifa = "Urgente";
                                System.out.println("Precio urgente: "+precio);
                            }else if(rbNormal.isChecked())
                            {
                                tarifa = "Normal";
                            }
                            if(cbRegalo.isChecked())
                                decoracion = "Caja regalo.";
                            else if(cbTarjeta.isChecked())
                                decoracion = "Tarjeta dedicada.";

                            zona = "B";

                            mandarDatos(zona, precio, peso, decoracion, tarifa);
                        }
                    });
                }
                if(zonas[position].equals("Zona C"))
                {
                    btCalcular.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            intent = new Intent(MainActivity.this,MainActivity2.class);

                            peso = Double.parseDouble(edPeso.getText().toString());
                            incremento = calcularIncremento(peso);

                            precio = incremento+10;

                            if (rbUrgente.isChecked())
                            {
                                precio = precio+(precio*0.30);
                                tarifa = "Urgente";
                                System.out.println("Precio urgente: "+precio);
                            }else if(rbNormal.isChecked())
                            {
                                tarifa = "Normal";
                            }
                            if(cbRegalo.isChecked())
                                decoracion = "Caja regalo.";
                            else if(cbTarjeta.isChecked())
                                decoracion = "Tarjeta dedicada.";

                            zona = "C";

                            mandarDatos(zona, precio, peso, decoracion, tarifa);
                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
    public Double calcularIncremento(Double peso)
    {
        if(peso<=5)
        {
            peso = (peso * 1);
        }
        else if(peso>5 && peso<=10)
        {
            peso = (peso * 1.5);
        }
        else if(peso>10)
        {
            peso = (peso * 2);
        }
        return peso;
    }
    public void mandarDatos(String zona,Double precio,Double peso,String decoracion,String tarifa)
    {
        intent.putExtra("Zona", zona);
        intent.putExtra("Precio", precio);
        intent.putExtra("Peso", peso);
        intent.putExtra("Decoracion",decoracion);
        intent.putExtra("Tarifa",tarifa);

        startActivity(intent);
    }
    public class MyAdapter extends ArrayAdapter<String>{

        public MyAdapter(Context context,int textViewResourceId,String[] objects) {
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
            View row=inflater.inflate(R.layout.row, parent, false);

            TextView zona = (TextView)row.findViewById(R.id.tvZona);
            zona.setText(zonas[position]);

            TextView continente = (TextView)row.findViewById(R.id.tvContinentes);
            continente.setText(continentes[position]);

            TextView precio = (TextView)row.findViewById(R.id.tvPrecio);
            precio.setText(precios[position]);

            ImageView icon=(ImageView)row.findViewById(R.id.image);
            icon.setImageResource(arr_images[position]);
            return row;
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
        if (id == R.id.action_settings)
        {
            Toast.makeText(getApplicationContext(),"Version 2.0", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
