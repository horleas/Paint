package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panneau extends JPanel{
	private Color pointerColor = Color.red;
	private String pointerForme = "CIRCLE";
	private int posX = -10, oldX = -10 ;
	private int posY = -10, oldY = -10 ;
	private boolean erasing = true;
	private int pointerSize = 15;
	private ArrayList<Point> points = new ArrayList<Point>();
	
	public Panneau(){
		
		this.addMouseMotionListener(new MouseMotionListener(){
		

			@Override
			public void mouseDragged(MouseEvent e) {
				points.add(new Point(e.getX() - (pointerSize/2),e.getY()- (pointerSize/2),pointerSize,pointerColor,pointerForme));
				repaint();
				
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				
			}
		});
		
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				points.add(new Point(e.getX() - (pointerSize/2),e.getY()- (pointerSize/2),pointerSize,pointerColor,pointerForme));
				repaint();
			}
		});	
	}
	
public void paintComponent(Graphics g){
	
	g.setColor(Color.white);
	g.fillRect(0, 0, this.getWidth(), this.getHeight());
	
	if(this.erasing){
		this.erasing=false;
	}
	else{
		for(Point p : this.points){
			g.setColor(p.getColor());
			
			if(p.getForme().equals("SQUARE")){
				g.fillRect(p.getX(), p.getY(), p.getSize(), p.getSize());
			}else{
				g.fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());
			}
		}
		
	}	
}
	
	
	
	
	public void setPointerForme(String forme) {
		System.out.println("tu veux que je change la forme en " + forme);
		this.pointerForme = forme;
		
	}

	public void setPointerColor(Color color) {
		System.out.println("tu veux que je change la couleur par " + color);
		this.pointerColor = color;
		
	}
	
	public void efface(){	
		System.out.println("tu veux que j'efface");
		this.erasing=true;
		this.points = new ArrayList<Point>();
		
	}

}
