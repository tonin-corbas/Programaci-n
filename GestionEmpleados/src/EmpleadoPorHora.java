public class EmpleadoPorHora extends Persona implements Empleado {
    private double tarifaPorHora;
    private int horasTrabajadas;

    public EmpleadoPorHora(String nombre, String documentoIdentidad, double tarifaPorHora, int horasTrabajadas) {
        super(nombre, documentoIdentidad);
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalario() {
        return tarifaPorHora * horasTrabajadas;
    }

    @Override
    public String mostrarInformacion() {
        return "Empleado por hora: " + getNombre() + ", Tarifa por hora: " + tarifaPorHora + ", Horas trabajadas: " + horasTrabajadas;
    }

    @Override
    public double calcularPrecioPorHora() {
        return tarifaPorHora;
    }
}
