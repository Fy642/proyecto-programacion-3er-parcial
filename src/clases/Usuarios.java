package clases;


public class Usuarios {
    public String nombre;
    private String correo;
    private int id;

    public Usuarios(String nombre, String correo, int id) {
        this.nombre = nombre;
        this.correo = correo;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Correo: " + correo;
    }
}