package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author nanohp
 */
class EscuchadorTecla implements KeyListener {

    @Override
    public void keyTyped(KeyEvent ke) {
        System.err.println("keyTyped");
        char c = ke.getKeyChar();

        if (!(Character.isLetter(c) || Character.isDigit(c))) {
            ke.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        System.err.println("keyPressed");
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        System.err.println("keyReleased");
    }
}
