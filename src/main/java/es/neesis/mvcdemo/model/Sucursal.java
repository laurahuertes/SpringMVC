package es.neesis.mvcdemo.model;

public class Sucursal {
    private int id;
    private String nombre;
    private String director;
    private String direccion;

    public Sucursal(int id, String nombre, String director, String direccion)
    {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.direccion = direccion;
    }

    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getDirector(){
        return this.director;
    }

    public String getDireccion(){
        return this.direccion;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
}