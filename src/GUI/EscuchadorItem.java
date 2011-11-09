package GUI;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author nanohp
 */
class EscuchadorItem implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent ie) {
        System.err.println("itemStateChanged");
    }
}
