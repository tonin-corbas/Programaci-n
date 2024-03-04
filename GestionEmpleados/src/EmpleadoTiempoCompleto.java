public class EmpleadoTiempoCompleto extends Persona implements Empleado {
    private double salarioAnual;
    private String cargo;

    public EmpleadoTiempoCompleto(String nombre, String documentoIdentidad, double salarioAnual, String cargo) {
        super(nombre, documentoIdentidad);
        this.salarioAnual = salarioAnual;
        this.cargo = cargo;
    }

    @Override
    public double calcularSalario() {
        return salarioAnual;
    }

    @Override
    public String mostrarInformacion() {
        return "Empleado a tiempo completo: " + getNombre() + ", Salario anual: " + salarioAnual + ", Cargo: " + cargo;
    }

    @Override
    public double calcularPrecioPorHora() {
        return salarioAnual / (52 * 40); // Suponiendo una semana laboral de 40 horas
    }
}
