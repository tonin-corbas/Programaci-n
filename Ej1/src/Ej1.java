public class Ej1 {

    public static void main(String[] args){
        superheroe spiderman = new superheroe();
        spiderman.nombre = "Spiderman";
        spiderman.descripcion = "Tu amigo y vecino Spiderman";
        spiderman.fuerza = 7;
        spiderman.vida = 6;
        String[] hspiderman = {"Sentido aracnido","Superfuerza"};
        spiderman.habilidades = hspiderman;

        spiderman.pintarinfo();
    }
}
