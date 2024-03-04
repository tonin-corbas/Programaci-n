public class Mago extends Personaje {

    private int energia;

    public Mago(String nombre, int vida, int fuerza, int energia) {
        super(nombre, vida, fuerza);
        this.energia = energia;
    }

    public int getEnergia() {
        return energia;
    }

    @Override
    void atacar(Personaje objetivo) {
        if (energia > 4) {
            objetivo.recibirAtaque(getFuerza() * 2);
            energia -= 4;
        } else {
            System.out.println("No hay suficiente energía para atacar.");
        }
    }

    @Override
    void recibirAtaque(int cantidad) {
        setVida(getVida() - cantidad);
    }
}
