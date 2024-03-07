public class Producto {
    private Integer Codigo;
    private String Nombre;
    private Double Precio;

    public Producto(int codigo, String nombre, double precio){
        this.Codigo = codigo;
        this.Nombre = nombre;
        this.Precio = precio;
    }

    public Integer getCodigo() {
        return this.Codigo;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public double getPrecio() {
        return this.Precio;
    }

    public void setCodigo(int codigo) {
        this.Codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.Precio = precio;
    }
}
