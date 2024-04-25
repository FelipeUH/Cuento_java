/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author felip
 */
public class TaxCalculator {
    public static final double IVA_PERCENTAGE = 0.19;
    
    public static double calculateIva(double subtotal) {
        if (subtotal < 0) {
            return -1;
        }
        double iva = subtotal * IVA_PERCENTAGE;
        return iva;
    }
}
