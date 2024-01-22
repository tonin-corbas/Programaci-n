public class Cartas {
    private String Nombre;

    private cartaTipo Tipo;

    private int Atc;

    enum cartaTipo{
        Ataque,Curacion,Aturdir
    }

    public Cartas(String nombre, cartaTipo tipo, int atc){
        this.Nombre = nombre;
        this.Tipo = tipo;
        this.Atc = atc;
    }

    public void mostrarInfo(){
        System.out.println("| Carta: " + Nombre + "| ");
        System.out.println("   | Tipo: " + Tipo + " | ");
        System.out.println("   | Ataque: " + Atc + "   | ");
    }

    public cartaTipo getTipo(){
        return Tipo;
    }

    public int getAtc(){
        return Atc;
    }
}
