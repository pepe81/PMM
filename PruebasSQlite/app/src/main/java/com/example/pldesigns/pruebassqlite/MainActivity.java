package com.example.pldesigns.pruebassqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MainActivity extends ActionBarActivity
{
    private DbManager dbManager;
    private Cursor cursor;
    private ListView lista;
    SimpleCursorAdapter adapter;
    EditText edNombre,edTelf;
    Button btGuardar,btBuscar,btListar,btBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager = new DbManager(this);

        lista = (ListView)findViewById(R.id.listView);

        edNombre = (EditText)findViewById(R.id.edNombre);
        edTelf = (EditText)findViewById(R.id.edTelf);

        btGuardar = (Button)findViewById(R.id.btGuardar);
        btBuscar = (Button)findViewById(R.id.btBuscar);
        btBorrar = (Button)findViewById(R.id.btBorrar);
        btListar = (Button)findViewById(R.id.btListar);


        btBuscar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Cursor buscar = dbManager.buscarContacto(edNombre.getText().toString());
                adapter.changeCursor(buscar);
            }
        });
        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dbManager.insertar(edNombre.getText().toString(),edTelf.getText().toString());
            }
        });

        btBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dbManager.eliminar(edNombre.getText().toString());
            }
        });

        final String[] from = new String[]{dbManager.CN_NAME,dbManager.CN_PHONE};
        final int[] to = new int[]{android.R.id.text1,android.R.id.text2};

        cursor = dbManager.cargarCursorContactos();
        adapter = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,cursor,from,to,0);

        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                lista.setAdapter(adapter);
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
