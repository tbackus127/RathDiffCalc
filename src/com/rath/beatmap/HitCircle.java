
package com.rath.beatmap;

/**
 * This class stores a hit circle's information that wasn't already stored in the HitObject class.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *         
 */
public class HitCircle extends HitObject {
  
  /**
   * Default constructor
   * 
   * @param pos the position of this hit circle as a Coord.
   * @param offset the time offset from 0 that this circle appears.
   */
  public HitCircle(Coord pos, int offset) {
    super(pos, offset);
  }
  
  /**
   * String representation of this object.
   * 
   * @return a String with the position and offset.
   */
  @Override
  public String toString() {
    return "Circle@" + this.pos + ":T=" + this.offset;
  }

  @Override
  public HitObjectType getType() {
    return HitObjectType.HIT_CIRCLE;
  }
}
