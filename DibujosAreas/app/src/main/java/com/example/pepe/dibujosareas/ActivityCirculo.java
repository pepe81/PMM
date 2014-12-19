package com.example.pepe.dibujosareas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.jar.Attributes;


public class ActivityCirculo extends Activity {

    Intent intentRecoger;
    Float radio;
    InternalView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_circulo);
        Bundle miBundle = getIntent().getExtras();
        radio = miBundle.getFloat("RADIO");
        //myView = new InternalView(this);
        setContentView(new InternalView(this));

        Toast.makeText(getApplicationContext(),"Has pasado el radio valor: "+radio,Toast.LENGTH_SHORT).show();
    }
    public class InternalView extends View
    {
        private final int paintColor = Color.BLACK;
        private Paint drawPaint;
        public InternalView(Context context)
        {
            super(context);
            setFocusable(true);
            setFocusableInTouchMode(true);
            setupPaint();
        }
        private void setupPaint()
        {
            drawPaint = new Paint();
            drawPaint.setColor(paintColor);
            drawPaint.setAntiAlias(true);
            drawPaint.setStrokeWidth(5);
            drawPaint.setStyle(Paint.Style.STROKE);
            drawPaint.setStrokeJoin(Paint.Join.ROUND);
            drawPaint.setStrokeCap(Paint.Cap.ROUND);
        }
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            drawPaint.setColor(Color.RED);
            canvas.drawCircle(getWidth()/2,getHeight()/2,radio,drawPaint);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_circulo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
