/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author felip
 */
public class CalculadoraImpuestos {
    public static final double PORCENTAJE_IVA = 0.19;
    
    public static double calcularIva(double subtotal) {
        if (subtotal < 0) {
            return -1;
        }
        double iva = subtotal * PORCENTAJE_IVA;
        return iva;
    }
}
