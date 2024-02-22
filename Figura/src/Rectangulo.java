public class Rectangulo extends Figura {
    private Integer base;
    private Integer altura;

    public Rectangulo(Integer base, Integer altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        double Area = base * altura;
        System.out.println("El área del rectángulo es: " + Area);
        return Area;
    }

    @Override
    public double calcularPerimetro(){
        double perimetro = 2 * base + 2 * altura;
        System.out.println("El perímetro del cuadrado es: " + perimetro);
        return perimetro;
    }
}
