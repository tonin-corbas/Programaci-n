public class Cuadrado extends Figura {
    private Integer lado;

    public Cuadrado(Integer lado){
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        double Area = Math.pow(2, lado);
        System.out.println("El área del cuadrado es: " + Area);
        return Area;
    }

    @Override
    public double calcularPerimetro(){
        double perimetro = 4 * lado;
        System.out.println("El perímetro del cuadrado es: " + perimetro);
        return perimetro;
    }
}
