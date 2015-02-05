package com.example.pldesigns.examen2eval;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class Dibujar extends ActionBarActivity
{
    public int x=20,y=20, ancho =150, alto=150;
    Paint paint;
    Path path = new Path();
    int anchoPantalla;
    int altoPantalla;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new VistaAMedida(this));
    }

    public class VistaAMedida extends View {
        private ShapeDrawable miDrawable,miDrawable2,miDrawable3;

        //Start
        public VistaAMedida(Context contexto) {
            super(contexto);

            /*anchoPantalla = getMeasuredWidth();
            altoPantalla = getMeasuredHeight();

            miDrawable = new ShapeDrawable(new OvalShape());
            miDrawable2 = new ShapeDrawable(new RectShape());
            miDrawable.getPaint().setColor(Color.YELLOW);
            miDrawable.setBounds((anchoPantalla /2),((altoPantalla /2)-300), (((ancho /2) + 50)), (((altoPantalla /2)-300) + 50));
            miDrawable2.getPaint().setColor(Color.GREEN);
            miDrawable2.setBounds((anchoPantalla / 2 - 75), (altoPantalla / 2 + 200), (anchoPantalla / 2 + 75), (altoPantalla / 2 + 350));*/
        }

        //Update
        protected void onDraw(Canvas canvas)
        {
            anchoPantalla = getMeasuredWidth();
            altoPantalla = getMeasuredHeight();

            /*miDrawable.draw(canvas);
            miDrawable2.draw(canvas);*/

            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);

            //Dibujo cielo
            paint.setColor(Color.rgb(49,116,205));
            canvas.drawRect(0, 0, (anchoPantalla), (altoPantalla / 2 + 400),paint);

            //Dibujo sol
            paint.setColor(Color.rgb(255,255,51));
            canvas.drawCircle(anchoPantalla/2-200,altoPantalla/2-500,200,paint);

            //Dibujo nube
            paint.setColor(Color.rgb(219,219,217));
            canvas.drawCircle(anchoPantalla/2-150,altoPantalla/2-400,100,paint);
            canvas.drawCircle(anchoPantalla/2,altoPantalla/2-400,170,paint);
            canvas.drawCircle(anchoPantalla/2+100,altoPantalla/2-400,170,paint);
            canvas.drawCircle(anchoPantalla/2+250,altoPantalla/2-400,120,paint);

            //Dibujo cesped
            paint.setColor(Color.rgb(88, 220, 11));
            canvas.drawRect(0, (altoPantalla / 2 + 400), (anchoPantalla), (altoPantalla / 2 + altoPantalla / 2),paint);

            //Dibujo tejado
            Point a = new Point(((anchoPantalla /2)+200), ((altoPantalla /2)+200));
            Point b = new Point(anchoPantalla /2, altoPantalla /2);
            Point c = new Point(((anchoPantalla /2)-200), ((altoPantalla /2)+200));

            path.setFillType(Path.FillType.EVEN_ODD);
            path.moveTo(b.x,b.y);
            path.lineTo(c.x, c.y);
            path.lineTo(a.x, a.y);
            path.lineTo(b.x, b.y);

            path.close();

            paint.setColor(Color.rgb(206,72,15));
            canvas.drawPath(path, paint);

            //Dibujo fachada
            paint.setColor(Color.LTGRAY);
            canvas.drawRect((anchoPantalla / 2 - 150), (altoPantalla / 2 + 200), (anchoPantalla / 2 + 150), (altoPantalla / 2 + 500),paint);

            //Dibujo ventanas
            paint.setColor(Color.CYAN);
            canvas.drawRect((anchoPantalla / 2 - 75), (altoPantalla / 2 + 275), (anchoPantalla / 2 -25), (altoPantalla / 2 + 325),paint);
            canvas.drawRect((anchoPantalla / 2 + 25 ), (altoPantalla / 2 + 275), (anchoPantalla / 2 + 75), (altoPantalla / 2 + 325),paint);

            //Dibujo puerta
            paint.setColor(Color.rgb(73,23,2));
            canvas.drawRect((anchoPantalla / 2 - 30), (altoPantalla / 2 + 400), (anchoPantalla / 2 + 30), (altoPantalla / 2 + 500),paint);

            //Escribo mensaje
            paint.setColor(Color.BLACK);
            paint.setTextSize(150);
            canvas.drawText("Entregado!!!",anchoPantalla/2-350,altoPantalla-200,paint);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dibujar, menu);
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
            intent = new Intent(Dibujar.this,MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
