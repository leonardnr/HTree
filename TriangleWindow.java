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

public class TriangleWindow extends JFrame implents MouseActionListener{

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
		reset();
		tri.draw(buffer);
		g.drawImage(offscreen, 0, 0, this);
	}


	/**
	 * Reset
	 *
	 * 		Erases the old image on the screen by drawing a rectangle over it
	 */
	public void reset(){
		Rectangle r = new Rectangle(this.getBounds());

		offscreen = createImage(r.width, r.height);
		buffer = offscreen.getGraphics();
		buffer.setColor(Color.white);

		buffer.clearRect(0, 0, r.width, r.height);

		if (tri == null) { // tree not created yet
			tri = new SirTri(r.width / 2, r.height / 2 + 12, 
			(int)(Math.min(r.width, r.height)*0.4));
		} else {
			tree.setX(r.width / 2);
			tree.setY(r.height / 2 + 12);
			tree.setLength((int)(Math.min(r.width, r.height)*0.4));
		}
	}

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
		TriangleWindow daSierpinski = TriangleWindow(600, 600);
	}






}