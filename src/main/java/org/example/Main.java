package org.example;

import ui.Calculadora;

/**
 * Clase principal que inicia la aplicación de la calculadora.
 */
public class Main {
    /**
     * Método principal que crea una instancia de la clase 'Calculadora'
     * y muestra la ventana de la calculadora.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        Calculadora ventana = new Calculadora();
        ventana.render();
    }
}