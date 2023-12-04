import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        LocalDateTime locaDate = LocalDateTime.now();
        int hours  = locaDate.getHour();
        int minutes = locaDate.getMinute();
        int seconds = locaDate.getSecond();
        String semana = String.valueOf(locaDate.getDayOfWeek());
        String dia = String.valueOf(locaDate.getDayOfMonth());
        String mes = String.valueOf(locaDate.getMonth());
        String anio = String.valueOf(locaDate.getYear());
        int nano = locaDate.getNano();

        System.out.println("Hoy es: "+ semana  + " dia "  + dia  + " de " + mes  + " de " + anio  + " y son las " + hours  + ":"+ minutes +":"+seconds +":"+nano);
    }
}