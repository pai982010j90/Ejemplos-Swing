package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nanohp
 */
class EscuchadorAcciones implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.err.println("Boton pulsado:" + ae.getSource());
        System.err.println("getActionCommand():" + ae.getActionCommand());
        System.err.println("Boton pulsado:" + ae.getWhen());

        if (ae.getActionCommand().equals("Salir")) {
            System.exit(1);
        }
        
/*  Lo siguiente no es posible pues el objeto f2 (un JFrame) es un miembro de la clase GUI y desde aqui no es accesible
         * Se ha solucionado con una clase inner
         * 
        if (ae.getActionCommand().equals("CREAR_VENTANA")) {
            JFrame f2 = ((GUI)ae.getSource()).getF2();
            f2.setVisible(true);
        }
 */
    }
}
