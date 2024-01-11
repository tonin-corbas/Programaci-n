public class Reloj {
    private int horas;
    private int minutos;
    private int segundos;

    // Constructor vacío que inicializa el reloj en 0:0:0
    public Reloj() {
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
    }

    // Constructor con parámetros para inicializar el reloj según los valores proporcionados
    public Reloj(int horas, int minutos, int segundos) {
        if (!validarHora(horas, minutos, segundos)) {
            System.out.println("La hora introducida es incorrecta. Se inicializará en 0:0:0.");
            this.horas = 0;
            this.minutos = 0;
            this.segundos = 0;
        } else {
            this.horas = horas;
            this.minutos = minutos;
            this.segundos = segundos;
        }
    }

    // Método privado para validar si una hora es correcta
    private boolean validarHora(int horas, int minutos, int segundos) {
        return (horas >= 0 && horas < 24) && (minutos >= 0 && minutos < 60) && (segundos >= 0 && segundos < 60);
    }

    // Método para imprimir la hora en formato 24h
    public void imprimirHora24() {
        System.out.printf("%02d:%02d:%02d%n", this.horas, this.minutos, this.segundos);
    }

    // Método para imprimir la hora en formato 12h con AM/PM
    public void imprimirHora12() {
        String periodo = (this.horas < 12) ? "AM" : "PM";
        int horas12 = (this.horas > 12) ? this.horas - 12 : this.horas;
        horas12 = (horas12 == 0) ? 12 : horas12;

        System.out.printf("%02d:%02d:%02d %s%n", horas12, this.minutos, this.segundos, periodo);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Reloj reloj1 = new Reloj(); // Se crea un reloj con la hora por defecto (0:0:0)
        reloj1.imprimirHora24(); // Se imprime la hora en formato 24h
        reloj1.imprimirHora12(); // Se imprime la hora en formato 12h

        // Se crea un reloj con la hora proporcionada
        Reloj reloj2 = new Reloj(14, 30, 45);
        reloj2.imprimirHora24();
        reloj2.imprimirHora12();
    }
}
