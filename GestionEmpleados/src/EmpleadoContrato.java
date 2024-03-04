public class EmpleadoContrato extends Persona implements Empleado {
    private double salarioMensual;
    private int duracionContrato;

    public EmpleadoContrato(String nombre, String documentoIdentidad, double salarioMensual, int duracionContrato) {
        super(nombre, documentoIdentidad);
        this.salarioMensual = salarioMensual;
        this.duracionContrato = duracionContrato;
    }

    @Override
    public double calcularSalario() {
        return salarioMensual * Math.min(duracionContrato, 12);
    }

    @Override
    public String mostrarInformacion() {
        return "Empleado por contrato: " + getNombre() + ", Salario mensual: " + salarioMensual + ", Duración del contrato: " + duracionContrato + " meses";
    }

    @Override
    public double calcularPrecioPorHora() {
        return (salarioMensual * 12) / (52 * 40); // Suponiendo una semana laboral de 40 horas
    }
}
