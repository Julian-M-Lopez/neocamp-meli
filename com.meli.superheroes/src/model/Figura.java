package model;



public class Figura {

    private String codigo;
    private double precio;
    private Dimension dimension;
    private SuperHeroe superHeroe;

    public Figura(String codigo, int precio, Dimension dimension, SuperHeroe superHeroe) {
        this.codigo = codigo;
        this.precio = precio;
        this.dimension = dimension;
        this.superHeroe = superHeroe;
    }
    public void subirPrecio (double valorAdicional){
         double valorSubido =getPrecio() + valorAdicional;
         setPrecio(valorSubido);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public SuperHeroe getSuperHeroes() {
        return superHeroe;
    }

    public void setSuperHeroes(SuperHeroe superHeroes) {
        this.superHeroe = superHeroes;
    }

    @Override
    public String toString() {
        return "Figura{" +
                "codigo='" + codigo + '\'' +
                ", precio=" + precio +
                ", dimension=" + dimension +
                ", superHeroes=" + superHeroe +
                '}';
    }
}
