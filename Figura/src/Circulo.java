public class Circulo extends Figura {
    private Integer radio;

    public Circulo(Integer radio){
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        double Area = Math.PI * Math.pow(2, radio);
        System.out.println("El área del círculo es: " + Area);
        return Area;
    }

    @Override
    public double calcularPerimetro(){
        double perimetro = (2 * Math.PI) * radio;
        System.out.println("El perímetro del círculo es: " + perimetro);
        return perimetro;
    }
}


