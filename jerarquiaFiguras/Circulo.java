public class Circulo extends Figura
{
    protected double radio;
    
    /** Constructor por defecto: crea un c�rculo de color negro (Color.black) y radio 10.0  */
    public Circulo() {
        super(Color.black, "c�rculo");
        radio = 10.0;
    }
    public Circulo(Color color, double radio) {
        super(color, "circulo");
        this.radio = radio;
    }
    
    public double getRadio() { 
        return this.radio;
    }
    
    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public double area() {
        return Math.PI * radio * radio;
    }
        
    public String toString(){
        return "C�rculo " + color + " de radio " + radio;
    }
}
