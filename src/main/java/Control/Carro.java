/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author felip
 */
public class Carro {
    private String marca;
    private String referencia;
    private double precio;

    public Carro(String marca, String referencia, double precio) {
        this.marca = marca;
        this.referencia = referencia;
        this.precio = precio;
    }
    
    public Carro(String[] fila) {
        marca = fila[0];
        referencia = fila[1];
        precio = Double.parseDouble(fila[2]);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
