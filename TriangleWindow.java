/**
 * TriangleWindow
 *
 * 		A window with a Sierpinski triangle
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.JFrame;
import java.awt.event.*;

public class TriangleWindow extends JFrame implements MouseListener{

	private SirTri tri = null;

	// double buffering objects
	// used to eliminate flicker when resizing window
	private Image offscreen;
	private Graphics buffer;


	/**
	 * Constructor
	 *
	 * 
	 * @param width - width of window
	 * @param height - height of the window
	 */
	public TriangleWindow (int width, int height){
		super("Triangle Window");
		this.setBounds(200, 200, width, height);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.setVisible(true);
	}

	/**
	 *Paint
	 *
	 * 		draws the images to the screen
	 *
	 * 		call automatically when window needs updating
	 *
	 * @param g - graphics object
	 */
	@Override
	public void paint(Graphics g){
		//reset();
		Rectangle b = this.getBounds();
		
		if(tri == null){
			tri = new SirTri(b.width / 2, b.height / 2, b.height / 3);
		}

		

		offscreen = createImage(b.width, b.height);
		buffer = offscreen.getGraphics();
		buffer.setColor(Color.white);

		tri.draw(buffer);
		g.drawImage(offscreen, 0, 0, this);
	}


	/**
	 * Reset
	 *
	 * 		Erases the old image on the screen by drawing a rectangle over it
	 */
	// public void reset(){
	// 	Rectangle r = new Rectangle(this.getBounds());

	// 	offscreen = createImage(r.width, r.height);
	// 	buffer = offscreen.getGraphics();
	// 	buffer.setColor(Color.white);

	// 	buffer.clearRect(0, 0, r.width, r.height);

	// 	if (tri == null) { // tree not created yet
	// 		tri = new SirTri(300, 300);
	// 	} else {
	// 		tri.setX(r.width / 2);
	// 		tri.setY(r.height / 2 + 12);
	// 		tri.setLength((int)(Math.min(r.width, r.height)*0.4));
	// 	}
	// }

	/**
	 * Update
	 *
	 * 		paint the window everytime an update is needed
	 * @param g - graphic object
	 */
	public void update(Graphics g){
		paint(g);
	}

	/**
	 * Main
	 *
	 * 		creates a Triangle Window
	 */
	public static void main(String[] args){
		TriangleWindow daSierpinski = new TriangleWindow(600, 600);
	}
	/**
	 * incrementDepth
	 *
	 * 		calls the incrementDepth method of SirTri object incrementing the depth
	 */
	public void incrementDepth(){
		tri.incrementDepth();
		repaint();
	}

	/**
	 * mouseClicked
	 * 		mouse was clicked (pressed and released) on the window
	 * 		
	 * 		must be overwritten when implementing MouseListener
	 * 
	 * @param e - object holding info about the mouse event
	 */
	public void mouseClicked(MouseEvent e) {
		incrementDepth();
	}


	/**
	 * mousePressed
	 * 		mouse was pressed down
	 * 		
	 * 		must be overwritten when implementing MouseListener
	 *
	 * @param e - object holding info about the mouse event
	 */
	public void mousePressed(MouseEvent e) {

	}

	/**
	 * mouseReleased
	 * 		mouse was released after a press
	 * 
	 * 		must be overwritten when implementing MouseListener
	 *
	 * @param e - object holding info about the mouse event
	 */
	public void mouseReleased(MouseEvent e) {

	}

	/**
	 * mouseEntered
	 * 		mouse entered the window
	 * 
	 * 		must be overwritten when implementing MouseListener
	 *
	 * @param e - object holding info about the mouse event
	 */
	public void mouseEntered(MouseEvent e) {

	}

	/**
	 * mouseExited
	 * 		mouse exited the window
	 * 
	 * 		must be overwritten when implementing MouseListener
	 *
	 * @param e - object holding info about the mouse event
	 */
	public void mouseExited(MouseEvent e) {

	}






}