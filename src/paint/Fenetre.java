package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Fenetre extends JFrame {
	private Panneau container = new Panneau();
	
	// MENU
	private JMenuBar menubar = new JMenuBar();
	JMenu fichier = new JMenu("Fichier");
	JMenu edition = new JMenu("Edition");
	JMenu forme = new JMenu("Forme du pointeur");
	JMenu couleur = new JMenu("Couleur du pointeur");
	
	JMenuItem effacer = new JMenuItem("Effacer");
	JMenuItem quitter = new JMenuItem("Quitter");
	
	JMenuItem rouge = new JMenuItem("Rouge");
	JMenuItem vert = new JMenuItem("Vert");
	JMenuItem bleu = new JMenuItem("Bleu");
	
	
	JMenuItem carre = new JMenuItem("Carré");
	JMenuItem rond = new JMenuItem("Rond");
	
	//LISTENER
	private CouleurListener cListener = new CouleurListener();
	private FormeListener fListener = new FormeListener();
	
	//Barre d'outil
	JToolBar toolBar = new JToolBar();
	
	JButton square = new JButton(new ImageIcon("Images/carre.png"));
	JButton circle = new JButton(new ImageIcon("Images/rond.png"));
	
	JButton red = new JButton(new ImageIcon("Images/rouge.png"));
	JButton green = new JButton(new ImageIcon("Images/vert.png"));
	JButton blue = new JButton(new ImageIcon("Images/bleu.png"));
	

	
	
	

	public Fenetre(){
		this.setTitle("Paint");
		this.setSize(500, 500);
		this.setAlwaysOnTop(false);
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.initmenu();
		this.initToolMenu();
		
		this.getContentPane().add(container, BorderLayout.CENTER);
		//this.setContentPane(container);
				
		this.setVisible(true);
		
	}
	
	private void initToolMenu() {
		
		toolBar.add(square);
		square.addActionListener(fListener);
		toolBar.add(circle);
		circle.addActionListener(fListener);
		
		toolBar.addSeparator();
		
		toolBar.add(blue);
		blue.addActionListener(cListener);
		
		toolBar.add(green);
		green.addActionListener(cListener);
		
		toolBar.add(red);
		red.addActionListener(cListener);
		
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		
	}

	private void initmenu(){
		
		//Fichier
		menubar.add(fichier);
		fichier.setMnemonic('F');
		menubar.add(edition);
		edition.setMnemonic('E');
		fichier.add(effacer);
		effacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		effacer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				container.efface();
				
			}
			
		});
		fichier.addSeparator();
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
		quitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
			
		});
		fichier.add(quitter);
		
		//Edition
		edition.add(forme);
		forme.add(carre);
		forme.add(rond);
		carre.addActionListener(fListener);
		rond.addActionListener(fListener);		
		edition.addSeparator();
				
		edition.add(couleur);
		couleur.add(bleu);
		couleur.add(rouge);
		couleur.add(vert);
		bleu.addActionListener(cListener);
		rouge.addActionListener(cListener);
		vert.addActionListener(cListener);
		
		this.setJMenuBar(menubar);
		
	}//fin init menu
	
	class CouleurListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getSource());
			if(e.getSource()==rouge||e.getSource()==red){container.setPointerColor(Color.red);}
			else if(e.getSource()==vert||e.getSource()==green){container.setPointerColor(Color.green);}
			else {container.setPointerColor(Color.blue);}
			
		}
	}
	
	class FormeListener implements ActionListener{	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==carre || e.getSource()==square){
				container.setPointerForme("SQUARE");
			}else{
				container.setPointerForme("CIRCLE");
			}
			
		}
	}
	
	
	
	public static void main(String[] args) {
	new Fenetre() ;
	}




}
