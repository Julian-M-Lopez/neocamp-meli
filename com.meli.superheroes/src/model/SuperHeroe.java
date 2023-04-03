package model;

public class SuperHeroe {
    // Atributos
    private String nombre;
    private String descripcion = "";
    private boolean capa = false;

    //Metodo contructor

    public SuperHeroe(String nombre) {

        this.nombre = nombre;
    }

    //Metodos personalizados

    @Override
    public String toString() {

        return "(Nombre): " + nombre + ", Descripcion: " + descripcion + ", Capa: " + capa;
    }


    //Metodos getter y setters
    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;
    }

    public boolean getCapa() {

        return capa;
    }

    public void setCapa(Boolean capa) {

        this.capa = capa;
    }


}

