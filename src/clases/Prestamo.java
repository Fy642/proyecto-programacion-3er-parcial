package clases;

import java.util.Date;
import clases.Libro;
import clases.Biblioteca;
import clases.Usuarios;
import clases.RegistroUsuarios;
import clases.Prestamos;
import clases.Prestamo;

public class Prestamo {
    private Libro libro;
    private Usuarios usuarios;
    private Date fechaSalida;
    private Date fechaRegreso;
    private int copiasPrestadas;

    public Prestamo(Libro libro, Usuarios usuarios) {
        this.libro = libro;
        this.usuarios = usuarios;
        this.fechaSalida = new Date();
        this.fechaRegreso = null;
        this.copiasPrestadas = 1;
    }

    public Libro getLibro() {
        return libro;
    }

    public void Regresar() {
        fechaRegreso = new Date();
    }

    @Override
    public String toString() {
        return "Libro: " + libro.titulo + ", Usuario: " + usuarios.nombre + ", Fecha de Salida: " + fechaSalida + ", Fecha de Regreso: " + fechaRegreso + "Copias prestadas: " + copiasPrestadas;
    }   
}