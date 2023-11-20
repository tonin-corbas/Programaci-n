import java.util.Scanner;

public class coleccion {
    public superheroe[] superheroes;
    public String propietario;
    public String fecha;

    /* Constructor vacio */
    public coleccion(){
    }

    //Metodos de nuestra coleccion:

    /**
     * Pinta la info de todos los heroes.
     */
    public void pintarInfoColeccion(){
        int i = 0;
        while(i < superheroes.length){
            superheroes[i].pintarInfo();
            i++;
        }
    }

    /**
     * Pinta la info de todos los heroes con mas
     * fuerza que el valor de @fuerza.
     * @param fuerza
     */
    public void pintarInfColeccion(int fuerza){
        int i = 0;
        while(i < superheroes.length){
            if(superheroes[i].fuerza > fuerza){
                superheroes[i].pintarInfo();
            }

            i++;
        }
    }
}
