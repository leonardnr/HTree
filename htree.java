/**
 *HTree
 *
 * 		Recursively draws an HTree
 * 
 */


import java.awt.Graphics;
public class HTree{

	private int x, y, length, depth;
	private Graphics g;

	public static final int MAX_DEPTH = 7;

	/**
	 *Constructor
	 *
	 * @param x - center x position of the htree
	 * @param y - center y position of the htree
	 * @param length - the length of the middle bar of the H
	 */
	public HTree(int x, int y, int length){
		this.x = x;
		this.y = y;
		this.length = length;
		this.depth = 1;
	}

}