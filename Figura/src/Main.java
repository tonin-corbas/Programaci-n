public class Main {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(8);
        Cuadrado cuadrado = new Cuadrado(7);
        Rectangulo rectangulo = new Rectangulo(7,9);

        circulo.calcularArea();
        circulo.calcularPerimetro();

        cuadrado.calcularArea();
        cuadrado.calcularPerimetro();

        rectangulo.calcularArea();
        rectangulo.calcularPerimetro();
    }
}