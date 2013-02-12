/**
 * SirTri
 *
 * 		recursively draws a sierpinski triangle
 */

import java.awt.*;
public class SirTri{

	private Graphics g;
	private int cX, cY, depth;
	private Polygon p;
	public static final int MAX_DEPTH = 7;

	/**
	 * Constructor
	 *
	 * @param cX - x-coord of center point of first triangle
	 * @param cY - y-coord of center point of first triangle
	 */
	public SirTri(int cX, int cY){
		this.cX = cX;
		this.cY = cY;
		this.depth = 1;
	}

	/**
	 * 
	 * Getters and Setters
	 * 
	 *
	 */
	public int getcX(){
		return this.cX;
	}
	public void setcX(int cX){
		this.cX = cX;
	}
	public int getcY(){
		return this.cY;
	}
	public void setcY(int cY){
		this.cY = cY;
	}


    /**
	 * incrementDepth
	 *
	 * 		Increment the depth by one, unless the dpeth is greater than MAX_DEPTH, in which case it should be set to 1.
	 */
	public void incrementDepth(){
		if(this.depth >= MAX_DEPTH){
			this.depth = 1;
		}else{
			this.depth++;
		}
	}

	/**
	 *draw
	 *
	 * 		draw the htree to the screen	
	 *
	 * 		this is an accessor mehtod that calls the real private recursive method
	 *
	 * @param g - the Graphics object associated with the window
	 */
	public void draw(Graphics g){
		this.g = g;
		//recursiveTriangle();
	}

	

}