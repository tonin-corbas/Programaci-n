public class Guerrero extends Personaje {

    private int Resistencia;

    public Guerrero(String nombre, int vida, int fuerza, int resistencia) {
        super(nombre, vida, fuerza);
        this.Resistencia = resistencia;
    }

    @Override
    void atacar(Personaje objetivo) {
        objetivo.recibirAtaque(getFuerza());
    }

    @Override
    void recibirAtaque(int cantidad) {
        int danio = cantidad - Resistencia;
        if (danio > 0) {
            setVida(getVida() - danio);
        }
    }
}
