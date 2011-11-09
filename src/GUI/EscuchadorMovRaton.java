package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author nanohp
 */
class EscuchadorMovRaton implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent me) {
        System.err.println("mouseDragged" + me.getLocationOnScreen());
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        System.err.println("mouseMoved");
    }
}
