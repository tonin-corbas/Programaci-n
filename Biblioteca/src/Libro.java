public class Libro {
    private String titulo;
    private String autor;
    private int calificacion;

    public Libro(String Titulo, String Autor, int Calificacion) {
        this.titulo = Titulo;
        this.autor = Autor;
        this.calificacion = Calificacion;
    }

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

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        if (calificacion >= 0 && calificacion <= 10) {
            this.calificacion = calificacion;
        } else {
            System.out.println("La calificación tiene que ser entre 0 y 10");
        }
    }
}
