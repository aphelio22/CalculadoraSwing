package ui;

import javax.swing.*;
import java.awt.*;
import java.text.spi.NumberFormatProvider;

/**
 * Clase que representa una calculadora con una interfaz gráfica en JAVA.
 */
public class Calculadora extends JFrame {

    /**
     * Atributo del panel principal que contiene los elementos gráficos.
     */
    private JPanel panelPrincipal;
    /**
     * Atributo del panel que contiene los botones, label y textField y que se encuentra dentro de 'panelPrincipal'.
     */
    private JPanel panelBotones;
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
     * Botón para las raíces cuadradas;
     */
    private JButton rcButton;
    /**
     * Botón para las potencias.
     */
    private JButton pButton;

    /**
     * Número 1 para operar.
     */
    private double number1 = 0;
    /**
     * Número 2 para operar.
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
    public Calculadora() {
        this.setContentPane(panelPrincipal);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(350, 400);
        this.setTitle("Calculadora");
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        showTextField.setText("");
        lastResultLabel.setText("¡Bienvenido!");
        lastResultLabel.setForeground(Color.black);
        panelBotones.setBackground(Color.decode("#D9E4E8"));

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
        cButton.setPreferredSize(new Dimension(70, 40));
        plusButton.setPreferredSize(new Dimension(70, 40));
        minusButton.setPreferredSize(new Dimension(70, 40));
        crossButton.setPreferredSize(new Dimension(70, 40));
        divButton.setPreferredSize(new Dimension(70, 40));
        equalsButton.setPreferredSize(new Dimension(70, 40));
        rcButton.setPreferredSize(new Dimension(70, 40));
        pButton.setPreferredSize(new Dimension(70, 40));
        pointButton.setPreferredSize(new Dimension(70, 40));
        a1Button.setPreferredSize(new Dimension(70, 40));
        a2Button.setPreferredSize(new Dimension(70, 40));
        a3Button.setPreferredSize(new Dimension(70, 40));
        a4Button.setPreferredSize(new Dimension(70, 40));
        a5Button.setPreferredSize(new Dimension(70, 40));
        a6Button.setPreferredSize(new Dimension(70, 40));
        a7Button.setPreferredSize(new Dimension(70, 40));
        a8Button.setPreferredSize(new Dimension(70, 40));
        a9Button.setPreferredSize(new Dimension(70, 40));
        a0Button.setPreferredSize(new Dimension(70, 40));

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
            //Trata 'NumberFormatException' si se pulsa el botón y no hay operadores.
            try {
                number1 = Double.parseDouble(showTextField.getText());
                showTextField.setText("");
                operation = "+";
            } catch (NumberFormatException n) {
                lastResultLabel.setText("Faltan operadores.");
                lastResultLabel.setForeground(Color.red);
            }
        });

        //BotónResta
        minusButton.addActionListener(e -> {
            //Trata 'NumberFormatException' si se pulsa el botón y no hay operadores.
            try {
                if (!showTextField.getText().isEmpty()) {
                    number1 = Double.parseDouble(showTextField.getText());
                    showTextField.setText("");
                    operation = "-";
                } else {
                    showTextField.setText("-");
                }

            } catch (NumberFormatException n) {
                lastResultLabel.setText("Faltan operadores.");
                lastResultLabel.setForeground(Color.red);
            }
        });

        //BotónMultiplicar
        crossButton.addActionListener(e -> {
            //Trata 'NumberFormatException' si se pulsa el botón y no hay operadores.
            try {
                number1 = Double.parseDouble(showTextField.getText());
                showTextField.setText("");
                operation = "x";
            } catch (NumberFormatException n) {
                lastResultLabel.setText("Faltan operadores.");
                lastResultLabel.setForeground(Color.red);
            }
        });

        //BotónDividir
        divButton.addActionListener(e -> {
            //Trata 'NumberFormatException' si se pulsa el botón y no hay operadores.
            try {
                number1 = Double.parseDouble(showTextField.getText());
                showTextField.setText("");
                operation = "/";
            } catch (NumberFormatException n) {
                lastResultLabel.setText("Faltan operadores.");
                lastResultLabel.setForeground(Color.red);
            }
        });

        //BotónRaízCuadrada
        //Trata 'NumberFormatException' si se pulsa el botón y no hay operadores.
        rcButton.addActionListener(e -> {
            try {
                number1 = Double.parseDouble(showTextField.getText());
                operation = "√";
            } catch (NumberFormatException n) {
                lastResultLabel.setText("Faltan operadores.");
                lastResultLabel.setForeground(Color.red);
            }
        });

        //BotónPotencia
        //Trata 'NumberFormatException' si se pulsa el botón y no hay operadores.
        pButton.addActionListener(e -> {
            try {
                number1 = Double.parseDouble(showTextField.getText());
                operation = "X^2";

            } catch (NumberFormatException n) {
                lastResultLabel.setText("Faltan operadores.");
                lastResultLabel.setForeground(Color.red);
            }
        });

        //BotónIgual
        equalsButton.addActionListener(e -> {
            /* Trata 'NumberFormatException' si se pulsa el botón y solo hay un operador pero se ha seleccionado una operación.
             *  En la calculadora de Windows, al darle a al botón '"' después de este caso, el programa interpreta que se ha querido realizar la
             *  operación sobre sí mismo. Esta excepción imita esa casuística.*/
            try {
                /* Verifica si el contenido de 'showTextField' es un carácter válido, un número.
                 *  En este caso solo se verifica el punto porque no hay más caracteres que no sean
                 *  números en el teclado de la calculadora.
                 *
                 *  Si se introduce un carácter no permitido devolverá 'Introduce un número.' en color rojo
                 *  en 'lastResultLabel', además pondrá 'showTextField' en blanco. */
                if (!showTextField.getText().equals(".")) {
                    number2 = Double.parseDouble(showTextField.getText());
                    //Si se divide cualquier número entre 0 se devolverá 'Indivisible entre 0.' en rojo.
                    if (number2 != 0) {
                        //Trata 'NullPointerException' si se introduce un número y se da al botón igual seguidamente.
                        try {
                            operation();
                        } catch (NullPointerException nullPointerException) {
                            lastResultLabel.setText("Resultado: " + Double.parseDouble(showTextField.getText()));
                            lastResultLabel.setForeground(Color.decode("#006400"));
                        }
                    } else {
                        lastResultLabel.setText("Indivisible entre 0.");
                        lastResultLabel.setForeground(Color.red);
                    }
                    /* Restablece la variable operación para que al pulsar
                     * sobre el botón igual inmediatamente después de obtener el resultado
                     * este no vuelva a sumarse, restarse, multiplicarse, etc., sobre sí
                     * mismo.*/
                    operation = null;
                } else {
                    lastResultLabel.setText("Introduce un número.");
                    lastResultLabel.setForeground(Color.red);
                    showTextField.setText("");
                }
            } catch (NumberFormatException numberFormatException) {
                number2 = number1;
                //Trata 'NullPointerException' al pulsar sobre '=' cuando no hay nada.
                try {
                    operation();
                } catch (NullPointerException nullPointerException) {
                    lastResultLabel.setText("Resultado : " + number1);
                }
                /* Restablece la variable operación para que al pulsar
                 * sobre el botón igual inmediatamente después de obtener el resultado
                 * este no vuelva a sumarse, restarse, multiplicarse, etc., sobre sí
                 * mismo.*/
                operation = null;
                lastResultLabel.setText("Resultado: " + Double.parseDouble(String.valueOf(result)));
                lastResultLabel.setForeground(Color.decode("#006400"));
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
            case "+" -> result = number1 + number2;
            // Resta
            case "-" -> result = number1 - number2;
            // Multiplicación
            case "x" -> result = number1 * number2;
            // División
            case "/" -> result = number1 / number2;
            //Raíz Cuadrada
            case "√" -> result = Math.sqrt(number1);
            //Potencia
            case "X^2" -> result = Math.pow(number1, 2);
            default -> result = 0;
        }

        if (String.valueOf(result).equals("NaN")) {
            lastResultLabel.setText("NaN");
            lastResultLabel.setForeground(Color.red);
            showTextField.setText("");
        } else {
            //Muestra 'result' en 'showTextField'.
            showTextField.setText(String.valueOf(result));
            number1 = result; // Actualiza 'number1' con el resultado actual

            //Muestra 'result' en 'lastResultLabel'.
            lastResultLabel.setText("Resultado: " + result);

            //Colorea 'lastResultLabel' en verde como muestra de operación válida.
            lastResultLabel.setForeground(Color.decode("#006400"));
        }
    }

    /**
     * Método que renderiza la calculaddora en pantalla.
     */
    public void render() {
        setVisible(true);
    }
}
