/**
 * SirTri
 *
 * 		recursively draws a sierpinski triangle
 */

import java.awt.*;
import java.lang.Math;
public class SirTri{

	private Graphics g;
	private int cX, cY, w, depth;
	public static final int MAX_DEPTH = 7;
	private int x1, x2, x3, y1, y2, y3;

	/**
	 * Constructor
	 *
	 * @param cX - x-coord of center point of first triangle
	 * @param cY - y-coord of center point of first triangle
	 */
	public SirTri(int cX, int cY, int w){
		this.cX = cX;
		this.cY = cY;
		this.w = w;
		this.depth = 1;
	}

	/**
	 * 
	 * Getters and Setters
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
		drawFirstTri();
		recursiveTriangle( depth,
						   ((x2 - x1) / 2) + x1, 
						   ((x2 - x3) / 2) + x3,
						   ((x1 - x3) / 2) + x3,
						   ((y1 - y2) / 2) + y2,
						   ((y3 - y2) / 2) + y2,
						   ((y1 - y3) / 2) + y3);	

	}

	/**
	 * recursiveTriangle 
	 *
	 * 		recursively draws a sirpienski triangle
	 * 		
	 * @param ptOneX   - x coord of point 1
	 * @param ptTwoX   - x coord of point 2
	 * @param ptThreeX - x coord of point 3
	 * @param ptOneY   - y coord of point 1
	 * @param ptTwoY   - y coord of point 2
	 * @param ptThreeY - y coord of point 3
	 */
	public void recursiveTriangle(int n, int ptOneX, int ptTwoX, int ptThreeX, int ptOneY, int ptTwoY, int ptThreeY){
		if(n <= 1){
			return;
		}
		Polygon p = new Polygon();

		p.addPoint(ptOneX, ptOneY);
		p.addPoint(ptTwoX, ptTwoY);
		p.addPoint(ptThreeX, ptThreeY);

		recursiveTriangle( n - 1,
			              ((ptOneX   - ptTwoX  ) / 2) + ptTwoX,
			 			  ((x2       - ptOneX  ) / 2) + ptOneX,
			 			  ((x2       - ptThreeX) / 2) + ptThreeX,
			 			  ((ptOneY   - ptTwoY  ) / 2) + ptTwoY,
			 			  ((ptOneY   - x2      ) / 2) + x2,
			 			  ((ptOneY   - ptTwoY  ) / 2) + ptTwoY);

		// recursiveTriangle( n - 1,
		// 	              ((ptTwoX   - ptOneX  ) / 2) + ptOneX,
		// 	 			  ((ptTwoX   - ptThreeX) / 2) + ptThreeX,
		// 	 			  ((ptOneX   - ptThreeX) / 2) + ptThreeX,
		// 	 			  ((ptOneY   - ptTwoY  ) / 2) + ptTwoY,
		// 	 			  ((ptThreeY - ptTwoY  ) / 2) + ptTwoY,
		// 	 			  ((ptOneY   - ptThreeY) / 2) + ptThreeY);

		// recursiveTriangle( n - 1,
		// 	              ((ptTwoX   - ptOneX  ) / 2) + ptOneX,
		// 	 			  ((ptTwoX   - ptThreeX) / 2) + ptThreeX,
		// 	 			  ((ptOneX   - ptThreeX) / 2) + ptThreeX,
		// 	 			  ((ptOneY   - ptTwoY  ) / 2) + ptTwoY,
		// 	 			  ((ptThreeY - ptTwoY  ) / 2) + ptTwoY,
		// 	 			  ((ptOneY   - ptThreeY) / 2) + ptThreeY);

		g.drawPolygon(p);


	}
/**
 * drawFirstTri
 *
 * 		draws the first triangle
 */
	public void drawFirstTri(){
		Polygon p = new Polygon();

		//top point
		p.addPoint(cX, cY - w);
		this.x1 = this.cX;
		this.y1 = this.cY - this.w;
		//right point
		p.addPoint(cX + (int) Math.sqrt( (double) (w * w) - ((w * (0.5)) * (w * (0.5))) ), (int) (cX + (w * (0.5)))  );
		this.x2 = this.cX + (int) Math.sqrt( (double) (this.w * this.w) - ((this.w * (0.5)) * (this.w * (0.5))));
		this.y2 = (int) (this.cX + (this.w * (0.5))); 
		//left point
		p.addPoint(cX - (int) Math.sqrt( (double) (w * w) - ((w * (0.5)) * (w * (0.5))) ), (int) (cY + (w * (0.5)))  );
		this.x3 = this.cX - (int) Math.sqrt( (double) (this.w * this.w) - ((this.w * (0.5)) * (this.w * (0.5))));
		this.y3 = (int) (this.cY + (this.w * (0.5)));

		g.drawPolygon(p);
	}

	

}