
package com.rath.beatmap;

/**
 * A simple coordinate object for storing an X and a Y value.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *         
 */
public class Coord {
  
  /** The X-Component of the coordinate. */
  private final int x;
  
  /** The Y-Component of the coordinate. */
  private final int y;
  
  /** Default constructor */
  public Coord(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  /**
   * Gets the X-component.
   * @return an int containing the x-value.
   */
  public int getX() {
    return x;
  }
  
  /**
   * Gets the Y-component.
   * @return an int containing the y-value.
   */
  public int getY() {
    return y;
  }
}
