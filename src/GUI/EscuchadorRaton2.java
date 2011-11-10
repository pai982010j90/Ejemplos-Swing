/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.MouseAdapter;
import org.w3c.dom.events.MouseEvent;

/**
 *
 * @author nanohp
 */
public class EscuchadorRaton2 extends MouseAdapter {

    public void mouseClicked(MouseEvent me) {
        System.err.println("mouseClicked");
    }

    public void mouseEntered(MouseEvent me) {
        System.err.println("mouseEntered");
    }
}
