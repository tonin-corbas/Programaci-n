import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Estanteria {
    private List<Libro> libros;

    public Estanteria() {
        this.libros = new ArrayList<>();
    }

    public void sumarLibro(Libro libro) {
        if (libros.size() < 10 && !libros.contains(libro)) {
            libros.add(libro);
            System.out.println("----------------------------");
            System.out.println("Libro añadido exitosamente");
            System.out.println("----------------------------");
        } else {
            System.out.println("----------------------------------------------------------------");
            System.out.println(" No se puede añadir el libro. La lista está llena o ya existe.");
            System.out.println("----------------------------------------------------------------");
        }
    }

    public void eliminarLibro(String titulo, String autor) {
        libros.removeIf(libro -> libro.getTitulo().equals(titulo) || libro.getAutor().equals(autor));
        System.out.println("--------------------------------------");
        System.out.println(" Libro o libros eliminados con éxito.");
        System.out.println("--------------------------------------");
    }

    public void top10(){

        Collections.sort(libros, Comparator.comparingInt(Libro::getCalificacion).reversed());

        for (int i = 0; i < Math.min(10, libros.size()); i++) {
            Libro libro = libros.get(i);
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println((i + 1) + ". " + libro.getTitulo() + " de " + libro.getAutor() + "con una nota de " + libro.getCalificacion());
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
    }

    public void mostrarEstanteria() {
        Collections.sort(libros, Comparator.comparing(Libro::getTitulo));
        System.out.println("Que hay dentro de la biblioteca:");
        for (Libro libro : libros) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println(libro.getTitulo() + " de " + libro.getAutor() + "con una nota de " + libro.getCalificacion());
            System.out.println("------------------------------------------------------------------------------");
        }
    }
}