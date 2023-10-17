package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa una calculadora con una interfaz gráfica en JAVA.
 */
public class Calculadora extends JFrame{

    /**
     * Atributo del panel principal que contiene los elementos gráficos.
     */
    private JPanel panelPrincipal;
    /**
     * Atributo del Border Layout que engloba al resto de elementos gráficos.
     */
    private JPanel bLayoutKeys;
    /**
     * Botón para borrar.
     */
    private JButton cButton;
    /**
     * Botón para sumar.
     */
    private JButton plusButton;
    /**
     * Botón para restar.
     */
    private JButton minusButton;
    /**
     * Botón para multiplicar.
     */
    private JButton crossButton;
    /**
     * Botón para dividir.
     */
    private JButton divButton;
    /**
     * Botón para obtener el reusltado.
     */
    private JButton equalsButton;
    /**
     * Botón para escribir '.'.
     */
    private JButton pointButton;
    /**
     * Botón para escribir '1'.
     */
    private JButton a1Button;
    /**
     * Botón para escribir '2'.
     */
    private JButton a2Button;
    /**
     * Botón para escribir '3'.
     */
    private JButton a3Button;
    /**
     * Botón para escribir '4'.
     */
    private JButton a4Button;
    /**
     * Botón para escribir '5'.
     */
    private JButton a5Button;
    /**
     * Botón para escribir '6'.
     */
    private JButton a6Button;
    /**
     * Botón para escribir '7'.
     */
    private JButton a7Button;
    /**
     * Botón para escribir '8'.
     */
    private JButton a8Button;
    /**
     * Botón para escribir '9'.
     */
    private JButton a9Button;
    /**
     * Botón para escribir '0'.
     */
    private JButton a0Button;
    /**
     * Campo de texto para escribir números, enteros y decimales.
     */
    private JTextField showTextField;
    /**
     * Campo donde se imprimen los resultados y distintos mensajes de error.
     */
    private JLabel lastResultLabel;
    /**
     * Variable 1 para operar.
     */
    private double number1 = 0;
    /**
     * Variable 2 para operar.
     */
    private double number2 = 0;
    /**
     * Resultado de la operación.
     */
    private double result;
    /**
     * Tipo de operación.
     */
    private String operation;

    /**
     * Constructor de 'Calculadora'.
     */
    public Calculadora(){
        this.setContentPane(panelPrincipal);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setTitle("Calculadora");
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        showTextField.setText("");
        lastResultLabel.setText("¡Bienvenido!");
        lastResultLabel.setForeground(Color.black);

        buttonLabelDimension();

        numberSignButtonListener();
        operationButtonListener();

    }

    /**
     * Método que establece una dimensión específica para todos
     * los botones.
     */
    private void buttonLabelDimension() {

        //Se establecen las dimensiones de cada botón.
        cButton.setPreferredSize(new Dimension(30, 30));
        plusButton.setPreferredSize(new Dimension(30, 30));
        minusButton.setPreferredSize(new Dimension(30, 30));
        crossButton.setPreferredSize(new Dimension(30, 30));
        divButton.setPreferredSize(new Dimension(30, 30));
        equalsButton.setPreferredSize(new Dimension(30, 30));
        pointButton.setPreferredSize(new Dimension(30, 30));
        a1Button.setPreferredSize(new Dimension(30, 30));
        a2Button.setPreferredSize(new Dimension(30, 30));
        a3Button.setPreferredSize(new Dimension(30, 30));
        a4Button.setPreferredSize(new Dimension(30, 30));
        a5Button.setPreferredSize(new Dimension(30, 30));
        a6Button.setPreferredSize(new Dimension(30, 30));
        a7Button.setPreferredSize(new Dimension(30, 30));
        a8Button.setPreferredSize(new Dimension(30, 30));
        a9Button.setPreferredSize(new Dimension(30, 30));
        a0Button.setPreferredSize(new Dimension(30, 30));
    }

    /**
     * Método que establece el 'ActionListener' de todos los botones.
     */
    private void numberSignButtonListener() {
        //BotónNum1
        a1Button.addActionListener(e -> showTextField.setText(showTextField.getText() + a1Button.getText()));
        //BotónNum2
        a2Button.addActionListener(e -> showTextField.setText(showTextField.getText() + a2Button.getText()));
        //BotónNum3
        a3Button.addActionListener(e -> showTextField.setText(showTextField.getText() + a3Button.getText()));
        //BotónNum4
        a4Button.addActionListener(e -> showTextField.setText(showTextField.getText() + a4Button.getText()));
        //BotónNum5
        a5Button.addActionListener(e -> showTextField.setText(showTextField.getText() + a5Button.getText()));
        //BotónNum6
        a6Button.addActionListener(e -> showTextField.setText(showTextField.getText() + a6Button.getText()));
        //BotónNum7
        a7Button.addActionListener(e -> showTextField.setText(showTextField.getText() + a7Button.getText()));
        //BotónNum8
        a8Button.addActionListener(e -> showTextField.setText(showTextField.getText() + a8Button.getText()));
        //BotónNum9
        a9Button.addActionListener(e -> showTextField.setText(showTextField.getText() + a9Button.getText()));
        //BotónNum0
        a0Button.addActionListener(e -> showTextField.setText(showTextField.getText() + a0Button.getText()));
        //BotónPunto
        pointButton.addActionListener(e -> showTextField.setText(showTextField.getText() + pointButton.getText()));
    }

