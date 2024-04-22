/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author felip
 */
public class Usuario {
    private String nombre;
    private Carro vehiculo;
    private int puntuacion;

    public Usuario(String nombre, Carro vehiculo, int puntuacion) {
        this.nombre = nombre;
        this.vehiculo = vehiculo;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Carro getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Carro vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    
}
