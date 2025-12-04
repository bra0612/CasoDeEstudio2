/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caso2;

/**
 *
 * @author BrayanMolina
 */
public class Pasajero {
    private String codigo;
    private String clase;
    private double precio;
    private String estado;
    private Pasajero pasajero;

    public PasajeroString codigo, String clase, double precio) {
        this.codigo = codigo;
        this.clase = clase;
        this.precio = precio;
        this.estado = "Libre";
        this.pasajero = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getClase() {
        return clase;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }
}
