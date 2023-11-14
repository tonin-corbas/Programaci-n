public class superheroe {
    public String nombre;
    public String descripcion;
    public String[] habilidades;
    public String rareza; //Comun, épico, legendario, ...
    public String tipo;
    public int fuerza; // De 0 a 10
    public int vida; // De 0 a 10

    //Metodos
    public void pintarinfo(){
        System.out.println(nombre + "-" + descripcion);
        System.out.println("Fuerza:" + fuerza);
        System.out.println("Vida:" + vida);
    }
}
