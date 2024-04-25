/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author felip
 */
public class Car {
    private String brand;
    private String reference;
    private double price;

    public Car(String brand, String reference, double price) {
        this.brand = brand;
        this.reference = reference;
        this.price = price;
    }
    
    public Car(String[] fila) {   //VERIFICAR SI REALMENTE SE ESTA USANDO
        brand = fila[0];
        reference = fila[1];
        price = Double.parseDouble(fila[2]);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
