package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author nanohp
 */
class EscuchadorRaton implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent me) {
        System.err.println("mouseClicked");
    }

    @Override
    public void mousePressed(MouseEvent me) {
        System.err.println("mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        System.err.println("mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        System.err.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        System.err.println("mouseExited");
    }
}
