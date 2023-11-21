package clases;


public class Libro {
    public String titulo;
    private String autor;
    private int id;
    private int copias;

    public Libro(String titulo, String autor, int id, int copias) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
        this.copias = copias;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getId() {
        return id;
    }

    public int getCopias(){
        return copias;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + titulo + ", Autor: " + autor + "Copias: " + copias;
    }
    public void decrementarCopias(int cantidad) {
        copias -= cantidad;
    }

    public void incrementarCopias(int cantidad) {
        copias += cantidad;
    }
}