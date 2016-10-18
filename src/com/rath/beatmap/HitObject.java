
package com.rath.beatmap;

/**
 * This class serves as a superclass for other HitObject types, such as hit circles, sliders, and spinners.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *         
 */
public abstract class HitObject {
  
  /** The x and y position of this hit object wrapped up in a Coord. */
  protected Coord pos;
  
  /** The time offset from 0 that this object appears. */
  protected int offset;
  
  /**
   * Constructor called from the inherited classes only.
   * 
   * @param pos the position of this hit object as a Coord.
   * @param offset the time offset of this hit object.
   */
  protected HitObject(Coord pos, int offset) {
    this.pos = pos;
    this.offset = offset;
  }
  
  /**
   * Gets this object's position.
   * @return a Coord containing the x and y position of this hit object.
   */
  public Coord getPos() {
    return this.pos;
  }
  
  /**
   * Gets the time this object appears.
   * @return an int greater than or equal to 0.
   */
  public int getOffset() {
    return this.offset;
  }
  
  /**
   * The type of HitObject this is.
   * @return HIT_CIRCLE, SLIDER, or SPINNER.
   */
  public abstract HitObjectType getType();
  
  /**
   * toString method for printing.
   * @return a String representation of the object.
   */
  public abstract String toString();
  
}