    /**
     * Método que define el comportamiento de los botones de operación y resultado
     * cuando se pulsan.
     */
    private void operationButtonListener() {
        //BotónSuma
        plusButton.addActionListener(e -> {
            number1 = Double.parseDouble(showTextField.getText());
            showTextField.setText("");
            operation = "+";
                });
        //BotónResta
        minusButton.addActionListener(e -> {
            number1 = Double.parseDouble(showTextField.getText());
            showTextField.setText("");
            operation = "-";
        });
        //BotónMultiplicar
        crossButton.addActionListener(e -> {
            number1 = Double.parseDouble(showTextField.getText());
            showTextField.setText("");
            operation = "x";
        });
        //BotónDividir
        divButton.addActionListener(e -> {
            number1 = Double.parseDouble(showTextField.getText());
            showTextField.setText("");
            operation = "/";
        });
        //BotónIgual
        equalsButton.addActionListener(e -> {

            try {
                /* Verifica si 'showTextField' está vacío y si 'number1' es distinto de 0 a la hora de pulsar 'equalsButton'
                 * Si está vacío y es 0, y se ha pulsado el botón, devolverá 'Faltan operadores.' en color rojo en 'lastResultLabel'. */
                if (!showTextField.getText().equals("") && number1 != 0) {
                    /* Verifica si el contenido de 'showTextField' es un carácter válido, un número.
                    *  En este caso solo se verifica el punto porque no hay más caracteres que no sean
                    *  números en el teclado de la calculadora.
                    *
                    *  Si se introduce un carácter no permitido devolverá 'Introduce un número.' en color rojo
                    *  en 'lastResultLabel', además pondrá 'showTextField' en blanco. */
                        if (!showTextField.getText().equals(".")) {
                            number2 = Double.parseDouble(showTextField.getText());
                            //Si se divide cualquier número entre 0 se devolverá 'Indivisible entre 0 en rojo.
                            if (number2 != 0) {
                                operation();
                            }else {
                                lastResultLabel.setText("Indivisible entre 0");
                                lastResultLabel.setForeground(Color.red);
                            }
                            /* Restablece la variable operación para que al pulsar
                             * sobre el botón igual inmediatamente después de obtener el resultado
                             * este no vuelva a sumarse, restarse, multiplicarse o dividirse sobre sí
                             * mismo.*/
                            operation = null;
                        } else {
                            lastResultLabel.setText("Introduce un número.");
                            lastResultLabel.setForeground(Color.red);
                            showTextField.setText("");
                        }
                    } else {
                        lastResultLabel.setText("Faltan operadores.");
                        lastResultLabel.setForeground(Color.red);
                    }
                /* Si se pulsa 'equalsButton' justo después de obtener un resultado se lanzará una excepción que
                 *  pondrá en 'lastResultLabel', 'Faltan operadores.' en color rojo. */
            }catch (Exception exception){
                lastResultLabel.setText("Faltan operadores.");
                lastResultLabel.setForeground(Color.red);
            }
        });
        //BotónC
        //Sirve para reiniciar la calculadora.
        cButton.addActionListener(e -> {
            showTextField.setText("");
            lastResultLabel.setText("¡Bienvenido!");
            lastResultLabel.setForeground(Color.black);
            number1 = 0; // Restablece 'number1' a 0
            number2 = 0; // Restablece 'number2' a 0
            result = 0; // Restablece el 'result' a 0
            operation = null; // Restablece 'operation' a null
        });
    }

    /**
     * Método que realiza la operación especificada al pulsar su respectivo botón.
     */
    private void operation() {
        switch (operation) {
            // Suma
            case "+" ->
                result = number1 + number2;
            // Resta
            case "-" ->
                result = number1 - number2;
            // Multiplicación
            case "x" ->
                result = number1 * number2;
            // División
            case "/" ->
                result = number1 / number2;
            default ->
                result = 0;
        }

        //Muestra 'result' en 'showTextField'.
        showTextField.setText(String.valueOf(result));
        number1 = result; // Actualiza 'number1' con el resultado actual

        //Muestra 'result' en 'lastResultLabel'.
        lastResultLabel.setText("Resultado: " + result);

        //Colorea 'lastResultLabel' en verde como muestra de operación válida.
        lastResultLabel.setForeground(Color.decode("#006400"));
    }

    /**
     * Método que renderiza la calculaddora en pantalla.
     */
    public void render(){
        setVisible(true);
    }
}