package com.example.pldesigns.examen2eval;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class ListarBd extends ActionBarActivity
{
    private DbManager dbManager;
    private Cursor cursor;
    private ListView lista;
    SimpleCursorAdapter adapter;
    Button btListar;
    String coste, zona;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_bd);

        btListar = (Button)findViewById(R.id.btListar);
        dbManager = new DbManager(this);

        coste = getIntent().getStringExtra("Precio");
        zona = getIntent().getStringExtra("Zona");

        dbManager.insertar(zona,coste);

        lista = (ListView)findViewById(R.id.listView);

        final String[] from = new String[]{dbManager.CN_ZONA,dbManager.CN_COSTE};
        final int[] to = new int[]{android.R.id.text1,android.R.id.text2};

        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                cursor = dbManager.cargarCursorContactos();
                adapter = new SimpleCursorAdapter(getApplicationContext(),android.R.layout.two_line_list_item,cursor,from,to,0);
                lista.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listar_bd, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_principal)
        {
            intent = new Intent(ListarBd.this,MainActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
