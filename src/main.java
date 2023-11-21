import java.util.ArrayList;
import java.util.Scanner;
import clases.Libro;
import clases.Biblioteca;
import clases.Usuarios;
import clases.RegistroUsuarios;
import clases.Prestamos;
import clases.Prestamo;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        RegistroUsuarios registroUsuarios = new RegistroUsuarios();
        Prestamos prestamos = new Prestamos();
        ArrayList<Prestamo> loanRecords = new ArrayList<>();

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Agregar usuario");
            System.out.println("3. Mostrar libros");
            System.out.println("4. Mostrar usuarios");
            System.out.println("5. Solicitar prestamo");
            System.out.println("6. Regresar Libro");
            System.out.println("7. Ver registro de prestamos");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el ID del libro: ");
                    int id = scanner.nextInt();
                    System.out.print("Ingrese la cantidad de copias del libro: ");
                    int copias = scanner.nextInt();
                    Libro nuevoLibro = new Libro(titulo, autor, id, copias);
                    biblioteca.agregarLibro(nuevoLibro);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el correo del usuario: ");
                    String correo = scanner.nextLine();
                    System.out.print("Ingrese el ID del usuario: ");
                    int idUsuario = scanner.nextInt();
                    Usuarios nuevoUsuario = new Usuarios(nombre, correo, idUsuario);
                    registroUsuarios.agregarUsuarios(nuevoUsuario);
                    break;
                case 3:
                    System.out.println("\nLista de Libros:");
                    biblioteca.mostrarLibros();
                    break;
                case 4:
                    System.out.println("\nLista de usuarios");
                    registroUsuarios.mostrarUsuarios();
                    break;
                case 5:
                    System.out.print("Ingrese el ID del libro que deseas llevar: ");
                    int idBusqueda = scanner.nextInt();
                    Libro libroEncontrado = biblioteca.buscarLibro(idBusqueda);
                    if (libroEncontrado != null) {
                        System.out.print("Ingrese el ID del usuario que solicita el préstamo: ");
                        idUsuario = scanner.nextInt();
                        Usuarios usuarioSolicitante = registroUsuarios.buscarUsuarios(idUsuario);
                        if (usuarioSolicitante != null) {
                            Prestamo prestamo = new Prestamo(libroEncontrado, usuarioSolicitante);
                            prestamos.agregarPrestamo(prestamo); 
                            System.out.println("Préstamo registrado exitosamente.");
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    
                    break;
                case 6:
                    System.out.print("Ingrese el ID del libro que se va a devolver: ");
                    int idDevolucion = scanner.nextInt();
                    Prestamo prestamoEncontrado = prestamos.buscarPrestamo(idDevolucion);

                    if (prestamoEncontrado != null) {
                        System.out.print("Ingrese el ID del usuario que está devolviendo el libro: ");
                        idUsuario = scanner.nextInt();
                        Usuarios usuarioSolicitante = registroUsuarios.buscarUsuarios(idUsuario);

                        if (usuarioSolicitante != null) {
                            biblioteca.devolverLibro(prestamoEncontrado.getLibro());
                            prestamoEncontrado.Regresar();
                            System.out.println("Devolución registrada exitosamente.");
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                    } else {
                        System.out.println("Préstamo no encontrado.");
                    }
                    break;

                case 7:
                    System.out.println("\nRegistro de Prestamos:");
                    for (Prestamo prestamo : prestamos.getPrestamos()) {
                        System.out.println(prestamo);
                    }
                    break;
                case 8:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
