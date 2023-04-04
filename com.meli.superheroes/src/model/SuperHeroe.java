package model;

public class SuperHeroe {
    private String name;
    private String description;
    private boolean capa;

    public SuperHeroe(String name) {
        this.name = name;
        this.description ="";
        this.capa =false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCapa() {
        return capa;
    }

    public void setCapa(boolean capa) {
        this.capa = capa;
    }

    @Override
    public String toString() {
        return "SuperHeroes{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", capa=" + capa +
                '}';
    }
}




