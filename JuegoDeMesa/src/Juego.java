import java.util.ArrayList;
import java.util.List;

public class Juego {
    static String Nombre;

    private double Valoracion;

    Integer Publicacion;

    List<CategoriaTipo> categorias;

    public Juego(String nombre, double valoración, int publicación){
        this.Nombre = nombre;
        this.Valoracion = valoración;
        this.Publicacion = publicación;
        this.categorias = new ArrayList<>();
    }

    public static String getNombre() {
        return Nombre;
    }

    public double getValoracion() {
        return this.Valoracion;
    }

    public int getPublicacion() {
        return this.Publicacion;
    }

    public List<CategoriaTipo> getCategorias() {
        return this.categorias;
    }

    public void addCategoria(CategoriaTipo categoria){
        this.categorias.add(categoria);
    }

    public void setCategorias(List<CategoriaTipo> newcategoria){
        this.categorias = newcategoria;
    }

    public void pintarInfo(){
        System.out.println("| Nombre: " + Nombre + "| ");
        System.out.println("   | Valoración: " + Valoracion + " | ");
        System.out.println("   | Categoría: " + categorias + "   | ");
    }
}
