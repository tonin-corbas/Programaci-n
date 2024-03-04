public abstract class Personaje {
    private String Nombre;
    private int Vida;
    private int Fuerza;

    public Personaje(String nombre, int vida, int fuerza) {
        this.Nombre = nombre;
        this.Vida = vida;
        this.Fuerza = fuerza;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getVida() {
        return Vida;
    }

    public int getFuerza() {
        return Fuerza;
    }

    public void setVida(int vida) {
        this.Vida = vida;
    }

    abstract void atacar(Personaje objetivo);
    abstract void recibirAtaque(int cantidad);

    boolean estaVivo() {
        return Vida > 0;
    }

    @Override
    public String toString() {
        return "Nombre: " + Nombre + ", Vida: " + Vida;
    }
}
