public class GestionEmpleados {
    public static void main(String[] args) {
        EmpleadoTiempoCompleto empleado1 = new EmpleadoTiempoCompleto("Juan", "12345678A", 30000, "Gerente");
        EmpleadoContrato empleado2 = new EmpleadoContrato("Ana", "87654321B", 2000, 15);
        EmpleadoPorHora empleado3 = new EmpleadoPorHora("Pedro", "11223344C", 15, 160);

        System.out.println(empleado1.mostrarInformacion());
        System.out.println("Salario: " + empleado1.calcularSalario());
        System.out.println("Precio por hora: " + empleado1.calcularPrecioPorHora());

        System.out.println(empleado2.mostrarInformacion());
        System.out.println("Salario: " + empleado2.calcularSalario());
        System.out.println("Precio por hora: " + empleado2.calcularPrecioPorHora());

        System.out.println(empleado3.mostrarInformacion());
        System.out.println("Salario: " + empleado3.calcularSalario());
        System.out.println("Precio por hora: " + empleado3.calcularPrecioPorHora());
    }
}