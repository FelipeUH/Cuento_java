/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Control;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author felip
 */
public class TaxCalculatorTest {
    
    public TaxCalculatorTest() {
    }

    /**
     * Test of calculateIva method, of class TaxCalculator.
     */
    @Test
    public void testCalculateIvaWithValidInput() {
        System.out.println("calculateIva");
        double subtotal = 1000000.0;
        double expResult = 190000.0;
        double result = TaxCalculator.calculateIva(subtotal);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testCalculateIvaWithInvalidInput() {
        System.out.println("calculateIva");
        double subtotal = -1000.0;
        double expResult = -1;
        double result = TaxCalculator.calculateIva(subtotal);
        assertEquals(expResult, result, 0);
    }
    
}
