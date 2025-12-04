/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caso2;

import javax.swing.JOptionPane;

/**
 *
 * @author BrayanMolina
 */
public class Caso2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    static Asiento[][] avion = new Asiento[5][4];

    static void main(String[] args) {
        cargarAvion();
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU\n"
                    + "1. Ver Mapa\n"
                    + "2. Reservar Asiento\n"
                    + "3. Reservar con Descuento\n"
                    + "4. Consultar Pasajero\n"
                    + "5. Ver Resumen\n"
                    + "6. Salir"
            ));

            switch (opcion) {
                case 1:
                    verMapa();
                    break;
                case 2:
                    reservar(false);
                    break;
                case 3:
                    reservar(true);
                    break;
                case 4:
                    consultar();
                    break;
                case 5:
                    resumen();
                    break;
            }

        } while (opcion != 6);
    }

    static void cargarAvion() {
        for (int i = 0; i < 5; i++) {
            char letra = 'A';

            for (int j = 0; j < 4; j++) {

                String clase;
                double precio;

                if (i == 0) {
                    clase = "Primera";
                    precio = 500;
                } else if (i == 1) {
                    clase = "Ejecutiva";
                    precio = 300;
                } else {
                    clase = "Economica";
                    precio = 100;
                }

                String codigo = (i + 1) + "" + letra;
                avion[i][j] = new Asiento(codigo, clase, precio);
                letra++;
            }
        }
    }

    static void reservar(boolean descuento) {

        int fila = Integer.parseInt(JOptionPane.showInputDialog("Fila (1-5):")) - 1;
        char letra = JOptionPane.showInputDialog("Letra (A-D):").toUpperCase().charAt(0);
        int col = letra - 'A';

        Asiento a = avion[fila][col];

        if (a.getEstado().equals("Libre")) {

            String nombre = JOptionPane.showInputDialog("Nombre:");
            String pasaporte = JOptionPane.showInputDialog("Pasaporte:");
            String nacionalidad = JOptionPane.showInputDialog("Nacionalidad:");

            double precioFinal = a.getPrecio();

            if (descuento) {
                if (a.getClase().equals("Economica")) {
                    precioFinal *= 0.90;
                }
                if (a.getClase().equals("Ejecutiva")) {
                    precioFinal *= 0.85;
                }
                if (a.getClase().equals("Primera")) {
                    precioFinal *= 0.82;
                }
            }

            Pasajero p = new Pasajero(nombre, pasaporte, nacionalidad);
            a.setPasajero(p);
            a.setPrecio(precioFinal);
            a.setEstado("Ocupado");

            JOptionPane.showMessageDialog(null,
                    "Reserva exitosa\nAsiento: " + a.getCodigo()
                    + "\nPrecio final: $" + precioFinal
            );

        } else {
            JOptionPane.showMessageDialog(null, "Asiento NO disponible");
        }
    }

    static void resumen() {
        double total = 0;
        int ocupados = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (avion[i][j].getEstado().equals("Ocupado")) {
                    total += avion[i][j].getPrecio();
                    ocupados++;
                }
            }
        }

        int totalAsientos = 20;
        int libres = totalAsientos - ocupados;
        double porcentaje = (ocupados * 100.0) / totalAsientos;

        JOptionPane.showMessageDialog(null,
                "RESUMEN DEL VUELO\n"
                + "Total Recaudado: $" + total
                + "\nAsientos Libres: " + libres
                + "\nOcupacion: " + porcentaje + "%"
        );

    }

}
