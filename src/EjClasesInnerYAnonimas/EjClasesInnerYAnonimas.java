package EjClasesInnerYAnonimas;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;



/**
 * El siguiente ejemplo muestra un pequeño caso explicativo para el uso de:
 *  - clases inner: declaración de una clases como miembro de otra clase.
 *      Así la clase tiene acceso al resto de los miembros de la clase de la que es miembro
 *  - clase anonima: instanciar una clase sin necesidad de darle nombre
 * 
 * El ejemplo tiene:
 *  - Un boton 'bPulsame' que al pulsarlo enviará un evento ActionEvent que ocasionará 
 *      la escritura de la palabra 'hola' en el campo de texto 'cTexto'
 *  - Un boton 'bSalir' que provocará la salida del programa
 * 
 * @author nanohp
 * @see Clases inner y clases anonimas
 */
public class EjClasesInnerYAnonimas {

    private JFrame f;
    private JButton bPulsame, bSalir;
    private JTextField cTexto;

    public EjClasesInnerYAnonimas() {
        f = new JFrame("Ventana");
        bPulsame = new JButton("Pulsame!");
        bSalir = new JButton("Salir");
        

        
        
        bPulsame.addActionListener(new EscuchadorInner());
        /* 
         * Como el escuchador para 'bSalir' no se va a utilizar en más sitios,
         *  - en lugar de necesitar
         *      declarar una clase para el propio escuchador para despues intanciar un objeto de la
         *      misma y pasarlo como parametro a addActionListener
         *  - se ha implementando directamente el codigo de la clase escuchadora dentro del argumento
         *      de addActionListener, sin necesidad de darle nombre a la clase (clase anonima)
         */
        bSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(1);
            }
        });
        cTexto = new JTextField("Texto");

        f.add(bPulsame, BorderLayout.SOUTH);
        f.add(bSalir, BorderLayout.CENTER);
        f.add(cTexto, BorderLayout.NORTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void mostrar() {
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EjClasesInnerYAnonimas g = new EjClasesInnerYAnonimas();
        g.mostrar();
    }

    /*Puesto que queremos que como respuesta al evento que envia el botón, el escuchador
     * escriba 'hola' en el campo de texto 'cTexto', la forma más simple de conseguirlo 
     * es declarando el escuchador como una clase inner, es decir, como un miembro
     * dentro de la clase 'EjClasesInnerYAnonimas'. De esta forma, al igual que cualquier otro
     * miembro de clase (variables, métodos, constructores) esta clase tendrá acceso
     * a cualquier otro miembre de la clase de la que es miembro, teniendo acceso 
     * de esta forma al campo de texto 'cTexto' para fijar así su texto
     * 
     */
    
    class EscuchadorInner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.err.println("Boton pulsado:" + ae.getSource());
            cTexto.setText("hola");
        }
    }
}
