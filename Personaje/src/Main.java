public class Main {
    public static void main(String[] args) {
        Guerrero guerrero = new Guerrero("Guerrero", 100, 20, 5);
        Mago mago = new Mago("Mago", 100, 15, 10);

        guerrero.atacar(mago);
        System.out.println(mago.toString());

        mago.atacar(guerrero);
        System.out.println(guerrero.toString());

        System.out.println(guerrero.estaVivo());
    }
}