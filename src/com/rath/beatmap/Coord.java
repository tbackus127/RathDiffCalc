
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
   * 
   * @return an int containing the x-value.
   */
  public int getX() {
    return x;
  }

  /**
   * Gets the Y-component.
   * 
   * @return an int containing the y-value.
   */
  public int getY() {
    return y;
  }

  /**
   * toString() method.
   * 
   * @return a string in the format: "(X,Y)"
   */
  @Override
  public String toString() {
    return "(" + this.x + "," + this.y + ")";
  }

  /**
   * Calculates the distance between two Coords.
   * 
   * @param a the initial position as a Coord.
   * @param b the destination position as a Coord.
   * @return the distance between the two Coords, as a double using the distance
   *         formula.
   */
  public static double calcDistance(Coord a, Coord b) {
    final int ax = a.getX();
    final int ay = a.getY();
    final int bx = b.getX();
    final int by = b.getY();
    double d1 = Math.abs(Math.pow((bx - ax), 2));
    double d2 = Math.abs(Math.pow(by - ay, 2));
    return Math.sqrt(d1 + d2);
  }
  
  /**
   * Calculates the angle between two Coords.
   * 
   * @param a the initial position as a Coord.
   * @param b the destination position as a Coord.
   * @return the angle between the two Coords, as a double.
   */
  public static final double calcAngle(Coord a, Coord b) {
    int dx = b.getX() - a.getX();
    int dy = b.getY() - b.getY();
    return Math.atan2(dy, dx);
  }

}
