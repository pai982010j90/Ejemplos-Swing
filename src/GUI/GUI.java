/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author nanohp
 */
public class GUI {

    private JFrame f, f2;
    private JButton b1, b2;
    private JPanel panel1, panel2;
    private JTextField ct1;
    private JMenuBar barraMenu;
    private JMenu menu1, menu2;
    private JMenuItem menu11, menu12, menu21, menu22;
    private JTree arbol;
    private JTextArea area;
    private JTextArea area2;

    public GUI() {
        // Instanciacion del contenedor padre JFrame
        f = new JFrame("Titulo");
        f2 = new JFrame("Otra venta");
        f2.setSize(100, 100);
        // Fijación del Layout para el contenedor f
        f.setLayout(new BorderLayout());

        // Instanciacion del contenedor panel1
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        // Creacion de los botones y fijacion de sus escuchadores
        b1 = new JButton("Salir");
        EscuchadorAcciones EscuchadorAcciones = new EscuchadorAcciones();
        b1.addActionListener(EscuchadorAcciones);
        b2 = new JButton("Boton2");
        b2.addActionListener(EscuchadorAcciones);

        // Creacion de la barra de menu y fijacion de su escuchador
        crearBarraMenu();

        panel1.add(b1, BorderLayout.SOUTH);
        panel1.add(b2, BorderLayout.NORTH);

        ct1 = new JTextField("Texto1");
        //ct1.addMouseListener(new EscuchadorRaton());
        //ct1.addMouseMotionListener(new EscuchadorMovRaton());
        ct1.addKeyListener(new EscuchadorTecla());
        panel2.add(ct1);

        crearArbol();

        area = new JTextArea("Area");
        area2 = new JTextArea("Area");

        f.add(panel1, BorderLayout.WEST);
        f.add(panel2, BorderLayout.CENTER);
        f.add(arbol, BorderLayout.EAST);
        f.add(area, BorderLayout.SOUTH);
        f.add(area2, BorderLayout.NORTH);


        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mostrar() {
        f.pack();
        //f.setSize(400,200);
        f.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.mostrar();
    }

    private void crearBarraMenu() {
        // Intancio el menu
        menu1 = new JMenu("Menu1");
        // Intancio los menuItems
        menu11 = new JMenuItem("menu11");
        menu12 = new JMenuItem("menu12");

        JMenu menu13 = new JMenu("menu13");
        JMenuItem menu131 = new JMenuItem("llllll");
        menu131.addActionListener(new EscuchadorAccionesInner());
        menu131.setActionCommand("CREAR_VENTANA");
        menu13.add(menu131);

        menu12.setActionCommand("xxxxxxxxxx");
        menu12.addActionListener(new EscuchadorAcciones());


        // Añado los elementos del menu
        menu1.add(menu11);
        menu1.add(menu12);
        menu1.add(menu13);


        // Y ahora el menu2
        menu2 = new JMenu("Menu2");
        // Intancio los menuItems
        menu21 = new JMenuItem("menu21");
        menu21.addItemListener(new EscuchadorItem());
        menu22 = new JMenuItem("menu22");

        // Añado los elementos del menu
        menu2.add(menu21);
        menu2.add(menu22);


        menu2.addSeparator();
        JRadioButtonMenuItem rBMI = new JRadioButtonMenuItem("Un menu radio");
        menu2.add(rBMI);
        rBMI.addItemListener(new EscuchadorItem());
        rBMI.addActionListener(new EscuchadorAcciones());

        JCheckBoxMenuItem jCB = new JCheckBoxMenuItem("Un menu check");
        jCB.addItemListener(new EscuchadorItem());
        menu2.add(jCB);


        // Añado los menus a la barra de menu
        barraMenu = new JMenuBar();

        barraMenu.add(menu1);
        barraMenu.add(menu2);

        // Y ahora anclo la barra de menu al JFrame
        f.setJMenuBar(barraMenu);
    }

    private void crearArbol() {
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Raiz");
        raiz.add(new DefaultMutableTreeNode("Nodo1"));
        raiz.add(new DefaultMutableTreeNode("Nodo2"));

        DefaultMutableTreeNode nodo3 = new DefaultMutableTreeNode("Nodo3");
        nodo3.add(new DefaultMutableTreeNode("Nodo31"));

        raiz.add(nodo3);
        arbol = new JTree(raiz);
        arbol.addTreeSelectionListener(new EscuchadorArbol());

    }

    class EscuchadorAccionesInner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (ae.getActionCommand().equals("CREAR_VENTANA")) {
                f2.setVisible(true);
            }
        }
    }

    class EscuchadorArbol implements TreeSelectionListener {

        @Override
        public void valueChanged(TreeSelectionEvent tse) {
            String cadFinal = "";

            System.err.println("TreeSelectionEvent" + tse.getPath());

            // Tokenizamos la ruta sacando cada uno de los nodos que la componen
            for (Object objeto : tse.getPath().getPath()) {
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) objeto;
                //System.err.println(nodo.toString());
                cadFinal += "Nombre nodo:" + nodo.toString() + " - ";
            }

            area.setText(cadFinal);
            // Imprimo por el area dos 'solo' la etiqueta del nodo seleccionado
            DefaultMutableTreeNode nodoFinal = (DefaultMutableTreeNode) tse.getPath().getLastPathComponent();
            area2.setText("El nodo seleccionado es:" + nodoFinal.toString());

        }
    }
}
