package semana9;

import java.io.Serializable;
import java.util.Objects;

public class Libro implements Serializable {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String isbn;

    public Libro(String titulo, String autor, int anioPublicacion, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.isbn = isbn;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return String.format("| %-20s | %-20s | %-4d | %-13s |", titulo, autor, anioPublicacion, isbn);
    }

    public static String cabeceraTabla() {
        return String.format("| %-20s | %-20s | %-4s | %-13s |", "Título", "Autor", "Año", "ISBN");
    }
}
