import java.io.File;
import java.io.FileNotFoundException;

import com.rath.beatmap.Beatmap;
import com.rath.beatmap.MapParser;

public class DiffCalcTest {

  public static void main(String[] args) {
    System.out.println("Running...");
    
    Beatmap bm = null;
    try {
      bm = MapParser.parse(new File(args[0]));
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    
    System.out.println(bm);
    
     
  }
}
