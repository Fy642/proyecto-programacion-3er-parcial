package clases;


import java.util.ArrayList;

public class RegistroUsuarios {
    private ArrayList<Usuarios> coleccionUsuarios = new ArrayList<>();

    public void agregarUsuarios(Usuarios usuarios) {
        coleccionUsuarios.add(usuarios);
    }

    public void mostrarUsuarios() {
        for (Usuarios usuarios : coleccionUsuarios) {
            System.out.println(usuarios);
        }
    }

    public Usuarios buscarUsuarios(int id) {
        for (Usuarios usuarios : coleccionUsuarios) {
            if (usuarios.getId() == id) {
                return usuarios;
            }
        }
        return null;
    }
}
