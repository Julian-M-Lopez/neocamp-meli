package model;

public class Dimension {

    private int alto;
    private  int ancho;
    private int profundidad;

    public Dimension() {
        this.alto = 0;
        this.ancho = 0;
        this.profundidad = 0;
    }

    public Dimension(int alto, int ancho, int profundidad) {
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
    }

    public int calculo(int alto, int ancho, int profundidad){
        return alto*ancho*profundidad;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    @Override
    public String toString() {
        return "Dimension{" +
                "alto=" + alto +
                ", ancho=" + ancho +
                ", profundidad=" + profundidad +
                '}';
    }
}
