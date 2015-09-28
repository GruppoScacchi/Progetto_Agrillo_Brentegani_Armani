
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Grafica {

    private final JPanel grafica = new JPanel(new BorderLayout(3, 3));
    private JButton[][] quadratiScacchiera = new JButton[8][8];
    private JPanel scacchiera_grafica;
    private static final String lettere = " ABCDEFGH ";
    
    private Scacchiera scacchiera;
    private Pedina pedina;
    private ArrayList<Pedina> PezziNeri;
    private ArrayList<Pedina> PezziBianchi;

    private boolean b = false;
    private boolean turno = true;
 

    int coordinataX;
    int coordinataY;
    int newX;
    int newY;
    
    public Grafica() {
        scacchiera = new Scacchiera();

        scacchiera_grafica = new JPanel(new GridLayout(0, 10));
        grafica.add(scacchiera_grafica);
        grafica.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        grafica.add(tools, BorderLayout.PAGE_START);
        

       Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("Resources/White.png").getImage(), new Point(0, 0), "bianco");
    	scacchiera_grafica.setCursor(cursor);
        stampaScacchiera();
    }

    public void stampaScacchiera() {
    Insets bordoNullo = new Insets(0, 0, 0, 0);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                final Bottone bottone = new Bottone(i, j);
                bottone.setMargin(bordoNullo);
                ImageIcon icona = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                bottone.setIcon(icona);
                if ((j + i) % 2 == 0) {
                    bottone.setBackground(Color.white);
                } else {
                    bottone.setBackground(Color.black);
                }
                bottone.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!b) {
                            pedina = null;
                            coordinataX = bottone.getbX();
                            coordinataY = bottone.getbY();
                            if (turno) {
                                System.out.println("BIANCHI");
                                for (Pedina pedinaBianca : scacchiera.PezziBianchi) {
                                    if (pedinaBianca.getX() == coordinataX && pedinaBianca.getY() == coordinataY) {
                                        pedina = pedinaBianca;
                                        break;
                                    }
                                }
                            }
                            else {
                                System.out.println("NERI");
                                for (Pedina pedinaNera : scacchiera.PezziNeri) {
                                    if (pedinaNera.getX() == coordinataX && pedinaNera.getY() == coordinataY) {
                                        pedina = pedinaNera;
                                        break;
                                    }
                                }                            
                            }
                            
                            if (pedina != null) {
                                b = !b;
                                System.out.println("Ho preso il pezzo in " + coordinataX + " " + coordinataY + "\n");
                            } else { System.out.println("Nessuna pedina"); }
                        } else {
                            newX = bottone.getbX();
                            newY = bottone.getbY();
                            if ((turno && pedina.getColore() == Colore.Bianco) || (!turno && pedina.getColore() == Colore.Nero)) { //true = bianco
                                System.out.println("Secondo click " + newX + " " + newY);
                                if (scacchiera.CheckPedina(pedina, newX, newY)) {
                                    int oldX = pedina.getX();
                                    int oldY = pedina.getY();
                                    scacchiera.setPosition(pedina, newX, newY);
                                    pedina.setCoordinate(newX, newY);
                                    scacchiera.setVoid(oldX, oldY);
                                    
                                    Pedina cancellata = scacchiera.Elimina(pedina, newX, newY);
                                    System.out.println("Nuova posizione della pedina selezionata: " + pedina.getX() + " " + pedina.getY());
                                    if (!(turno ? scacchiera.ScaccoSubito(scacchiera.PezziBianchi.get(0)) 
                                            : scacchiera.ScaccoSubito(scacchiera.PezziNeri.get(0)))) {
                                        if ((turno ? scacchiera.ScaccoFatto(pedina, scacchiera.PezziNeri.get(0)) 
                                                : scacchiera.ScaccoFatto(pedina, scacchiera.PezziBianchi.get(0)))) {                                       
                                        		JOptionPane.showMessageDialog(null, "SCACCO");
                                        }
                                        turno = !turno;
                                        if ((turno  ? scacchiera.ScaccoMatto(pedina, scacchiera.PezziBianchi.get(0)) 
                                              : scacchiera.ScaccoMatto(pedina, scacchiera.PezziNeri.get(0)))) {
                                        			posizionaPedina(pedina, oldX, oldY);
                                        			JOptionPane.showMessageDialog(null, "SCACCO MATTO");
                                        			for (int i = 0; i < 8; i++) {
	                                        			for (int j = 0; j < 8; j++) {
	                                        				quadratiScacchiera[i][j].setEnabled(false);
	                                        			}
                                        			}
                                        			String scelta = JOptionPane.showInputDialog(null, "Iniziare una partita? (y/n)");
                                                    switch (scelta) {
                                                        case "y": {
                                                        	Main.main(null);
                                                       		break;
                                                        }
                                                        case "n": {
                                                            System.exit(0);
                                                        }
                                                    }
                                        }
                                    } else {
                                        pedina.setCoordinate(oldX, oldY);
                                        scacchiera.setPosition(pedina, oldX, oldY);
                                        scacchiera.setVoid(newX, newY);
                                        scacchiera.setPosition(cancellata, newX, newY);
                                        if (cancellata != null) 
                                            scacchiera.Aggiungi(cancellata);
                                    }
                                    posizionaPedina(pedina, oldX, oldY);
                                } else System.out.println("POSIZIONAMENTO ERRATO");

                            }
                            scacchiera.cambio = true;
                            b = !b;
                            if	(turno) {
                            	Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("Resources/White.png").getImage(), new Point(0, 0), "bianco");
                            	scacchiera_grafica.setCursor(cursor);
                            } else {
                            	Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("Resources/Black.png").getImage(), new Point(0, 0), "nero");
                            	scacchiera_grafica.setCursor(cursor);
                            }
                        }
                    }
                });
                quadratiScacchiera[j][i] = bottone;
            }
        }

        for (int i = 0; i < 10; i++) {
            scacchiera_grafica.add(new JLabel(lettere.substring(i, i + 1), SwingConstants.CENTER));
        }

        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                switch (j) {
                    case 0:
                        scacchiera_grafica.add(new JLabel("" + (i),
                                SwingConstants.CENTER));
                        break;
                    case 9:
                        scacchiera_grafica.add(new JLabel("" + (i),
                                SwingConstants.CENTER));
                        break;
                    default:
                        scacchiera_grafica.add(quadratiScacchiera[j - 1][i - 1]);
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            scacchiera_grafica.add(
                    new JLabel(lettere.substring(i, i + 1),
                            SwingConstants.CENTER));
        }
        quadratiScacchiera[0][0].setIcon(new ImageIcon("Resources/torreNera.png"));
        quadratiScacchiera[1][0].setIcon(new ImageIcon("Resources/cavalloNero.png"));
        quadratiScacchiera[2][0].setIcon(new ImageIcon("Resources/alfiereNero.png"));
        quadratiScacchiera[3][0].setIcon(new ImageIcon("Resources/reginaNera.png"));
        quadratiScacchiera[4][0].setIcon(new ImageIcon("Resources/reNero.png"));
        quadratiScacchiera[5][0].setIcon(new ImageIcon("Resources/alfiereNero.png"));
        quadratiScacchiera[6][0].setIcon(new ImageIcon("Resources/cavalloNero.png"));
        quadratiScacchiera[7][0].setIcon(new ImageIcon("Resources/torreNera.png"));

        quadratiScacchiera[0][7].setIcon(new ImageIcon("Resources/torreBianca.png"));
        quadratiScacchiera[1][7].setIcon(new ImageIcon("Resources/cavalloBianco.png"));
        quadratiScacchiera[2][7].setIcon(new ImageIcon("Resources/alfiereBianco.png"));
        quadratiScacchiera[3][7].setIcon(new ImageIcon("Resources/reginaBianca.png"));
        quadratiScacchiera[4][7].setIcon(new ImageIcon("Resources/reBianco.png"));
        quadratiScacchiera[5][7].setIcon(new ImageIcon("Resources/alfiereBianco.png"));
        quadratiScacchiera[6][7].setIcon(new ImageIcon("Resources/cavalloBianco.png"));
        quadratiScacchiera[7][7].setIcon(new ImageIcon("Resources/torreBianca.png"));

        for (int i = 0; i < 8; i++) {
            quadratiScacchiera[i][1].setIcon(new ImageIcon("Resources/pedoneNero.png"));
            quadratiScacchiera[i][6].setIcon(new ImageIcon("Resources/pedoneBianco.png"));
        }

    }
    
    public void posizionaPedina(Pedina pedina, int oldX, int oldY) {

        int newX = pedina.getX(),
            newY = pedina.getY();
        switch (pedina.getType()) {

            case Pedone:
                if (pedina.getColore() == Colore.Nero) {
                    ImageIcon img = new ImageIcon("Resources/pedoneNero.png");
                    quadratiScacchiera[oldY][oldX].setIcon(null);
                    quadratiScacchiera[newY][newX].setIcon(img);
                    img.getImage().flush();

                } else {
                    ImageIcon img = new ImageIcon("Resources/pedoneBianco.png");
                    quadratiScacchiera[oldY][oldX].setIcon(null);
                    quadratiScacchiera[newY][newX].setIcon(img);
                    img.getImage().flush();
                }
                break;

            case Re:
                if (pedina.getColore() == Colore.Nero) {
                    ImageIcon img = new ImageIcon("Resources/reNero.png");
                    quadratiScacchiera[oldY][oldX].setIcon(null);
                    quadratiScacchiera[newY][newX].setIcon(img);
                    img.getImage().flush();
                } else {
                    ImageIcon img = new ImageIcon("Resources/reBianco.png");
                    quadratiScacchiera[oldY][oldX].setIcon(null);
                    quadratiScacchiera[newY][newX].setIcon(img);
                    img.getImage().flush();
                }
                break;

            case Alfiere:
                if (pedina.getColore() == Colore.Nero) {
                    ImageIcon img = new ImageIcon("Resources/alfiereNero.png");
                    quadratiScacchiera[oldY][oldX].setIcon(null);
                    quadratiScacchiera[newY][newX].setIcon(img);
                    img.getImage().flush();
                } else {
                    ImageIcon img = new ImageIcon("Resources/alfiereBianco.png");
                    quadratiScacchiera[oldY][oldX].setIcon(null);
                    quadratiScacchiera[newY][newX].setIcon(img);
                    img.getImage().flush();
                }
                break;

            case Cavallo:
                if (pedina.getColore() == Colore.Nero) {
                    ImageIcon img = new ImageIcon("Resources/cavalloNero.png");
                    quadratiScacchiera[oldY][oldX].setIcon(null);
                    quadratiScacchiera[newY][newX].setIcon(img);
                    img.getImage().flush();
                } else {
                    ImageIcon img = new ImageIcon("Resources/cavalloBianco.png");
                    quadratiScacchiera[oldY][oldX].setIcon(null);
                    quadratiScacchiera[newY][newX].setIcon(img);
                    img.getImage().flush();
                }
                break;

            case Torre:
                if (pedina.getColore() == Colore.Nero) {
                    ImageIcon img = new ImageIcon("Resources/torreNera.png");
                    quadratiScacchiera[oldY][oldX].setIcon(null);
                    quadratiScacchiera[newY][newX].setIcon(img);
                    img.getImage().flush();
                } else {
                    ImageIcon img = new ImageIcon("Resources/torreBianca.png");
                    quadratiScacchiera[oldY][oldX].setIcon(null);
                    quadratiScacchiera[newY][newX].setIcon(img);
                    img.getImage().flush();
                }
                break;

            case Regina:
                if (pedina.getColore() == Colore.Nero) {
                    ImageIcon img = new ImageIcon("Resources/reginaNera.png");
                    quadratiScacchiera[oldY][oldX].setIcon(null);
                    quadratiScacchiera[newY][newX].setIcon(img);
                    img.getImage().flush();
                } else {
                    ImageIcon img = new ImageIcon("Resources/reginaBianca.png");
                    quadratiScacchiera[oldY][oldX].setIcon(null);
                    quadratiScacchiera[newY][newX].setIcon(img);
                    img.getImage().flush();
                }
                break;
            default:
                break;
        }
    }
    
    public final JComponent getGrafica() {
        return grafica;
    }

}