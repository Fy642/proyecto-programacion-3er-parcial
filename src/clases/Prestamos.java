package clases;

import java.util.ArrayList;
import clases.Libro;
import clases.Biblioteca;
import clases.Usuarios;
import clases.RegistroUsuarios;
import clases.Prestamo;

public class Prestamos {
    private ArrayList<Prestamo> prestamos = new ArrayList<>();
    public ArrayList<Prestamo> getPrestamos() {
    return prestamos;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public Prestamo buscarPrestamo(int id) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().getId() == id) {
                return prestamo;
            }
        }
        return null;
    }
}