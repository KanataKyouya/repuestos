public class Repuestos {

    private String Marca;
    private String Referencia;
    private int Cantidad;
    private Double Precio;

    public Repuestos() {

    }

    public Repuestos(String marca, String referencia, int cantidad, Double precio) {

        Marca = marca;
        Referencia = referencia;
        Cantidad = cantidad;
        Precio = precio;

    }

    public String getMarca() {
        
        return Marca;
        
    }

    public void setMarca(String marca) {
        
        Marca = marca;
        
    }

    public String getReferencia() {
        
        return Referencia;
        
    }

    public void setReferencia(String referencia) {
        
        Referencia = referencia;
        
    }

    public int getCantidad() {
        
        return Cantidad;
        
    }

    public void setCantidad(int cantidad) {
        
        Cantidad = cantidad;
        
    }

    public Double getPrecio() {
        
        return Precio;
        
    }

    public void setPrecio(Double precio) {
        
        Precio = precio;
        
    }

}