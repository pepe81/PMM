package com.example.pepe.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class Calculo extends Activity
{
    Intent miIntent;
    Bundle miBundle;
    EditText edSaldo,edValor;
    ImageButton balon;
    int saldo = 0;
    int valor = 0;
    int resultado;
    TextView textView;
    InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // Crear el intersticial.
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-1592244461539892/5780194362");
        // Crear la solicitud de anuncio.
        AdRequest adRequestI = new AdRequest.Builder().build();
        // Comenzar la carga del intersticial.
        interstitial.loadAd(adRequestI);

        // Buscar AdView como recurso y cargar una solicitud.
        AdView adView = (AdView)this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        edSaldo = (EditText) findViewById(R.id.edSaldo);
        edValor = (EditText)findViewById(R.id.edValor);
        balon = (ImageButton)findViewById(R.id.ibBalon);
        //textView = (TextView)findViewById(R.id.textView);

        Toast.makeText(getApplicationContext(),"Deberas conocer el saldo de tu equipo y el valor del mismo.",Toast.LENGTH_LONG).show();

        balon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (edSaldo.getText().toString().equals("") || edValor.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Debes introducir un valor en ambos campos...", Toast.LENGTH_LONG).show();
                }
                else
                {
                    saldo = Integer.parseInt(edSaldo.getText().toString());
                    valor = Integer.parseInt(edValor.getText().toString());

                    valor = (int) (valor * (0.25));

                    resultado = (saldo + valor);

                    miIntent = new Intent(Calculo.this, Resultado.class);
                    miBundle = new Bundle();
                    miBundle.putInt("RESULTADO", resultado);
                    miIntent.putExtras(miBundle);
                    startActivity(miIntent);
                }
            }
        });
    }
    // Invoca displayInterstitial() cuando esté preparado para mostrar un intersticial.
    public void displayInterstitial()
    {
        if(interstitial.isLoaded())
        {
            interstitial.show();
        }
    }
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event)
    {
        if (keyCode == event.KEYCODE_BACK)
        {
            displayInterstitial();
        }
        return super.onKeyDown(keyCode,event);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
        if (id == R.id.action_settings)
        {
            Toast.makeText(getApplicationContext(),"PLDesigns",Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(),"Versión 1.0",Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
