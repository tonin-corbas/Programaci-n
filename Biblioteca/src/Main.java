public class Main {
    public static void main(String[] args) {
        Estanteria estanteria = new Estanteria();

        Libro L1 = new Libro("Cancion de hielo y fuego", "George R.R. Martin", 8);
        Libro L2 = new Libro("El ultimo deseo", "Andrzej Sapkowski", 9);

        estanteria.sumarLibro(L1);
        estanteria.sumarLibro(L2);

        Libro L3 = new Libro("Psicología oscura", "Steven Turner", 7);
        Libro L4 = new Libro("La leyenda de Sleepy Hollow", "Washington Irving", 9);
        Libro L5 = new Libro("1984", "George Orwell", 6);

        estanteria.sumarLibro(L3);
        estanteria.sumarLibro(L4);
        estanteria.sumarLibro(L5);

        Libro L6 = new Libro("Planeta wigeta", "Vegetta777 y Willyrex", 10);

        estanteria.sumarLibro(L6);

        estanteria.top10();

        estanteria.eliminarLibro(null, "Autor3");

        estanteria.mostrarEstanteria();
    }
}