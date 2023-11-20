public class superheroe {
    public String nombre;
    public String descripcion;
    public String[] habilidades;
    public String rareza; //comun, epico, legendario
    public String tipo;
    public int fuerza; //De 0 a 10
    public int vida; //De 0 a 10

    /* COnstructor con parámetros base */
    public superheroe(String nombre, int fuerza, int vida){
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.vida = vida;
        this.rareza = "comun";
    }

    /* Constructor vacio */
    public superheroe(){
        this.rareza = "comun";
    }

    //Metodos de la classe superheroe:

    /**
     * Pinta el nombre del Superheroe y sus estadisticas
     */
    public void pintarInfo(){
        System.out.println(nombre + " - " + descripcion);
        System.out.println("Fuerza: " + fuerza);
        System.out.println("Vida: " + vida);

    }
}
