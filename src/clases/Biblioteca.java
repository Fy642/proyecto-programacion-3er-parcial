package clases;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> coleccion = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        coleccion.add(libro);
    }

    public void mostrarLibros() {
        for (Libro libro : coleccion) {
            System.out.println(libro);
        }
    }

    public Libro buscarLibro(int id) {
        for (Libro libro : coleccion) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }
    public void prestarLibro(Libro libro, int copiasPrestadas) {
        int index = coleccion.indexOf(libro);
        if (index != -1) {
            Libro libroPrestado = coleccion.get(index);
            if (libroPrestado.getCopias() >= copiasPrestadas) {
                libroPrestado.decrementarCopias(copiasPrestadas);
            } else {
                System.out.println("No hay suficientes copias disponibles.");
            }
        }
    }

    public void devolverLibro(Libro libro) {
        int index = coleccion.indexOf(libro);
        if (index != -1) {
            Libro libroDevuelto = coleccion.get(index);
            libroDevuelto.incrementarCopias(1);
        }
    }
}
