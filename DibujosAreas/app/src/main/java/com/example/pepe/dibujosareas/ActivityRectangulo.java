package com.example.pepe.dibujosareas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class ActivityRectangulo extends Activity
{
    Float l1,l2;
    InternalView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_rectangulo);
        Bundle miBundle = getIntent().getExtras();
        l1 = miBundle.getFloat("Lado1");
        l2 = miBundle.getFloat("Lado2");

        setContentView(new InternalView(this));

        Toast.makeText(getApplicationContext(), "Has pasado el lado1 valor: " + l1+"\nHas pasado el lado2 valor: "+l2, Toast.LENGTH_SHORT).show();
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
            float left,right,top,bottom;
            left = (getWidth()/2) - (l1/2);
            top = (getHeight()/2) - (l2/2);
            right = (getWidth()/2 + (l1/2));
            bottom = (getHeight()/2 + (l2/2));
            canvas.drawRect(left,top,right,bottom,drawPaint);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_rectangulo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
